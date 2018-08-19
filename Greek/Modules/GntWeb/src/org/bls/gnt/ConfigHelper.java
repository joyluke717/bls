/*
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

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigHelper {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigHelper.class);
    
    private static GnntServiceContext instance = null;
    
    public static GnntServiceContext getGntServiceContext() {
    	
    	if (instance == null) {
    		try {
    			instance = setupContext();
    		}
    		catch (Exception e) {
    			return null;
    		}
    	}
    	return instance;    		
    }
 
    public static GnntServiceContext setupContext() throws Exception {
        GnntServiceContext context = new GnntServiceContext();

        // Create SqlSessionFactory       
        String resource = "mybatis/mybatis-config.xml";
        LOG.info("Using mybatis config: " + resource);
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
        context.setSqlSessionFactory(sqlSessionFactory);
  
        return context;
    }
}