package com.automation.ux.qa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty",
				"html:target/cucumber-html-report.html",
				"json:target/cucumber.json",
				"rerun:target/rerun.txt"},
		features = "src/test/resources/features",
		glue= {"com.automation.ux.qa"},
		tags="@user_login_scenarios_negative")
public class RunCuke {
}