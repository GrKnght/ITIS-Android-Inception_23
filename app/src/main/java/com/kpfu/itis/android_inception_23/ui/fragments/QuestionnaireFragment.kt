package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.adapter.ChatAdapter
import com.kpfu.itis.android_inception_23.adapter.QuestionnaireAdapter
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentQuestionnaireBinding
import com.kpfu.itis.android_inception_23.model.MessageModel
import com.kpfu.itis.android_inception_23.model.QuestionData
import com.kpfu.itis.android_inception_23.utils.QuestionGenerator

class QuestionnaireFragment : BaseFragment(R.layout.fragment_questionnaire) {

    private val viewBinding: FragmentQuestionnaireBinding by viewBinding(FragmentQuestionnaireBinding::bind)

    private var rvAdapter: QuestionnaireAdapter? = null

    private var chatAdapter: ChatAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        savedInstanceState?.let { bundle ->
            viewBinding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.teal_700))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("KEY", "VALUE")
    }

    private fun initRecyclerView() {
        with(viewBinding) {
            val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            questionnaireRv.layoutManager = layoutManager
            rvAdapter = QuestionnaireAdapter(
                items = QuestionGenerator.getQuestions(requireContext(), 45).map { QuestionData(question = it) }
                    .toMutableList(),

                onItemChecked = { position, isChecked ->
                    rvAdapter?.items?.let {
                        it[position].isChecked = isChecked
                    }
                },
                onRootClicked = { position ->

                }
            )

            chatAdapter = ChatAdapter(items = getMessagesData())

            questionnaireRv.adapter = chatAdapter
        }
    }

    private fun getMessagesData(): MutableList<MessageModel> {
        return mutableListOf(
            MessageModel(
                messageText = "Hello",
                id = "12",
                isCurrentUserMessage = true,
                messageDate = "24 Января"
            ),
            MessageModel(
                messageText = "general",
                id = "13",
                isCurrentUserMessage = true,
                messageDate = "24 Января"
            ),
            MessageModel(
                messageText = "Kenobi",
                id = "14",
                isCurrentUserMessage = true,
                messageDate = "24 Января"
            ),
            MessageModel(
                messageText = "Hello",
                id = "15",
                isCurrentUserMessage = false,
                messageDate = "24 Января"
            ),
            MessageModel(
                messageText = "Hello 2",
                id = "16",
                isCurrentUserMessage = false,
                messageDate = "24 Января"
            ),
            MessageModel(
                messageText = "Hello 3 ",
                id = "17",
                isCurrentUserMessage = true,
                messageDate = "24 Января"
            ),
            MessageModel(
                messageText = "Hello 4",
                id = "18",
                isCurrentUserMessage = false,
                messageDate = "24 Января"
            ),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        rvAdapter = null
    }
}