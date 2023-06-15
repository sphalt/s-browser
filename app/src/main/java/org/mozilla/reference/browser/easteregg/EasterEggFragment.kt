package org.mozilla.reference.browser.easteregg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import org.mozilla.reference.browser.R

/**
 * A simple [Fragment] subclass.
 * Fragment used to let user pick difficulty level for the puzzle - shown as a dialog.
 */
class EasterEggFragment (
    private val sessionId: String? = null
): DialogFragment(), View.OnClickListener {

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
                beginPuzzle(DifficultyLevel.EASY.name)
            }
            R.id.btn_medium -> {
                beginPuzzle(DifficultyLevel.MEDIUM.name)
            }
            R.id.btn_hard -> {
                beginPuzzle(DifficultyLevel.HARD.name)
            }
        }
    }

    private fun beginPuzzle(level: String) {
        val puzzleFragment = PuzzleFragment.newInstance(level, sessionId)
        puzzleFragment.show(parentFragmentManager, "TAG")
        dismiss()
    }
}