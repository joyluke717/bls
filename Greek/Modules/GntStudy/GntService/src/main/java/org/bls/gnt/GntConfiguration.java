package org.bls.gnt;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.bls.gnt.config.DataSourceFactory;
import org.bls.gnt.config.EmbeddedDataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;

public class GntConfiguration extends Configuration {
	@Valid
	@NotNull
	private HttpClientConfiguration httpClientConfig = new HttpClientConfiguration();
	
    @Valid
    @JsonProperty("mybatisConfig")
    private String mybatisConfig;

	@JsonProperty("httpClient")
	public HttpClientConfiguration getHttpClientConfiguration() {
		return httpClientConfig;
	}

	@JsonProperty("httpClient")	
	public void setHttpClientConfiguration(HttpClientConfiguration httpClientConfig) {
		this.httpClientConfig = httpClientConfig;
	}

	@Valid
	@JsonProperty("db")
	private DataSourceFactory dataSourceFactory;

	public String getMybatisConfig() {
		return mybatisConfig;
	}

	public void setMybatisConfig(String mybatisConfig) {
		this.mybatisConfig = mybatisConfig;
	}
	
	public DataSourceFactory getDataSourceFactory() {
		if (dataSourceFactory == null) {
			return new EmbeddedDataSourceFactory();
		}
		return dataSourceFactory;
	}

	public void setDataSourceFactory(DataSourceFactory factory) {
		this.dataSourceFactory = factory;
	}
}
