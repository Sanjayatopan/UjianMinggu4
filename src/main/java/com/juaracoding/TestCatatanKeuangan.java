package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCatatanKeuangan {
    private static AndroidDriver<MobileElement> driver;
    public CatatanKeuangan catatanKeuangan;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("devicename", "Pixel_4");
        dc.setCapability("udid", "emulator-5556");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "14");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
    }

    @BeforeMethod
    public void pageObject() {
        catatanKeuangan = new CatatanKeuangan(driver);
//        catatanKeuangan.setUp();
    }

    @Test(priority = 1)
    public void testPengeluaran() {
        catatanKeuangan.pengeluaran();
        System.out.println("Keterangan = "+catatanKeuangan.getTxtDesc());
        Assert.assertEquals(catatanKeuangan.getTxtDesc(),"makan 3 kali sehari dalam seminggu");
    }

    @Test(priority = 2)
    public void testPemasukan() {
        catatanKeuangan.pemasukan();
        System.out.println("Keterangan = "+catatanKeuangan.getTxtDesc());
        Assert.assertEquals(catatanKeuangan.getTxtDesc(),"hokiii abis");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
    }
}
