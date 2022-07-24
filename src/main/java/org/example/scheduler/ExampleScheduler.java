package org.example.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

//@EnableScheduling
@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleScheduler {

    @Scheduled(cron = "*/1 * * * * *")
    public void startJob1Sec(){
        log.info("{} start Job 1 Seconds !!", Instant.now());
    }

    @Scheduled(fixedDelay = 5000)
    public void startJob5Sec(){
        log.info("{} start Job 5 Seconds !!", Instant.now());
    }

    @Scheduled(fixedRate = 10000)
    public void startJob10Sec(){
        log.info("{} start Job 10 Seconds !!", Instant.now());
    }

}
