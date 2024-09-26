package com.telegram.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/telegram",
        glue = "com/telegram/stepDef",
        dryRun = true

)
public class Runner {
}
