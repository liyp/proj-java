package com.github.liyp.dubbo.consumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.liyp.dubbo.api.HelloBean;
import com.github.liyp.dubbo.api.HelloService;

public class Consumer {

    static AtomicInteger ai = new AtomicInteger();
    static CountDownLatch cdl;
    static int limit = 5;
    static boolean locked = false;

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "com/github/liyp/dubbo/consumer/consumer.xml" });
        context.start();
        NotifyImpl notify = (NotifyImpl) context.getBean("callback");
        HelloService service = (HelloService) context.getBean("service");
        System.out.println("dubbo consumer running...");
        int i = 0;
        while (true) {
            String res = service.sayHello(new HelloBean(i, "lee"));
            // service.sayHello(i);
            System.out.println(ai.incrementAndGet());
            if (ai.get() >= limit) {
                locked = true;
                cdl = new CountDownLatch(limit);
                cdl.await();
                locked = false;
            }
            // Thread.sleep(1000);
            i++;
        }
    }
}