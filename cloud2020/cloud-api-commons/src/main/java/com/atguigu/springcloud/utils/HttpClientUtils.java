package com.atguigu.springcloud.utils;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class HttpClientUtils {

    public String post(String url, String body, Map<String,String> headers) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        try {
            if (!StringUtils.isEmpty(body)){
                HttpEntity entity = new StringEntity(body);
                post.setEntity(entity);
            }
            if (StringUtils.isEmpty(headers)){
                for (Map.Entry<String,String> header:headers.entrySet()) {

                }

            }
            HttpResponse execute = httpClient.execute(post);
            StatusLine statusLine = execute.getStatusLine();
            System.out.println(statusLine.getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


        return null;
    }

    @Test
    public void test(){

    }
}
