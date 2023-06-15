package org.mozilla.reference.browser.ui

import org.junit.Rule
import org.mozilla.reference.browser.helpers.BrowserActivityTestRule
import org.mozilla.reference.browser.helpers.RetryTestRule

class EasterEggTest {
    @get:Rule
    val browserActivityTestRule = BrowserActivityTestRule()

    @Rule
    @JvmField
    val retryTestRule = RetryTestRule(3)


}