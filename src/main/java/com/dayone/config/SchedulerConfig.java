package com.dayone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPool = new ThreadPoolTaskScheduler(); // 스레드풀 생성

        int n = Runtime.getRuntime().availableProcessors(); // 코어 개수
        threadPool.setPoolSize(n); // 스레드풀 개수 설정
        threadPool.initialize();

        taskRegistrar.setTaskScheduler(threadPool);
    }
}
