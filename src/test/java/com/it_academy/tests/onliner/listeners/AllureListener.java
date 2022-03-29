package com.it_academy.tests.onliner.listeners;


import com.it_academy.tests.onliner.utils.ScreenshotUtils;
import org.junit.AssumptionViolatedException;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.runner.Description;


public class AllureListener implements TestWatcher {
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }
    //    @Override
//    protected void failed(Throwable e, Description description) {
//        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
//    }
//
//    @Override
//    protected void skipped(AssumptionViolatedException e, Description description) {
//        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
//    }

}
