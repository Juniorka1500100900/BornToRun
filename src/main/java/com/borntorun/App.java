package com.borntorun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    @Autowired
    private static RunnerRepository runnerRepository;

    @Autowired
    private static RunnerService runnerService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        String csvFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\CSV1.csv";
        String friendsCsvFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\Friends.csv";

        ExternalRunnerDataProvider csvDataProvider = DataProviderFactory.createCsvDataProvider(csvFilePath);
        ExternalRunnerDataProvider friendsCsvDataProvider = DataProviderFactory.createCsvRunningFriendsDataProvider(friendsCsvFilePath);

        List<ExternalRunner> csvRunners = csvDataProvider.fetchExternalRunners();
        System.out.println("Runners from CSV file: " + csvRunners);

        List<ExternalRunner> friendsCsvRunners = friendsCsvDataProvider.fetchExternalRunners();
        System.out.println("Runners from Friends CSV file: " + friendsCsvRunners);

        List<Runner> allRunners = runnerService.getAllRunners();
        System.out.println("All runners: " + allRunners);

        context.close();
    }
}
