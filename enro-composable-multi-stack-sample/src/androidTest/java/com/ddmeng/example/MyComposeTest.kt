package com.ddmeng.example

import androidx.compose.material.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.ddmeng.example.ui.theme.AndroidComposeHelloWorldTheme
import org.junit.Rule
import org.junit.Test

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun MyTest() {
        // Start the app
        composeTestRule.setContent {
            AndroidComposeHelloWorldTheme {
                Text(text = "Hello Jetpack Compose")
            }
        }

        composeTestRule.onNodeWithText("Hello Jetpack Compose").assertIsDisplayed()
    }
}
