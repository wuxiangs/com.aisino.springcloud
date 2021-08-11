package com.aisino.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wuxiang
 * @date 2021/7/14 8:08 下午
 */
@Component
@EnableBinding(Sink.class)
public class StreamReceiveController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){

        System.out.println("我是第二个消费者,我接受到的信息是"+message.getPayload()+"\t"+serverPort);

    }

}
