/*
 * Gnt API Docs!
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Chapter;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TextsApi
 */
@Ignore
public class TextsApiTest {

    private final TextsApi api = new TextsApi();

    
    /**
     * Get text of a chapter
     *
     * Returns all verses related to a chapter!
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getChapterTest() throws ApiException {
        String book = null;
        Integer chapter = null;
        Chapter response = api.getChapter(book, chapter);

        // TODO: test validations
    }
    
}