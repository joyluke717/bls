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
package org.bls.gnt.db.dao;

import org.bls.gnt.db.model.GntLexiconBean;
import org.bls.gnt.db.model.GntTextBean;


/**
 * A collection of methods to help hosts
 */
public interface GntVocabularyDAO {
	void insertGntText(GntTextBean word) throws Exception;
	
	void insertGntLexicon(GntLexiconBean lexicion) throws Exception;
}
