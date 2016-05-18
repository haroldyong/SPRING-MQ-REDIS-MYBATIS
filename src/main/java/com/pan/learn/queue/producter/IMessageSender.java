package com.pan.learn.queue.producter;

import com.pan.learn.meta.po.UserData;

/**
 * Created by panhongwei on 2016/5/17.
 */
public interface IMessageSender {

    public void addUser(UserData userData);
}
