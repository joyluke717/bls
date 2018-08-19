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
package org.bls.gnt.db;

import java.util.Date;

public class DAOTestDataHelper {
	
	public final static String dbFile = "/sql/gnt.sql"; 
	public final static  String resource = "mybatis/mybatis-config.xml";
	  
    public final static String DEFAULT_BASE_DIR = "/tmp/cible/deploy-unit-test";
    public final static String DEFAULT_DB_NAME = "gnt";
    public final static int DEFAULT_PORT = 3303;

    public final static Date currentTime ;
    
    static {
    		long currentTime_sec = System.currentTimeMillis();
		currentTime = new Date(currentTime_sec);
    }
}
