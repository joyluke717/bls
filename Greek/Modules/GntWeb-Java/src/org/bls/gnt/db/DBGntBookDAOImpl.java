package org.bls.gnt.db;
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


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.bls.gnt.db.dao.GntBookDAO;
import org.bls.gnt.db.mapper.GntWordMapper;
import org.bls.gnt.db.model.GntWord;
import org.bls.gnt.db.model.GntWordExample;

public class DBGntBookDAOImpl implements GntBookDAO {

	private SqlSessionFactory sqlSessionFactory;

	public DBGntBookDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insertGntWord(GntWord record) throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			GntWordMapper mapper = session.getMapper(GntWordMapper.class);
			mapper.insert(record);
			session.commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<GntWord> getAllWords() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			GntWordMapper mapper = session.getMapper(GntWordMapper.class);
			GntWordExample example = new GntWordExample();
			return mapper.selectByExample(example);
			
		} catch (Exception e) {
			throw e;
		}
	}
}
