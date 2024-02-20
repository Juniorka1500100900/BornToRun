package com.borntorun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvRunningFriendsDataProvider implements ExternalRunnerDataProvider {

    private final String csvFriendsFilePath;

    public CsvRunningFriendsDataProvider(String friendsCsvFilePath) {
        this.csvFriendsFilePath = "C:\\Users\\omene\\OneDrive\\Pulpit\\Friends.csv";
    }

    @Override
    public List<ExternalRunner> fetchExternalRunners() {
        List<ExternalRunner> externalRunners = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFriendsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    ExternalRunner externalRunner = new ExternalRunner(
                            Long.parseLong(data[0]),
                            data[1],
                            data[2],
                            Boolean.parseBoolean(data[3]),
                            data[4],
                            Integer.parseInt(data[5])
                    );
                    externalRunners.add(externalRunner);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return externalRunners;
    }
}
