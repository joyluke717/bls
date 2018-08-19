/*
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.jdbc.ScriptRunner;

public class DAOTestDBHelper {

    public static void setupMXJDb(String dbFile) throws Exception {

        BasicDataSource DATASOURCE = DatabaseUtil.createMXJDataSource(DAOTestDataHelper.DEFAULT_DB_NAME,
                DAOTestDataHelper.DEFAULT_BASE_DIR, DAOTestDataHelper.DEFAULT_PORT);
        Connection conn = DATASOURCE.getConnection();
        ScriptRunner runner = new ScriptRunner(conn, false, true);
        runner.setLogWriter(null);
        String tmpSQLfileMXJ = makeMXJcompatable(dbFile);
        runner.runScript(new BufferedReader(new InputStreamReader(new FileInputStream(tmpSQLfileMXJ), StandardCharsets.UTF_8)));
    }

    public static SqlSessionFactory setUpSqlSessionFactor(String resource) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        return sqlSessionFactory;
    }

    public static String makeMXJcompatable(String sqlFileMysql) throws Exception {

        // Create Temporary SQL File for MXJ
        File tmpfile = File.createTempFile("mxj", ".sql");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpfile), StandardCharsets.UTF_8));

        List<String> tblbuffer = new ArrayList<>();
        int tblbufferidx = 0;
        int tblnameidx = -1;
        int tblnameval = -1;
        HashMap<String, Integer> tblfields = new HashMap<>();

        int MAXINDEX = 767;

        HashMap<String, Integer> fldsizelist = new HashMap<>();
        fldsizelist.put("BIGINT", 8);   // 8 bytes. Range:
        // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // or 0 to 18,446,744,073,709,551,615 unsigned.
        fldsizelist.put("BIT", 1);      // Byte full of boolean bits.
        // About(Length + 7)/8 bytes.
        fldsizelist.put("DATETIME", 8); // 8 bytes. Format
        // of YYYY-MM-DD HH:MM:SS.
        fldsizelist.put("DATE", 3);     // 3 bytes. Format of YYYY-MM-DD.
        fldsizelist.put("DOUBLE", 8);   // 8 bytes. Scientific notation.
        fldsizelist.put("FLOAT", 4);    // 4 bytes. Scientific notation.
        fldsizelist.put("INT", 4);      // 4 bytes -2.1 to 2.1 billion.
        fldsizelist.put("LONGTEXT", 1288490191); //Len+4bytes. Max 4 bill
        fldsizelist.put("MEDIUMINT", 3);// 3 bytes Range: -2.1 to 2.1 bill
        fldsizelist.put("MEDIUMTEXT", 50331648); // len+3 bytes 16mil chars
        fldsizelist.put("SMALLINT", 2); // 2 bytes. -32,768to32,767
        fldsizelist.put("TEXT", 196607);// Len(65535 max)*3+2 bytes.
        fldsizelist.put("TIME", 3);     // 3 bytes # In the format of HH:MM:SS
        fldsizelist.put("TIMESTAMP", 4);  // 4 bytes. YYYYMMDDHHMMSS;  Ends 2037.
        fldsizelist.put("TINYTEXT", 766);  //len+1 bytes. Max 255 chars.
        fldsizelist.put("TINYINT", 1);  // 1 byte. Range of -128 to 127
        // DECIMAL[Length, Decimals] Length + 1 or Length + 2 bytes
        // A DOUBLE stored as a string, fixed decimal point.
        // ENUM 1 or 2 bytes. Numerical enumeration of values.
        // SET 1-4 or 8 bytes. Like ENUM but multiples.
        // NOTE: UTF-8 requires 1-3 bytes in Mysql instead of 1-4.


        BufferedReader br = new BufferedReader(
                new InputStreamReader(DAOTestDBHelper.class.getResourceAsStream(sqlFileMysql), StandardCharsets.UTF_8));

        // IF FILE CAN BE OPENED
        for (String line; (line = br.readLine()) != null; ) {
            // FIXES OUTSIDE CREATE TABLE STRUCTURE:
            //#####################################################################################
            //   FIX 1:  Ignore everything on and including: use `report`
            Pattern patternUseReport = Pattern.compile("USE\\s+`report`");
            Matcher matcherUseReport = patternUseReport.matcher(line);
            if (matcherUseReport.find()) {
                break;
            }

            //   FIX 2:  Remove DEFAULT CURRENT_TIMESTAMP (and associated NOT NULL, if it is there.)
            line = line.replaceAll("NOT NULL DEFAULT CURRENT_TIMESTAMP", "NULL");
            line = line.replaceAll("DEFAULT CURRENT_TIMESTAMP", "");

            //   FIX 3:  Remove DROP TABLE IF EXISTS except for `cible`.`deployment.template`
            Pattern patternDropTableIfExists = Pattern.compile("DROP TABLE IF EXISTS `(.*?)`.`(.*?)`");
            Matcher matcherDropTableIfExists = patternDropTableIfExists.matcher(line);
            if (matcherDropTableIfExists.find() && !(matcherDropTableIfExists.group(1).equals("cible") && matcherDropTableIfExists.group(2).equals("deployment_template"))) {
                continue;
            }
            //   FIX 4: Switch around CREATE SCHEMA  -- NOT IMPLEMENTED
            //   FIX 5: Add to create schema report: DEFAULT CHARACTER SET utf8  -- NOT IMPLEMENTED
            //#####################################################################################

            // FIXES WITHIN CREATE TABLE STRUCTURE:
            //#####################################################################################
            //   FIX 6: message` VARCHAR(20480) => `message` VARCHAR(1024)  -- NOT IMPLEMENTED
            line = line.replaceAll("VARCHAR(20480)", "VARCHAR(1024)");

            //   FIX 7: `scope` CHAR(8) NOT NULL DEFAULT 'cible' => `scope` CHAR(8) NULL DEFAULT NULL, -- NOT IMPLEMENTED
            Pattern patternScope = Pattern.compile("`scope`(.*?)NOT NULL DEFAULT '.*?'");
            Matcher matcherScope = patternScope.matcher(line);
            if (matcherScope.find()) {
                line = "  `scope`" + matcherScope.group(1) + "NULL DEFAULT NULL,";
            }

            //   FIX 8: DETECT INDEX OVERFLOW AND SHORTEN THE NAME FIELD ACCORDINGLY, ELSE THROW AN ERROR
            // PROCESS CREATE TABLE STMTS
            Pattern patternCreateTable = Pattern.compile("CREATE\\s+TABLE.*?(`.*`)");
            Matcher matcherCreateTable = patternCreateTable.matcher(line);
            if (matcherCreateTable.find()) {
                bw.write(String.join("\n", tblbuffer));
                tblbuffer.clear(); // Clear STMT buffer
                tblfields.clear(); // Clear Field cache
                tblnameidx = -1;  // The name field has not been located yet.
                tblnameval = -1;  // The name field has not been located yet.
                tblbufferidx = 0;
            }
            tblbuffer.add(tblbufferidx++, line);  // Buffer current line

            // PROCESS INDEXES (ASSUME AFTER CREATE TABLE)
            Pattern patternIndex = Pattern.compile("INDEX.*?`(\\w+)`.*?\\((.*)\\)");
            Matcher matcherIndex = patternIndex.matcher(line);
            if (matcherIndex.find()) {

                // GRAB FIELDS AND DISCARD EVERYTHING ELSE FROM INDEX DECLARATION
                List<String> list = new ArrayList<>(Arrays.asList(matcherIndex.group(2).split("\\s+")));
                ListIterator i = list.listIterator();
                while (i.hasNext()) {
                    String s = (String) i.next();
                    Pattern patternField = Pattern.compile("`(\\w+)`");
                    Matcher matcherField = patternField.matcher(s);
                    if (matcherField.find()) {
                        i.set(matcherField.group(1));
                    } else {
                        i.remove();
                    }

                }

                // GO THROUGH FIELDS OF INDEX AND CALCULATE SIZE OF INDEX
                int idx = 0;
                for (String s : list) {
                    if (tblfields.get(s) == null) {
                        System.out.println("E: Not an identified field type: " + s);
                        tblfields.put(s, 8);
                    }
                    idx += tblfields.get(s);
                }

                // IS INDEX TOO BIG? THEN SHORTEN THE name FIELD
                if (idx > MAXINDEX) {
                    // Faster than Math.ceil and doesn't require special casting.
                    int tmpdiff = (idx-MAXINDEX)/3 + (((idx-MAXINDEX) % 3 == 0) ? 0 : 1);
                    if (tblnameidx < 0) {
                        System.out.println("E: No name field is present. Auto correction not possible.");
                    } else {
                        String tmporigstr = '(' + String.format("%d", tblnameval) + ')';
                        int tmpnewsize = tblnameval - tmpdiff;
                        String tmpnewstr = String.format("%d", tmpnewsize);
                        // REDUCE THE FIELD name TO THE RIGHT SIZE AND ADD A COMMENT REGARDING WHAT WE DID
                        //String tmpbuffer = tblbuffer.get(tblnameidx).replaceAll(tmporigstr, tmpnewstr) + " -- was size " + (tmporigstr);
                        String tmpbuffer = tblbuffer.get(tblnameidx).replaceAll(tmporigstr, tmpnewstr);
                        tblbuffer.set(tblnameidx, tmpbuffer);
                    }
                }
            }

            // PROCESS FIELD DECLARATIONS (WITHIN CREATE TABLE)
            Pattern patternFieldDecl = Pattern.compile("^\\s+`(\\w+)`\\s+(.*)");
            Matcher matcherFieldDecl = patternFieldDecl.matcher(line);
            if (matcherFieldDecl.find()) {
                String field = matcherFieldDecl.group(1);
                String rest = matcherFieldDecl.group(2);

                // IF FIELD IS CALLED 'name', REMEMBER ITS POSITION
                if (field.equals("name")) {
                    tblnameidx = tblbufferidx - 1;
                }

                // IF SIZE OF FIELD IS PROVIDED, THEN DETERMINE BYTES BASED ON FIELD TYPE AND SIZE
                Pattern patternFieldDeclType1 = Pattern.compile("(\\w+)\\((\\d+)\\).*,");
                Matcher matcherFieldDeclType1 = patternFieldDeclType1.matcher(line);
                if (matcherFieldDeclType1.find()) {
                    String fieldtype = matcherFieldDeclType1.group(1).toUpperCase();
                    int fieldsize = Integer.parseInt(matcherFieldDeclType1.group(2));

                    // IS FIXED SIZED FIELD? (DESPITE HAVING A SIZE PARAMETER)? (i.e. INT, FLOAT, etc.)
                    if (fldsizelist.get(fieldtype) != null) {
                        tblfields.put(field, fldsizelist.get(fieldtype));

                        // IF MUST USE SIZE PARAMETER, CALCULATE DIRECTLY
                    } else {
                        switch (fieldtype) {
                            case "VARCHAR":
                                tblfields.put(field, fieldsize * 3 + 1);  // UTF-8 is 1-4 bytes, but mysql uses 1-3
                                if (field.equals("name")) {
                                    tblnameval = fieldsize;
                                }
                                break;
                            case "CHAR":
                                tblfields.put(field, fieldsize * 3);
                                break;
                            case "BIT":
                                // Faster than Math.ceil and doesn't require special casting.
                                tblfields.put(field, (fieldsize + 7) / 8 + (((fieldsize + 7) % 8 == 0) ? 0 : 1));
                                break;
                            default:
                                System.out.println("E: Unknown type " + fieldtype + " of size " + fieldsize);  // FIELD TYPE EXCEPTION" +
                                break;
                        }
                    }
                    // SIZE OF FIELD NOT PROVIDED.  DETERMINE BYTE SIZE OF FIELD BY FIELD TYPE ALONE
                } else {
                    Pattern patternFieldDeclType2 = Pattern.compile("(\\w+).*?,");
                    Matcher matcherFieldDeclType2 = patternFieldDeclType2.matcher(rest);
                    if (matcherFieldDeclType2.find()) {
                        String fieldtype = matcherFieldDeclType2.group(1).toUpperCase();
                        if (fldsizelist.get(fieldtype) == null) {
                            System.out.println("E: Unknown type " + fieldtype); // FIELD TYPE EXCEPTION
                        } else {
                            tblfields.put(field, fldsizelist.get(fieldtype));
                        }
                    }
                }
            }
        }
        // DUMP LAST BUFFER
        tmpfile.deleteOnExit();
        bw.write(String.join("\n", tblbuffer));
        bw.close();
	br.close();
        //#####################################################################################

        return tmpfile.getCanonicalFile().toString();
    }

    public static void resetDb(SqlSessionFactory sqlSessionFactory, String dbFile) throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        ScriptRunner runner = new ScriptRunner(conn, false, true);
        runner.setLogWriter(null);
        String tmpSQLfileMXJ = makeMXJcompatable(dbFile);
        runner.runScript(new BufferedReader(new InputStreamReader(new FileInputStream(tmpSQLfileMXJ), StandardCharsets.UTF_8)));
        session.close();
    }
}
