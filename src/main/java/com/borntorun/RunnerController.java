package com.borntorun;

import com.borntorun.DataProviderFactory;
import com.borntorun.ExternalRunner;
import com.borntorun.ExternalRunnerDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    private final RunnerService runnerService;

    @Autowired
    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping("/external/csv1")
    public List<ExternalRunner> getCsv1ExternalRunners() {
        String csvFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\CSV1.csv";
        ExternalRunnerDataProvider csv1RunnerDataProvider = DataProviderFactory.createCsvDataProvider(csvFilePath);
        return csv1RunnerDataProvider.fetchExternalRunners();
    }

    @GetMapping("/external/friends")
    public List<ExternalRunner> getFriendsCsvExternalRunners() {
        String friendsCsvFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\Friends.csv";
        ExternalRunnerDataProvider friendsCsvDataProvider = DataProviderFactory.createCsvDataProvider(friendsCsvFilePath);
        return friendsCsvDataProvider.fetchExternalRunners();
    }

    @PostMapping("/external/update-database/csv1")
    public ResponseEntity<String> updateDatabaseWithCsv1ExternalRunners() {
        String csvFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\CSV1.csv";
        ExternalRunnerDataProvider csv1RunnerDataProvider = DataProviderFactory.createCsvDataProvider(csvFilePath);
        runnerService.updateDatabaseWithExternalRunners(csv1RunnerDataProvider);
        return ResponseEntity.ok("Database updated with CSV1 external runners");
    }

    @PostMapping("/external/update-database/friends")
    public ResponseEntity<String> updateDatabaseWithFriendsCsvExternalRunners() {
        String friendsCsvFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\Friends.csv";
        ExternalRunnerDataProvider friendsCsvDataProvider = DataProviderFactory.createCsvDataProvider(friendsCsvFilePath);
        runnerService.updateDatabaseWithExternalFriendsRunners(friendsCsvDataProvider);
        return ResponseEntity.ok("Database updated with Friends CSV external runners");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRunner(@PathVariable Long id, @RequestBody RunnerDto runnerDto) {
        runnerService.updateRunner(id, runnerDto);
        return ResponseEntity.ok("Runner updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRunner(@PathVariable Long id) {
        runnerService.deleteRunner(id);
        return ResponseEntity.ok("Runner deleted successfully");
    }

    @GetMapping("/name/{name}")
    public List<Runner> getRunnersByName(@PathVariable String name) {
        return runnerService.getRunnersByName(name);
    }

    @GetMapping("/email/{email}")
    public Optional<Runner> getRunnerByEmail(@PathVariable String email) {
        return runnerService.getRunnerByEmail(email);
    }

    @GetMapping("/count")
    public long countRunners() {
        return runnerService.countRunners();
    }

    @GetMapping("/search")
    public List<Runner> searchRunners(@RequestParam String keyword) {
        return runnerService.searchRunners(keyword);
    }

    @GetMapping("/top/{topCount}")
    public List<Runner> getTopRunners(@PathVariable int topCount) {
        return runnerService.getTopRunners(topCount);
    }

    @GetMapping("/age/{age}")
    public List<Runner> getRunnersByAge(@PathVariable int age) {
        return runnerService.getRunnersByAge(age);
    }

    @GetMapping("/active")
    public List<Runner> getActiveRunners() {
        return runnerService.getActiveRunners();
    }

    @GetMapping("/inactive")
    public List<Runner> getInactiveRunners() {
        return runnerService.getInactiveRunners();
    }

    @GetMapping("/gender/{gender}")
    public List<Runner> getRunnersByGender(@PathVariable String gender) {
        return runnerService.getRunnersByGender(gender);
    }

    @GetMapping("/average-age")
    public double getAverageAge() {
        return runnerService.getAverageAge();
    }

    @GetMapping("/oldest")
    public Runner getOldestRunner() {
        return runnerService.getOldestRunner();
    }

    @GetMapping("/youngest")
    public Runner getYoungestRunner() {
        return runnerService.getYoungestRunner();
    }

    @GetMapping("/validate/{id}")
    public ResponseEntity<String> validateRunner(@PathVariable Long id) {
        if (runnerService.validateRunner(id)) {
            return ResponseEntity.ok("Runner is valid");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Runner is not valid");
        }
    }

    @GetMapping("/statistics")
    public Map<String, Object> getStatistics() {
        return runnerService.getStatistics();
    }
}
