package com.pan.learn.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by panhongwei on 2016/5/18.
 */
@Service
public class UserJob {

    private static final Logger logger = LoggerFactory.getLogger(UserJob.class);

    @Scheduled(cron = "0/5 * * * * ?")
    public void clearUser(){
        logger.info("clear user job start");
        System.out.println("clear user");
        logger.info("clear user job stop");
    }
}
