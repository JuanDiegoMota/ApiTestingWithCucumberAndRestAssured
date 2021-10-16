package com.taprojects.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author <a href="juan1.hernandez@scotiabankcolpatria.com">Juan Diego Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        plugin = "json:target/jsonReports/Library-report.json",
        glue= {"com.taprojects.stepdefinitions"},
        monochrome=true
)
public class CreateUserServiceRunner {}