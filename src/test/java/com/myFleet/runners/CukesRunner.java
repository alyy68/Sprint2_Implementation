package com.myFleet.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports.html",
        features = "src/test/resources/features",
        glue = "com/myFleet/step_definitions",
        dryRun = false,
        tags = "@ali",
        publish = true //generating a report with public link
)
public class CukesRunner {
}


