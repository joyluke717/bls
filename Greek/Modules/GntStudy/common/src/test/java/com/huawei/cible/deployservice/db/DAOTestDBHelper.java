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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bls.gnt.db.DatabaseUtil;

import com.ibatis.common.jdbc.ScriptRunner;

public class DAOTestDBHelper {

	public static void setupMXJDb(String dbFile) throws Exception {

		BasicDataSource DATASOURCE = DatabaseUtil.createMXJDataSource(DAOTestDataHelper.DEFAULT_DB_NAME,
				DAOTestDataHelper.DEFAULT_BASE_DIR, DAOTestDataHelper.DEFAULT_PORT);
		Connection conn = DATASOURCE.getConnection();
		ScriptRunner runner = new ScriptRunner(conn, false, true);
		runner.setLogWriter(null);
		runner.runScript(new BufferedReader(
				new InputStreamReader(DAOTestDBHelper.class.getResourceAsStream(dbFile), StandardCharsets.UTF_8)));
	}

	public static SqlSessionFactory setUpSqlSessionFactor(String resource) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		return sqlSessionFactory;
	}

	public static void resetDb(SqlSessionFactory sqlSessionFactory, String dbFile) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		ScriptRunner runner = new ScriptRunner(conn, false, true);
		runner.setLogWriter(null);
		runner.runScript(new BufferedReader(
				new InputStreamReader(DAOTestDBHelper.class.getResourceAsStream(dbFile), StandardCharsets.UTF_8)));
		session.close();
	}
}
