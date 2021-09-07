package com.atguigu.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.model.vo.RequestVo;
import com.atguigu.springcloud.model.vo.ResponseVo;
import com.atguigu.springcloud.utils.JsonUtils;
import com.netflix.loadbalancer.BaseLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);

    }

    @RequestMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @RequestMapping(value = "consumer/testPost")
    public ResponseVo testPost(){
        String url = "http://jsonplaceholder.typicode.com/posts";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RequestVo requestVo = new RequestVo();
        requestVo.setPhone("15942620189");
        String req = JsonUtils.objectToJson(requestVo);
        HttpEntity<String> request = new HttpEntity<>(req,headers);
        String postForObjectRes = restTemplate.postForObject(url, request, String.class);
        System.out.println(postForObjectRes);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, request, String.class);
        System.out.println(stringResponseEntity.getStatusCodeValue());
        ResponseVo responseVo = JSON.parseObject(JSON.parseObject(stringResponseEntity.getBody()).toString(), ResponseVo.class);
        return  responseVo;
    }
}
