package com.it_academy.onliner.web_ui.navigation;

import com.it_academy.onliner.web_ui.pageobject.OnlinerHomePage;

public class OnlinerNavigation {
    public static void navigateToOnlinerHomePage() {
        new OnlinerHomePage().navigate("https://www.onliner.by/");
    }
}