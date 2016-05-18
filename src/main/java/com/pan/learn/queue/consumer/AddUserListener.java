package com.pan.learn.queue.consumer;

import com.pan.learn.meta.po.UserData;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

/**
 * Created by panhongwei on 2016/5/17.
 */
public class AddUserListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
            UserData userData = (UserData) jackson2JsonMessageConverter.fromMessage(message);
            System.out.println(userData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
