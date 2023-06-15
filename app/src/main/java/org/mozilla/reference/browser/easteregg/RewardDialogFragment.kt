package org.mozilla.reference.browser.easteregg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import mozilla.components.browser.state.action.ContentAction
import mozilla.components.browser.state.action.TabListAction
import mozilla.components.browser.state.state.content.DownloadState
import mozilla.components.browser.state.state.createTab
import org.mozilla.reference.browser.R
import org.mozilla.reference.browser.ext.requireComponents

class RewardDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reward, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDownloadReward = view.findViewById<Button>(R.id.btn_download_file)
        val btnCancel = view.findViewById<Button>(R.id.btn_cancel)
        btnDownloadReward.setOnClickListener(View.OnClickListener {
            downloadTextFile()
        })
        btnCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun downloadTextFile() {
        val store = requireComponents.core.store
        val url = "https://gitlab.com/censorship-no/ceno-browser/-/raw/main/fastlane/metadata/android/en-US/full_description.txt"
        val downloadState = DownloadState(
            url,
            openInApp = true
        )

        createTab("about:blank").apply {
            store.dispatch(TabListAction.AddTabAction(this, select = true))
            store.dispatch(ContentAction.UpdateDownloadAction(this.id, downloadState))
        }
        dismiss()
    }
}