package com.automation.ux.qa.contexts;

import com.automation.ux.qa.factoryManager.BrowserFactory;
import com.automation.ux.qa.factoryManager.PageObjectFactory;

public class TestContext {
    private final BrowserFactory browserFactory;
    private final PageObjectFactory pageObjectFactory;

    public TestContext() {
        browserFactory = new BrowserFactory();
        pageObjectFactory = new PageObjectFactory(browserFactory.getDriver());
    }

    public BrowserFactory getWebDriverManager() {
        return browserFactory;
    }

    public PageObjectFactory getPageObjectManager() {
        return pageObjectFactory;
    }

}