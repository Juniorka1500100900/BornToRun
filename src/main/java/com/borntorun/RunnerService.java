package com.borntorun;

import com.borntorun.ExternalRunner;
import com.borntorun.ExternalRunnerDataProvider;
import com.borntorun.RunnerDto;
import com.borntorun.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    public Optional<Runner> getRunnerById(Long id) {
        return runnerRepository.findById(id);
    }

    public Runner createRunner(Runner runner) {
        return runnerRepository.save(runner);
    }

    public Runner updateRunner(Long id, RunnerDto updatedRunner) {
        return runnerRepository.findById(id)
                .map(runner -> {
                    runner.setName(updatedRunner.getName());
                    runner.setEmail(updatedRunner.getEmail());
                    return runnerRepository.save(runner);
                })
                .orElse(null);
    }

    public void deleteRunner(Long id) {
        runnerRepository.deleteById(id);
    }

    public List<Runner> getRunnersByName(String name) {
        return runnerRepository.findByName(name);
    }

    public Optional<Runner> getRunnerByEmail(String email) {
        return runnerRepository.findByEmail(email);
    }

    public long countRunners() {
        return runnerRepository.count();
    }

    public List<Runner> searchRunners(String keyword) {
        return runnerRepository.search(keyword);
    }

    public List<Runner> getTopRunners(int topCount) {
        return runnerRepository.findTopNRunners(topCount);
    }

    public List<Runner> getRunnersByAge(int age) {
        return runnerRepository.findByAge(age);
    }

    public List<Runner> getActiveRunners() {
        return runnerRepository.findByActive(true);
    }

    public List<Runner> getInactiveRunners() {
        return runnerRepository.findByActive(false);
    }

    public List<Runner> getRunnersByGender(String gender) {
        return runnerRepository.findByGender(gender);
    }

    public double getAverageAge() {
        return runnerRepository.calculateAverageAge();
    }

    public Runner getOldestRunner() {
        return runnerRepository.findOldestRunner();
    }

    public Runner getYoungestRunner() {
        return runnerRepository.findYoungestRunner();
    }

    public boolean validateRunner(Long id) {
        Optional<Runner> runner = runnerRepository.findById(id);
        return runner.isPresent() && runner.get().getAge() >= 18;
    }

    public Map<String, Object> getStatistics() {
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("totalRunners", countRunners());
        statistics.put("averageAge", getAverageAge());
        statistics.put("oldestRunner", getOldestRunner());
        statistics.put("youngestRunner", getYoungestRunner());
        return statistics;
    }

    public void sendReminderEmails() {
    }
    public void updateDatabaseWithExternalRunners(ExternalRunnerDataProvider csvRunnerDataProvider) {
        List<ExternalRunner> externalRunners = csvRunnerDataProvider.fetchExternalRunners();
        for (ExternalRunner externalRunner : externalRunners) {
            Runner runner = new Runner();
            runner.setName(externalRunner.getName());
            runner.setEmail(externalRunner.getEmail());
            runner.setActive(externalRunner.isActive());
            runner.setGender(externalRunner.getGender());
            runner.setAge(externalRunner.getAge());

            runnerRepository.save(runner);
        }
    }

    public void updateDatabaseWithExternalFriendsRunners(ExternalRunnerDataProvider csvFriendsDataProvider) {
        List<ExternalRunner> externalFriendsRunners = csvFriendsDataProvider.fetchExternalRunners();
        for (ExternalRunner externalRunner : externalFriendsRunners) {
            Runner runner = new Runner();
            runner.setName(externalRunner.getName());
            runner.setEmail(externalRunner.getEmail());
            runner.setActive(externalRunner.isActive());
            runner.setGender(externalRunner.getGender());
            runner.setAge(externalRunner.getAge());

            runnerRepository.save(runner);
        }
    }


}
