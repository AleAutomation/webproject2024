package qa.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Ecommerce",
glue ={"qa.hooks", "qa.steps.Ecommerce"},
monochrome = true, dryRun = false, plugin = {
"json:target/Ecommerce.json"}, tags = "@EcommerceTest")

public class EcommerceTest {
	

}
