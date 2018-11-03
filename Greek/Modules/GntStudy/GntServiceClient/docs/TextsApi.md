# TextsApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getChapter**](TextsApi.md#getChapter) | **GET** /v1/texts/chapter/{book}/{chapter} | Get text of a chapter


<a name="getChapter"></a>
# **getChapter**
> Chapter getChapter(book, chapter)

Get text of a chapter

Returns all verses related to a chapter!

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TextsApi;


TextsApi apiInstance = new TextsApi();
String book = "book_example"; // String | book name Id
Integer chapter = 56; // Integer | Chapter number
try {
    Chapter result = apiInstance.getChapter(book, chapter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TextsApi#getChapter");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **book** | **String**| book name Id |
 **chapter** | **Integer**| Chapter number |

### Return type

[**Chapter**](Chapter.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

