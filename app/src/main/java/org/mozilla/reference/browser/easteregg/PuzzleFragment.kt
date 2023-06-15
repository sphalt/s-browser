package org.mozilla.reference.browser.easteregg

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import mozilla.components.browser.state.action.ContentAction
import mozilla.components.browser.state.action.TabListAction
import mozilla.components.browser.state.state.content.DownloadState
import mozilla.components.browser.state.state.createTab
import org.mozilla.reference.browser.R
import org.mozilla.reference.browser.ext.requireComponents

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val DIFFICULTY_LEVEL = "DIFFICULTY_LEVEL"
private const val SESSION_ID = "SESSION_ID"

/**
 * A simple [Fragment] subclass.
 * Use the [PuzzleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PuzzleFragment : DialogFragment() {
    private var difficultyLevel = DifficultyLevel.EASY
    private var sessionId: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            difficultyLevel = DifficultyLevel.valueOf(it.getString(DIFFICULTY_LEVEL).toString())
            sessionId = it.getString(SESSION_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_puzzle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val puzzle = Puzzles().puzzles[difficultyLevel]!!
        val tvlevel = view.findViewById<TextView>(R.id.textview)
        tvlevel.setText(puzzle.question)

        val etAnswer = view.findViewById<TextView>(R.id.editTextText2)
        val btnSubmit = view.findViewById<TextView>(R.id.btn_submit_answer)

        val downloader: EasterEggDownloader = EasterEggDownloader(requireContext())

        btnSubmit.setOnClickListener(View.OnClickListener {
            if (puzzle.verifyAnswer(etAnswer.text.toString())) {
                RewardDialogFragment().show(parentFragmentManager, "TAG")
                dismiss()
            } else {
                etAnswer.setError("Wrong Answer!")
            }
        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param level String - Difficulty Level of the riddle.
         * @return A new instance of fragment PuzzleFragment.
         */
        @JvmStatic
        fun newInstance(level: String, sessionId: String?) =
            PuzzleFragment().apply {
                arguments = Bundle().apply {
                    putString(DIFFICULTY_LEVEL, level)
                    putString(SESSION_ID, sessionId)

                }
            }
    }
}