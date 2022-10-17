package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {
    @Before
    public void before() {
        DriverManager.setupDriver();
    }

    @After
    public void after() {

        DriverManager.quitDriver();
    }
}