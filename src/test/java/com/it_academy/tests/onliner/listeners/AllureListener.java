package com.it_academy.tests.onliner.listeners;


import com.it_academy.tests.onliner.utils.ScreenshotUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AllureListener implements TestWatcher {
  protected static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class);

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }

}
