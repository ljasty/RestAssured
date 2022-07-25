package org.ReqRes.Base;

import org.ReqRes.Util.ExtentManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    @BeforeSuite
    public void loadConfig() {
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

    }
    @AfterSuite
    public void AfterSuite(){
        ExtentManager.endReport();
    }


}