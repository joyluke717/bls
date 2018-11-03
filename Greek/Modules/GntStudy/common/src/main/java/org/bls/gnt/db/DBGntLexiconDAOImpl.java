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
import org.bls.gnt.db.dao.GntLexiconDAO;
import org.bls.gnt.db.mapper.GntLexiconBeanMapper;
import org.bls.gnt.db.model.GntLexiconBean;
import org.bls.gnt.db.model.GntLexiconBeanExample;

public class DBGntLexiconDAOImpl implements GntLexiconDAO {

	private SqlSessionFactory sqlSessionFactory;

	public DBGntLexiconDAOImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insertGntLexicon(GntLexiconBean record) throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			GntLexiconBeanMapper mapper = session.getMapper(GntLexiconBeanMapper.class);
			mapper.insert(record);
			session.commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<GntLexiconBean> getAll() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			GntLexiconBeanMapper mapper = session.getMapper(GntLexiconBeanMapper.class);
			GntLexiconBeanExample example = new GntLexiconBeanExample();
			return mapper.selectByExample(example);
		} catch (Exception e) {
			throw e;
		}
	}
}
