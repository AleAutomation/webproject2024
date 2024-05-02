package qa.hooks;

import org.apache.commons.io.FilenameUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.helper.BaseTest;
import qa.helper.DriverFactory;

public class BaseHooks extends BaseTest{
	
	@Before(order = 0)
	public void setCenario(Scenario cen) {
		
		cenario = cen.getName();
		feature = FilenameUtils.getBaseName(cen.getUri().toString());
	}

	@After(order = 0)
	public void teardown() {
		DriverFactory.KillDriver();
	}
}
