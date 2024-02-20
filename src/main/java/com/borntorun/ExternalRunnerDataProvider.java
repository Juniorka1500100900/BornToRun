package com.borntorun;

import com.borntorun.ExternalRunner;

import java.util.List;

public interface ExternalRunnerDataProvider {
    List<ExternalRunner> fetchExternalRunners();
}