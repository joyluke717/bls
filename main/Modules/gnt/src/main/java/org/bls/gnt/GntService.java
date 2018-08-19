/**
 * Copyright 2016 HuaWei, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bls.gnt;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.apache.http.impl.client.CloseableHttpClient;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

public class GntService extends Application<GntConfiguration> {
	@Override
	public String getName() {
		return "gnt-service";
	}

	public static void main(String[] args) throws Exception {
		new GntService().run(args);
	}
	
	@Override
	public void initialize(final Bootstrap<GntConfiguration> bootstrap) {
		// Enable variable substitution with environment variables
		bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
		bootstrap.addBundle(new ViewBundle());    
	}

	@Override
	public void run(final GntConfiguration configuration, final Environment environment) throws Exception {
		environment.jersey().register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(configuration).to(GntConfiguration.class);
			}
		});

		GnntServiceContext serviceContext = ConfigHelper.setupContext(configuration);
		
		HttpClientBuilder hcb = new HttpClientBuilder(environment).using(configuration.getHttpClientConfiguration()); 
		final CloseableHttpClient httpClient = hcb.build("Http Client");
	
		//Books hosts = new Books(serviceContext);
		//environment.jersey().register(hosts);
	// Swagger API docs generation related
		environment.jersey().register(new ApiListingResource());
		environment.jersey().register(new SwaggerSerializers());
		BeanConfig config = new BeanConfig();
		config.setTitle("Gnt API Docs xxxxxx");
		config.setVersion("1.0.0");
		config.setResourcePackage("org.bls.gnt.resources");
		config.setScan(true);

		// Enable CORS headers
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
		filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
		filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER, "true");
		filter.setInitParameter("allowedHeaders",
				"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
		filter.setInitParameter("allowCredentials", "true");
	}
}
