package com.boardgamegeek.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public abstract class BasePage {

    public void visibilityCheck(SelenideElement element) {
        element.shouldBe(visible);
    }

    public void checkElementClickable(SelenideElement element) {
        Condition clickable = and("can be clicked", visible, enabled);
        element.shouldBe(clickable);
    }

    public void click(SelenideElement element) {
        visibilityCheck(element);
        checkElementClickable(element);
        element.click();
    }

    public void insertValue(SelenideElement element, String value) {
        visibilityCheck(element);
        element.val(value);
    }

    public void synchronization(SelenideElement element) {
        element.should(disappear);
    }
}
