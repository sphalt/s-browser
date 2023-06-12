package org.mozilla.reference.browser.easteregg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.mozilla.reference.browser.R

/**
 * A simple [Fragment] subclass.
 * Use the [EasterEggFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EasterEggFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_easter_egg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_easy).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_medium).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_hard).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_easy -> {
                beginPuzzle("EASY")
            }
            R.id.btn_medium -> {
                beginPuzzle("MEDIUM")
            }
            R.id.btn_hard -> {
                beginPuzzle("HARD")
            }
        }
    }

    private fun beginPuzzle(level: String) {
        val puzzleFragment = PuzzleFragment.newInstance(level)
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.container, puzzleFragment)
            addToBackStack(null)
            commit()
        }
    }
}