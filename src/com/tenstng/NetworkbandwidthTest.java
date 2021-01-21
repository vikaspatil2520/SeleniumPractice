package com.tenstng;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class NetworkbandwidthTest {

	@DataProvider(name = "networkBandwidths")
	public Object[][] networkConditions() {
		return new Object[][] {{ 200, 200 },{ 2000, 2000 },{ 5000, 5000 }, { 10000, 5000 }, { 5000, 5000 }, { 10000, 10000 }, { 10000, 200000 },
				{ 0, 0 }, };
	}

	@Test(dataProvider = "networkBandwidths")
	public void test(int downoadSpeed, int uploadSpeed) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing-vikas\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		if (downoadSpeed > 0 && uploadSpeed > 0) {
			CommandExecutor executor = ((RemoteWebDriver) driver).getCommandExecutor();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("offline", "false");
			map.put("latency", 5);
			map.put("download_throughput", downoadSpeed);
			map.put("upload_throughput", uploadSpeed);

			Response response = executor.execute (new Command(((RemoteWebDriver) driver).getSessionId(), "setNetworkConditions",
					ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));

//            Response response = executor.execute(new Command(((RemoteWebDriver) driver).getSessionId(), "setNetworkConditions", 
//                    ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));			
		}
		driver.get("https://www.facebook.com");
		driver.quit();
	}
}