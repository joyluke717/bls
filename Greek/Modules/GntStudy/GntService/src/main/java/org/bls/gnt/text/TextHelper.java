/**
 * Copyright 2016 Huawei, Inc.
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
package org.bls.gnt.text;

import java.util.ArrayList;
import java.util.List;

import org.bls.gnt.GntServiceContext;
import org.bls.gnt.api.model.Chapter;
import org.bls.gnt.api.model.Verse;
import org.bls.gnt.db.DBGntTextDAOImpl;
import org.bls.gnt.db.dao.GntTextDAO;
import org.bls.gnt.db.model.GntTextBean;

public class TextHelper {
		
	private GntTextDAO gntTextDAO;

	public TextHelper(GntServiceContext context) {
		this.gntTextDAO = new DBGntTextDAOImpl(context.getSqlSessionFactory());
	}

	public Chapter getChapter(String bookName, int chapterNumber) throws Exception {
		List<GntTextBean> textBeanList = this.gntTextDAO.getChapter(bookName, chapterNumber);
		Chapter chapter = new Chapter();
		chapter.setBookName(bookName);
		chapter.setChapterNumber(chapterNumber);
		chapter.setVerseList(new ArrayList<Verse>());
		int lastVerse = 0;
		Verse verse = null;
		StringBuilder stringBuilder = null;
		for (GntTextBean bean : textBeanList) {
			
			int curVerse = bean.getVerseNumber();
			if (curVerse != lastVerse) {
				if (curVerse != 1) {
					verse.setVerseText(stringBuilder.toString());
					chapter.getVerseList().add(verse);
				}
				verse = new Verse();
				verse.setVerseNumber(curVerse);
				stringBuilder = new StringBuilder();
			}
			else {
				stringBuilder.append(bean.getText());
				stringBuilder.append(" ");
			}
			lastVerse = curVerse;
		}
		verse.setVerseText(stringBuilder.toString());
		chapter.getVerseList().add(verse);
		return chapter;
	}
}
