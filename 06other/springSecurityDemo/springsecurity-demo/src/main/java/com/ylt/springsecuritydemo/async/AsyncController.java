package com.ylt.springsecuritydemo.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


@RestController
public class AsyncController {
    private Logger logger=LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")
    public Callable<String> order() throws Exception
    {
        logger.info("主线程开始");
        Callable<String> result=new Callable<String>() {
            @Override
            public String call() throws Exception {
               logger.info("副线程开始");
               Thread.sleep(1000);
               logger.info("副线程结束");
               return  "成功";
            }
        };
        logger.info("主线程返回");
        return result;
    }

    @Autowired
    private  MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("/orderdef")
    public DeferredResult<String> orderdef() throws Exception
    {
        logger.info("主线程开始");
        String orderNumber= RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result=new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);//此处放入后就等其他线程修改状态返回
        logger.info("主线程返回");
        return result;
    }



















}
