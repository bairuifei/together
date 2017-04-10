package com.together.scheduler;

import com.together.service.InviteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by BRF on 2017-04-10.
 */
@Component
public class InviteScheduler {

    private final Logger logger = LoggerFactory.getLogger(InviteScheduler.class);

    @Autowired
    private InviteService inviteService;

    //修改符合条件的已发出邀请为进行中fixedRate（执行频率次/ms）fixedDelay（上一个结束和下一个开始之间的延迟时间）initialDelay（第一次执行延迟时间）
    @Scheduled(fixedRate = 60000)
    public void inviteDoing(){
        int count = inviteService.updateInviteDoing();
        logger.info(count+"个邀请转为进行中...");
    }

    //修改符合条件的进行中邀请为已结束
    @Scheduled(fixedRate = 60000,initialDelay = 30000)
    public void inviteDone(){
        int count = inviteService.updateInviteDone();
        logger.info(count+"个邀请转为已结束...");
    }
}
