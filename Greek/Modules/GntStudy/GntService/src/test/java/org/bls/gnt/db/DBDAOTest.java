/**
 * Copyright 2016 HuaWei, Inc.
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
package org.bls.gnt.db;


import java.io.File;

import org.apache.ibatis.session.SqlSessionFactory;
import org.bls.gnt.db.dao.GntTextDAO;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.management.driverlaunched.ServerLauncherSocketFactory;

public class DBDAOTest {

    private static SqlSessionFactory sqlSessionFactory;

    private static GntTextDAO hostDAO;
   

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

        hostDAO = new DBGntTextDAOImpl(sqlSessionFactory);
        
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
    public void testHostQuery() throws Exception {

    }

}
