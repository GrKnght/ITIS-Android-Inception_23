package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.ui.adapter.NewsAdapter
import com.kpfu.itis.android_inception_23.ui.adapter.decorations.SimpleHorizontalMarginDecorator
import com.kpfu.itis.android_inception_23.ui.adapter.decorations.SimpleVerticalDecorator
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentNewsfeedBinding
import com.kpfu.itis.android_inception_23.model.NewsDataModel
import com.kpfu.itis.android_inception_23.utils.NewsDataRepository
import com.kpfu.itis.android_inception_23.utils.ParamsKey
import com.kpfu.itis.android_inception_23.utils.getValueInPx

class NewsFeedFragment : BaseFragment(R.layout.fragment_newsfeed) {

    private val viewBinding: FragmentNewsfeedBinding by viewBinding(FragmentNewsfeedBinding::bind)

    private var newsAdapter: NewsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        newsAdapter = null
    }

    private fun initRecyclerView() {
        newsAdapter = NewsAdapter(
            onNewsClicked = ::onNewsClicked,
            onLikeClicked = ::onLikeClicked
        )

        with(viewBinding) {
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            newsfeedRv.layoutManager = layoutManager
            newsfeedRv.adapter = newsAdapter

            val marginValue = 16.getValueInPx(resources.displayMetrics)
            newsfeedRv.addItemDecoration(SimpleHorizontalMarginDecorator(itemOffset = marginValue))
            newsfeedRv.addItemDecoration(SimpleVerticalDecorator(itemOffset = marginValue / 4))

            newsAdapter?.setItems(NewsDataRepository.getNewsList())
        }
    }

    private fun onNewsClicked(newsDataModel: NewsDataModel) {
//        (requireActivity() as? MainActivity)?.goToScreen(
//            actionType = ActionType.REPLACE,
//            destination = NewsDetailsFragment(),
//            tag = NewsDetailsFragment.NEWS_DETAILS_FRAGMENT_TAG,
//        )
//        NewsDataRepository.addItem()
//        newsAdapter?.setItems(NewsDataRepository.getNewsList())
        parentFragmentManager.setFragmentResult(ParamsKey.DIALOG_RESULT_KEY, bundleOf("first" to "second"))
    }

    private fun onLikeClicked(position: Int, newsDataModel: NewsDataModel) {
        newsAdapter?.updateItem(position, newsDataModel)
    }

    companion object {
        const val NEWSFEED_FRAGMENT_TAG = "NEWSFEED_FRAGMENT_TAG"
    }
}