package com.aisino.springcloud.service.impl;

import com.aisino.springcloud.service.StreamMqService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wuxiang
 * @date 2021/7/14 6:43 下午
 */
@EnableBinding(Source.class)
public class StreamMqServiceImpl implements StreamMqService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}
