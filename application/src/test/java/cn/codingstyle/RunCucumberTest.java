package cn.codingstyle;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/e2e/"}
        , glue = "cn.codingstyle",
        plugin = {"html:target/cucumber-report.html"}
)
@Slf4j
public class RunCucumberTest {
}
