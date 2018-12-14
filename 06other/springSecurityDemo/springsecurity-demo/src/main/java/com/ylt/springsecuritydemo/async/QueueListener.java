package com.ylt.springsecuritydemo.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true)
            {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder()))
                {
                    String ordernumber=mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果："+ordernumber);
                    deferredResultHolder.getMap().get(ordernumber).setResult("处理完成");//此处就是触发订单完成可以发送给客户端浏览器
                    mockQueue.setCompleteOrder(null);
                }
                else
                {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ).start();
    }
}
