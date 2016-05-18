package com.pan.learn.queue.producter.impl;

import com.pan.learn.meta.po.UserData;
import com.pan.learn.queue.producter.IMessageSender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by panhongwei on 2016/5/17.
 */
@Service
public class MessageSenderImpl implements IMessageSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void addUser(UserData userData) {
        Assert.notNull(userData);
        amqpTemplate.convertAndSend("test_add_user_key", userData);
    }
}
