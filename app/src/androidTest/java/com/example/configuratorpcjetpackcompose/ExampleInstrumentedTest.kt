package com.example.configuratorpcjetpackcompose

import android.R
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.configuratorpcjetpackcompose.utils.TagsForTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun registrationTestWithData1() {
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL).performTextInput(" ")
        composeTestRule.onNodeWithTag(TagsForTest.PASSWORD).performTextInput("Aa123456")
        composeTestRule.onNodeWithTag(TagsForTest.REPEATED_PASSWORD).performTextInput("Aa123456")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON).performClick()
    }
    @Test
    fun registrationTestWithData2() {
        composeTestRule.onNodeWithTag("appTextField").performTextInput("123456")
        composeTestRule.onNodeWithTag("appTextField").performTextInput("")
        composeTestRule.onNodeWithTag("appTextField").performTextInput("Aa123456")
        composeTestRule.onNodeWithTag("Button").performClick()
    }
    @Test
    fun registrationTestWithData3() {
        composeTestRule.onNodeWithTag("appTextField").performTextInput("123456")
        composeTestRule.onNodeWithTag("appTextField").performTextInput("Aa123456")
        composeTestRule.onNodeWithTag("appTextField").performTextInput("")
        composeTestRule.onNodeWithTag("Button").performClick()
    }
    @Test
    fun registrationTestWithData4() {
        composeTestRule.onNodeWithTag("appTextField").performTextInput("123456")
        composeTestRule.onNodeWithTag("appTextField").performTextInput("Aa123456")
        composeTestRule.onNodeWithTag("appTextField").performTextInput("Aa123456")
        composeTestRule.onNodeWithTag("Button").performClick()
    }
}