package com.example.configuratorpcjetpackcompose

import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.configuratorpcjetpackcompose.screens.SingUpScreen
import com.example.configuratorpcjetpackcompose.ui.theme.AppTheme
import com.example.configuratorpcjetpackcompose.utils.TagsForTest
import org.junit.Assert.*
import org.junit.Before
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
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.RESULT, useUnmergedTree = true).assert(hasText("Адрес электронной почты введён неверно"))
    }

    @Test
    fun registrationTestWithData2() {
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("qwe")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.RESULT, useUnmergedTree = true).assert(hasText("Адрес электронной почты введён неверно"))
    }
    @Test
    fun registrationTestWithData3() {
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("qwertygmail.com")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.RESULT, useUnmergedTree = true).assert(hasText("Адрес электронной почты введён неверно"))
    }
    @Test
    fun registrationTestWithData4() {
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("qwerty@gmail.com")
        composeTestRule.onNodeWithTag(TagsForTest.PASSWORD, useUnmergedTree = true).performTextInput("123456Aa")
        composeTestRule.onNodeWithTag(TagsForTest.REPEATED_PASSWORD, useUnmergedTree = true).performTextInput("123456")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.RESULT, useUnmergedTree = true).assert(hasText("Пароли не совпадают"))
    }
    @Test
    fun registrationTestWithData5() {
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("qwerty@gmail.com")
        composeTestRule.onNodeWithTag(TagsForTest.PASSWORD, useUnmergedTree = true).performTextInput("123")
        composeTestRule.onNodeWithTag(TagsForTest.REPEATED_PASSWORD, useUnmergedTree = true).performTextInput("123")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.RESULT, useUnmergedTree = true).assert(hasText("Длина пароля должна быть больше 6 символов"))
    }
    @Test
    fun registrationTestWithData6() {
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("qwerty@gmail.com")
        composeTestRule.onNodeWithTag(TagsForTest.PASSWORD, useUnmergedTree = true).performTextInput("")
        composeTestRule.onNodeWithTag(TagsForTest.REPEATED_PASSWORD, useUnmergedTree = true).performTextInput("")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.RESULT, useUnmergedTree = true).assert(hasText("Длина пароля должна быть больше 6 символов"))
    }
    @Test
    fun registrationTestWithData7() {
        composeTestRule.onNodeWithTag(TagsForTest.MAIN_SCREEN, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.ENTER_BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.EMAIL, useUnmergedTree = true).performTextInput("qwerty@gmail.com")
        composeTestRule.onNodeWithTag(TagsForTest.PASSWORD, useUnmergedTree = true).performTextInput("1234567")
        composeTestRule.onNodeWithTag(TagsForTest.REPEATED_PASSWORD, useUnmergedTree = true).performTextInput("1234567")
        composeTestRule.onNodeWithTag(TagsForTest.BUTTON, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithTag(TagsForTest.CONFIGURATION_SCREEN, useUnmergedTree = true)
    }
}