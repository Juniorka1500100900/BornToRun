package com.borntorun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunnerScheduler {

    private final RunnerService runnerService;

    @Autowired
    public RunnerScheduler(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void sendReminderEmails() {
        runnerService.sendReminderEmails();
    }
}
