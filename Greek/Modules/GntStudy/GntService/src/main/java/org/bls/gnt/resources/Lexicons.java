/**
 * Copyright 2016 Huawei, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bls.gnt.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.bls.gnt.GntServiceContext;
import org.bls.gnt.db.DBGntLexiconDAOImpl;
import org.bls.gnt.db.dao.GntLexiconDAO;
import org.bls.gnt.db.model.GntLexiconBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Path("/v1/lexicions")
@Api(tags = "Lexicon")
@SwaggerDefinition(tags = { @Tag(name = "Deployments", description = "Deployment info APIs"), })
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Lexicons {
	
	private static final Logger LOG = LoggerFactory.getLogger(Lexicons.class);
	
	private GntLexiconDAO gntLexiconDAO;

	public Lexicons(GntServiceContext context) {
		this.gntLexiconDAO = new DBGntLexiconDAOImpl(context.getSqlSessionFactory());
	}

	
	@GET
	@Path("/all")
	@ApiOperation(value = "Get all deployment", notes = "Returns all deployment")
	public List<GntLexiconBean> getAllLexicion(@Context SecurityContext securityContext) throws Exception {
		try {
			return gntLexiconDAO.getAll();
		} catch (Exception e) {
			LOG.error("Failed to get all deployment", e.getMessage());
			throw e;
		}
	}
}
