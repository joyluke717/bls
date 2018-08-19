/**
 * Copyright 2016 Huawei, Inc.
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
package org.bls.gnt.config;

import java.io.File;
//import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.bls.gnt.db.DatabaseUtil;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mysql.management.driverlaunched.ServerLauncherSocketFactory;

@JsonTypeName("embedded")
public class EmbeddedDataSourceFactory implements DataSourceFactory {

    public final static String DEFAULT_BASE_DIR = "/tmp/cible/deploy-unit-test";
    private final static String DEFAULT_DB_NAME = "cible";
    private final static int DEFAULT_PORT = 3305;

    //		BasicDataSource DATASOURCE = DatabaseUtil.createMXJDataSource(DEFAULT_DB_NAME,
//				DEFAULT_BASE_DIR, DEFAULT_PORT);

    @JsonProperty
    private String workDir = DEFAULT_BASE_DIR;

    public String getWorkDir() {
        return workDir;
    }

    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

    public BasicDataSource build() throws Exception {
//        try {
            // making sure we do not have anything running
            ServerLauncherSocketFactory.shutdown(new File(workDir), null);
//        } catch (Exception e) {
//            // ignore
//        }

        BasicDataSource
            DATASOURCE =
            DatabaseUtil.createMXJDataSource(DEFAULT_DB_NAME, workDir, DEFAULT_PORT);
//        Connection conn = DATASOURCE.getConnection();
        //ScriptRunner runner = new ScriptRunner(conn, false, false);
        //runner.runScript(new BufferedReader(new InputStreamReader(
        //    DatabaseUtil.class.getResourceAsStream("/sql/deploy.sql"))));
        return DATASOURCE;
    }
}
