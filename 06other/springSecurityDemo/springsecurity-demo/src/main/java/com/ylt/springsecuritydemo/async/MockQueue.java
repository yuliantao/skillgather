package com.ylt.springsecuritydemo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//模拟下单队列，
@Component
public class MockQueue {

    Logger logger = LoggerFactory.getLogger(getClass());

    private String placeOrder;
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
      new Thread(()->{
          logger.info("接到下单请求"+placeOrder);
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          this.completeOrder=placeOrder;
          logger.info("下单请求结束"+placeOrder);
      }).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
