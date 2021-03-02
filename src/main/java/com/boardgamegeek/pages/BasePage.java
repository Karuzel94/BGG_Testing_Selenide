package com.boardgamegeek.pages;

import com.boardgamegeek.utilities.TestHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.disappear;

public abstract class BasePage {

    public TestHelper testHelper = new TestHelper();

    public void visibilityCheck(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    public void checkElementClickable(SelenideElement element) {
        Condition clickable = and("can be clicked", Condition.visible, Condition.enabled);
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
