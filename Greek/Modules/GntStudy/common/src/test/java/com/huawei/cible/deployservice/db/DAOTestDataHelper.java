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
package com.huawei.cible.deployservice.db;

import java.util.Date;
import java.util.List;

import org.bls.gnt.db.model.GntWordBean;

public class DAOTestDataHelper {
	
	public final static String dbFile = "/sql/cible-v2.sql"; 
	public final static  String resource = "mybatis/mybatis-config.xml";
	  
    public final static String DEFAULT_BASE_DIR = "/tmp/cible/deploy-unit-test";
    public final static String DEFAULT_DB_NAME = "cible";
    public final static int DEFAULT_PORT = 3303;

	// To avoid pmd AvoidUsingHardCodedIP rule
    public final static String TEST_IP1 = "10.0.0." + "1";
    public final static String TEST_IP2 = "10.0.0." + "2";
    public final static String TEST_IP3 = "10.0.0." + "3";
    public final static Date currentTime ;
    
    static {
    		long currentTime_sec = System.currentTimeMillis();
		currentTime = new Date(currentTime_sec);
    }
			
	public static List<GntWordBean> getWordList() {
		
		return null;
	}


}
