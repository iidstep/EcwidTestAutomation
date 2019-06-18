package com.example.products.views.list.view;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.products.R;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringEndsWith.endsWith;


@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ProductsListActivityTest extends TestBase {

    @Rule
    public ActivityTestRule<ProductsListActivity> mActivityTestRule = new ActivityTestRule<>(ProductsListActivity.class);

    @Test
    public void test1_createProduct() throws Exception {
        clickAddButton();
        enterProductName();
        enterAmount();
        enterPrice();
        closeKeyboard();
        clickCreateButton();
        checkNewProductName();
        checkNewAmount();
        checkNewPrice();
    }

    @Test
    public void test2_editProduct() throws Exception {
        clickProductEdit();
        clickEditButton();
        editProductName();
        editAmount();
        editPrice();
        closeKeyboard();
        clickSaveButton();
        Thread.sleep(250);
        checkEditProductName();
        checkEditAmount();
        checkEditPrice();
    }

    @Test
    public void test3_deleteProduct() throws Exception {
        clickProductDelete();
        clickDeleteButton();
    }

    @Test
    public void test4_emptyProductName() throws Exception{
        clickAddButton();
        clickCreateButton();
        checkEmptyProductName();
    }

    @Test
    public void test5_emptyAmount() throws Exception{
        clickAddButton();
        enterProductName();
        closeKeyboard();
        clickCreateButton();
        checkEmptyAmount();
    }

    @Test
    public void test6_emptyPrice() throws Exception {
        clickAddButton();
        enterProductName();
        enterAmount();
        closeKeyboard();
        clickCreateButton();
        checkEmptyPrice();
    }

    @Test
    public void test8_productAbsence() throws Exception {
        checkProductAbsence();
    }

}
