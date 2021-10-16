package com.taprojects.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/get_users_service.feature",
        plugin = "json:target/jsonReports/Library-report.json",
        publish = true,
        glue= {"com.taprojects.stepdefinitions"}
)
public class GetUserServiceRunner {}