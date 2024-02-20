package com.borntorun;

import com.borntorun.CsvRunnerDataProvider;
import com.borntorun.CsvRunningFriendsDataProvider;

public class DataProviderFactory {

    public static ExternalRunnerDataProvider createCsvDataProvider(String csvFilePath) {
        return new CsvRunnerDataProvider(csvFilePath);
    }

    public static ExternalRunnerDataProvider createCsvRunningFriendsDataProvider(String friendsCsvFilePath) {
        return new CsvRunningFriendsDataProvider(friendsCsvFilePath);
    }
}
