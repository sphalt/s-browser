package org.mozilla.reference.browser.easteregg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.mozilla.reference.browser.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val DIFFICULTY_LEVEL = "EASY"

/**
 * A simple [Fragment] subclass.
 * Use the [PuzzleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PuzzleFragment : Fragment() {
    private var difficulty_level: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            difficulty_level = it.getString(DIFFICULTY_LEVEL)
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

        val tvlevel = view.findViewById<TextView>(R.id.textview)
        tvlevel.setText(difficulty_level)

        val etAnswer = view.findViewById<TextView>(R.id.editTextText2)
        val btnSubmit = view.findViewById<TextView>(R.id.btn_submit_answer)

        btnSubmit.setOnClickListener(View.OnClickListener {
            if (etAnswer.text.isNotEmpty()) {
                //Display dialog fragment

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
        fun newInstance(level: String) =
            PuzzleFragment().apply {
                arguments = Bundle().apply {
                    putString(DIFFICULTY_LEVEL, level)
                }
            }
    }
}