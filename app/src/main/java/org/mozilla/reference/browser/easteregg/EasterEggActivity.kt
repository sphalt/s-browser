package org.mozilla.reference.browser.easteregg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.mozilla.reference.browser.R
import org.mozilla.reference.browser.addons.AddonsFragment

class EasterEggActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, EasterEggFragment())
                commit()
            }
        }
    }
}