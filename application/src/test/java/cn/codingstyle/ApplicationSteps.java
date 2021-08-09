package cn.codingstyle;

import cn.codingstyle.base.AutoClear;
import cn.codingstyle.base.RestCall;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ActiveProfiles("test")
@ContextConfiguration(classes = {Application.class}, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class ApplicationSteps {
    @Autowired
    RestCall restCall;
    @Autowired
    AutoClear autoClear;

    @Before
    public void setup() {
        autoClear.clear(this);
    }

    @When("Get访问路径 {string} 得到结果是")
    public void get访问路径得到结果是(String url, String expectContent) throws IOException {
        String actualContent = restCall.get(url);
        assertThat(actualContent, is(expectContent));
    }
}
