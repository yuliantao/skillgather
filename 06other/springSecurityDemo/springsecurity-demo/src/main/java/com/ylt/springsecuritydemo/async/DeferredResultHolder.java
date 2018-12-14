package com.ylt.springsecuritydemo.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

//记录发送请求化响应结果的关联
@Component
public class DeferredResultHolder {
    private Map<String, DeferredResult<String>> map =new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
