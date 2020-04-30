package chart.email;

import java.util.ArrayList;
import java.util.List;

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
		CreateChart cc = new CreateChart();
		// cc.createChart("SBIN");
		// cc.createChart("PIDILITIND");
		// cc.createChart("NIFTY");
		// cc.createChart("DMART");
		// cc.createChart("ASIANPAINT");
		List<String> codes = new ArrayList<>();
		codes = Utils.readCSV("resources/ind_nifty100list.csv");
		for (String code : codes) {
			cc.createChart(code);
		}
	}

	// @AfterClass
	// public void tearDown() {
	//
	// }

}
