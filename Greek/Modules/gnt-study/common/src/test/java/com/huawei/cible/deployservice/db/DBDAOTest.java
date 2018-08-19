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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.blem.greek.dao.GreekDAO;
import org.blem.greek.db.DBGreekDAOImpl;
import org.blem.greek.db.exception.DBRecordReadOnlyException;
import org.blem.greek.db.model.DeploymentBean;
import org.blem.greek.db.model.DeploymentGroupBean;
import org.blem.greek.db.model.DeploymentGroupMappingBean;
import org.blem.greek.db.model.DeploymentPolicyBean;
import org.blem.greek.db.model.DeploymentTemplateBean;
import org.blem.greek.db.model.DeploymentUnitBean;
import org.blem.greek.db.model.HostBean;
import org.blem.greek.db.model.HostDeploymentBean;
import org.blem.greek.db.model.HostDeploymentTokenBean;
import org.blem.greek.db.model.HostTagBean;
import org.blem.greek.db.model.PackageBean;
import org.blem.greek.db.model.PackageGroupBean;
import org.blem.greek.db.model.PackageGroupMappingBean;
import org.blem.greek.db.model.TagTargetMappingBean;
import org.blem.greek.type.DeploymentPolicyLevel;
import org.blem.greek.type.TagStatus;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.management.driverlaunched.ServerLauncherSocketFactory;

public class DBDAOTest {

    private static SqlSessionFactory sqlSessionFactory;
    
    private static GreekDAO hostDAO;
 
        
    @BeforeClass
    public static void setUpClass() throws Exception {
       try {
            // making sure we do not have anything running
            ServerLauncherSocketFactory.shutdown(new File(DAOTestDataHelper.DEFAULT_BASE_DIR), null);
        } catch (Exception e) {
            throw e;
        }
        
        DAOTestDBHelper.setupMXJDb(DAOTestDataHelper.dbFile);
        sqlSessionFactory = DAOTestDBHelper.setUpSqlSessionFactor(DAOTestDataHelper.resource);
     
        hostDAO = new DBGreekDAOImpl(sqlSessionFactory);
       
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        ServerLauncherSocketFactory.shutdown(new File(DAOTestDataHelper.DEFAULT_BASE_DIR), null);
    }
    
    @Before
    public void setUpTest() throws Exception {
    		DAOTestDBHelper.resetDb(sqlSessionFactory, DAOTestDataHelper.dbFile);
    }


    @Test
    public void testHostQuery() throws Exception 
    {       
	    	List<HostBean> hostList = DAOTestDataHelper.getHostList();
	    	for(HostBean host : hostList) {
	    		hostDAO.insert(host);
	    	}
	    	
	    	HostBean host1 = hostDAO.getHostByIp(DAOTestDataHelper.TEST_IP1);
	    	assertNotNull(host1);
	    	
	    	List<HostBean> hostListDc = hostDAO.getHostsInDataCenter("az2");
	    	assertNotNull(hostListDc);
	    	assertEquals(2, hostListDc.size());
	}
}
