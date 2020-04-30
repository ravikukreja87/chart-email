package chart.email;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestChart {

	@BeforeClass
	public static void setUp() throws Exception {
		Runtime.getRuntime().exec("taskkill /F /IM chromecriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	}

	@Test
	public void testMainTest() throws Exception {
		// CreateChart cc = new CreateChart();
		// cc.createChart("SBIN");
		// cc.createChart("PIDILITIND");
		// cc.createChart("NIFTY");
		// cc.createChart("DMART");
		// cc.createChart("ASIANPAINT");
		// Email.triggerEmail2("ravikukrejapune@gmail.com", "Under87Taker",
		// "ravikukrejapune@gmail.com", "TEST", "TEST");
		Email.triggerEMail();
	}

	// @AfterClass
	// public void tearDown() {
	//
	// }

}
