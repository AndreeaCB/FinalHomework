package com.endava;

        import cucumber.api.CucumberOptions;
        import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",
        glue = "stepdefs",
        plugin = "{pretty}")
public class CucumberTest extends AbstractTestNGCucumberTests {
}
