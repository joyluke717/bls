# LexiconApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllLexicion**](LexiconApi.md#getAllLexicion) | **GET** /v1/lexicions/all | Get all deployment


<a name="getAllLexicion"></a>
# **getAllLexicion**
> List&lt;GntLexiconBean&gt; getAllLexicion()

Get all deployment

Returns all deployment

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LexiconApi;


LexiconApi apiInstance = new LexiconApi();
try {
    List<GntLexiconBean> result = apiInstance.getAllLexicion();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LexiconApi#getAllLexicion");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;GntLexiconBean&gt;**](GntLexiconBean.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

