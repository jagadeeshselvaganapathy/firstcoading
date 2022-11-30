package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features",glue = "com.stepDefinition", dryRun = false, monochrome = false,/* tags = {"@tag1"},*/
snippets = SnippetType.CAMELCASE)

public class TestRunner {
	
	

}
