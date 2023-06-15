package org.mozilla.reference.browser.ui.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.mozilla.reference.browser.R

class EasterEggRobot {

    fun verifyEasterEggViewExists() = assertEasterEggView()


    private fun assertEasterEggView() {
        //verify we can see the appropriate view
        Espresso.onView(withText(R.string.text_easter_egg_choose_difficulty))
        Espresso.onView(withText(R.string.label_easter_egg_easy))
    }
    class Transition {}
}