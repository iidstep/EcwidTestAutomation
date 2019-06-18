package com.example.products.views.list.view;

import com.example.products.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringEndsWith.endsWith;

class TestBase {

    public void checkEmptyProductName() {
        onView(withId(R.id.snackbar_text)).check(matches(withText("Product name should not be empty")));
    }

    public void clickCreateButton() {
        onView(withId(R.id.create_button)).perform(click());
    }

    public void enterPrice() {
        onView(withId(R.id.product_price)).perform(typeText("6"));
    }

    public void enterAmount() {
        onView(withId(R.id.product_amount)).perform(typeText("5"));
    }

    public void enterProductName() {
        onView(withId(R.id.product_title)).perform(typeText("Test1"));
    }

    public void clickAddButton() {
        onView(withId(R.id.add_button)).perform(click());
    }

    public void checkNewPrice() {
        onView(withId(R.id.product_price)).check(matches(withText("Price: 6.00")));
    }

    public void checkNewAmount() {
        onView(withId(R.id.product_amount)).check(matches(withText("Amount: 5")));
    }

    public void checkNewProductName() {
        onView(withId(R.id.product_name)).check(matches(withText("Test1")));
    }

    public void closeKeyboard() {
        onView(withId(R.id.product_title)).perform(closeSoftKeyboard());
    }

    public void checkEditPrice() {
        onView(withId(R.id.product_price)).check(matches(withText("Price: 100.50")));
    }

    public void checkEditAmount() {
        onView(withId(R.id.product_amount)).check(matches(withText("Amount: 10")));
    }

    public void checkEditProductName() {
        onView(withId(R.id.product_name)).check(matches(withText("Rename Product")));
    }

    public void clickSaveButton() {
        onView(withId(R.id.save_button)).perform(click());
    }

    public void editPrice() {
        onView(withId(R.id.product_price)).perform(clearText()).perform(typeText("100.5"));
    }

    public void editAmount() {
        onView(withId(R.id.product_amount)).perform(clearText()).perform(typeText("10"));
    }

    public void editProductName() {
        onView(withId(R.id.product_title)).perform(clearText()).perform(typeText("Rename Product"));
    }

    public void clickEditButton() {
        onView(allOf(withClassName(endsWith("TextView")), withText("Edit"))).perform(click());
    }

    public void clickProductEdit() {
        onView(withId(R.id.product_name)).check(matches(withText("Test1"))).perform(click());
    }

    public void checkProductAbsence() {
        onView(withId(R.id.product_name)).check(doesNotExist());
    }

    public void clickDeleteButton() {
        onView(allOf(withClassName(endsWith("TextView")), withText("Delete"))).perform(click());
    }

    public void clickProductDelete() {
        onView(withId(R.id.product_name)).check(matches(withText("Rename Product"))).perform(click());
    }

    public void checkEmptyAmount() {
        onView(withId(R.id.snackbar_text)).check(matches(withText("Amount should be in [1; 10,000]")));
    }

    public void checkEmptyPrice() {
        onView(withId(R.id.snackbar_text)).check(matches(withText("Price should be in [0.0; 100,000.0]")));
    }
}
