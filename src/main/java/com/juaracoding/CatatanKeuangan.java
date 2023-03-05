package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CatatanKeuangan {
    public AndroidDriver<MobileElement> driver;
    public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement tombolAllow;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement tombolOK;
    @AndroidFindBy(id = "android:id/button2")
    private MobileElement tombolTutup;

    @AndroidFindBy(id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement tombolAdd;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tombolExpense")
    private MobileElement tombolPengeluaran;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tombolIncome")
    private MobileElement tombolPemasukan;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tvDate")
    private MobileElement tombolTanggal;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"05 Maret 2023\"]")
    private MobileElement tombolPilihTanggal5;

//    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"05 Maret 2023\"]")
//    private MobileElement tombolPilihTanggal5;

    @AndroidFindBy(id = "com.chad.financialrecord:id/spCategory")
    private MobileElement tombolKategori;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement tombolMobil;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[10]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement tombolPenjualan;

    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement jumlah;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement keterangan;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement tombolSave;

    @AndroidFindBy(id = "com.chad.financialrecord:id/tvDesc")
    private MobileElement deskripsi;


    public void setUp(){
        tombolAllow.click();
        tombolTutup.click();
    }

    public void pengeluaran(){
        setUp();
        tombolAdd.click();
        tombolPengeluaran.click();
        tombolTanggal.click();
        tombolPilihTanggal5.click();
        tombolOK.click();
        tombolKategori.click();
        tombolMobil.click();
        jumlah.sendKeys("350000");
        keterangan.sendKeys("makan 3 kali sehari dalam seminggu");
        tombolSave.click();
    }

    public void pemasukan(){
        setUp();
        tombolAdd.click();
        tombolPemasukan.click();
        tombolTanggal.click();
        tombolPilihTanggal5.click();
        tombolOK.click();
        tombolKategori.click();
        tombolPenjualan.click();
        jumlah.sendKeys("10000000");
        keterangan.sendKeys("hokiii abis");
        tombolSave.click();
    }

    public String getTxtDesc() {
        return deskripsi.getText();
    }
}
