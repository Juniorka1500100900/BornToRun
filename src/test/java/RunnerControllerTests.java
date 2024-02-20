import com.borntorun.RunnerController;
import com.borntorun.RunnerDto;
import com.borntorun.RunnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class RunnerControllerTests {

    @Mock
    private RunnerService runnerService;

    @InjectMocks
    private RunnerController runnerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateDatabaseWithCsv1ExternalRunners() {
        ResponseEntity<String> response = runnerController.updateDatabaseWithCsv1ExternalRunners();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Database updated with CSV1 external runners", response.getBody());
        verify(runnerService, times(1)).updateDatabaseWithExternalRunners(any());
    }


    @Test
    void testUpdateDatabaseWithFriendsCsvExternalRunners() {
        ResponseEntity<String> response = runnerController.updateDatabaseWithFriendsCsvExternalRunners();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Database updated with Friends CSV external runners", response.getBody());
        verify(runnerService, times(1)).updateDatabaseWithExternalFriendsRunners(any());
    }


    @Test
    void testUpdateRunner() {
        Long id = 1L;
        RunnerDto runnerDto = new RunnerDto();
        ResponseEntity<String> response = runnerController.updateRunner(id, runnerDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Runner updated successfully", response.getBody());
        verify(runnerService, times(1)).updateRunner(id, runnerDto);
    }

    @Test
    void testDeleteRunner() {
        Long id = 1L;
        ResponseEntity<String> response = runnerController.deleteRunner(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Runner deleted successfully", response.getBody());
        verify(runnerService, times(1)).deleteRunner(id);
    }

    @Test
    void testGetRunnersByName() {
        String name = "John";
        List<Runner> runners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.getRunnersByName(name)).thenReturn(runners);

        List<Runner> result = runnerController.getRunnersByName(name);

        assertEquals(runners, result);
    }

    @Test
    void testGetRunnerByEmail() {
        String email = "john@example.com";
        Optional<Runner> runner = Optional.of(new Runner());
        when(runnerService.getRunnerByEmail(email)).thenReturn(runner);

        Optional<Runner> result = runnerController.getRunnerByEmail(email);

        assertTrue(result.isPresent());
        assertEquals(runner.get(), result.get());
    }

    @Test
    void testCountRunners() {
        when(runnerService.countRunners()).thenReturn(10L);

        long result = runnerController.countRunners();

        assertEquals(10L, result);
    }

    @Test
    void testSearchRunners() {
        String keyword = "running";
        List<Runner> runners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.searchRunners(keyword)).thenReturn(runners);

        List<Runner> result = runnerController.searchRunners(keyword);

        assertEquals(runners, result);
    }

    @Test
    void testGetTopRunners() {
        int topCount = 5;
        List<Runner> topRunners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.getTopRunners(topCount)).thenReturn(topRunners);

        List<Runner> result = runnerController.getTopRunners(topCount);

        assertEquals(topRunners, result);
    }

    @Test
    void testGetRunnersByAge() {
        int age = 25;
        List<Runner> runners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.getRunnersByAge(age)).thenReturn(runners);

        List<Runner> result = runnerController.getRunnersByAge(age);

        assertEquals(runners, result);
    }

    @Test
    void testGetActiveRunners() {
        List<Runner> activeRunners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.getActiveRunners()).thenReturn(activeRunners);

        List<Runner> result = runnerController.getActiveRunners();

        assertEquals(activeRunners, result);
    }

    @Test
    void testGetInactiveRunners() {
        List<Runner> inactiveRunners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.getInactiveRunners()).thenReturn(inactiveRunners);

        List<Runner> result = runnerController.getInactiveRunners();

        assertEquals(inactiveRunners, result);
    }

    @Test
    void testGetRunnersByGender() {
        String gender = "male";
        List<Runner> maleRunners = Arrays.asList(new Runner(), new Runner());
        when(runnerService.getRunnersByGender(gender)).thenReturn(maleRunners);

        List<Runner> result = runnerController.getRunnersByGender(gender);

        assertEquals(maleRunners, result);
    }

    @Test
    void testGetAverageAge() {
        when(runnerService.getAverageAge()).thenReturn(27.5);

        double result = runnerController.getAverageAge();

        assertEquals(27.5, result);
    }

    @Test
    void testGetOldestRunner() {
        Runner oldestRunner = new Runner();
        when(runnerService.getOldestRunner()).thenReturn(oldestRunner);

        Runner result = runnerController.getOldestRunner();

        assertEquals(oldestRunner, result);
    }

    @Test
    void testGetYoungestRunner() {
        Runner youngestRunner = new Runner();
        when(runnerService.getYoungestRunner()).thenReturn(youngestRunner);

        Runner result = runnerController.getYoungestRunner();

        assertEquals(youngestRunner, result);
    }

    @Test
    void testValidateRunnerValid() {
        Long id = 1L;
        when(runnerService.validateRunner(id)).thenReturn(true);

        ResponseEntity<String> response = runnerController.validateRunner(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Runner is valid", response.getBody());
    }

    @Test
    void testValidateRunnerInvalid() {
        Long id = 1L;
        when(runnerService.validateRunner(id)).thenReturn(false);

        ResponseEntity<String> response = runnerController.validateRunner(id);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Runner is not valid", response.getBody());
    }

    @Test
    void testGetStatistics() {
        Map<String, Object> statistics = Map.of("totalRunners", 10, "averageAge", 25.5);
        when(runnerService.getStatistics()).thenReturn(statistics);

        Map<String, Object> result = runnerController.getStatistics();

        assertEquals(statistics, result);
    }
}
