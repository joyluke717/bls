/**
 * Copyright 2016 HuaWei, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.blem.greek.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.blem.greek.dao.GreekDAO;
import org.blem.greek.db.mapper.GntWordBeanMapper;
import org.blem.greek.db.model.GntWordBean;


public class DBGreekDAOImpl implements GreekDAO {
	private SqlSessionFactory sqlSessionFactory;

	public DBGreekDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insert(GntWordBean gntWord) throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			GntWordBeanMapper mapper = session.getMapper(GntWordBeanMapper.class);
			mapper.insert(gntWord);
			session.commit();
		} catch (Exception e) {
			throw e;
		}
	}
}
