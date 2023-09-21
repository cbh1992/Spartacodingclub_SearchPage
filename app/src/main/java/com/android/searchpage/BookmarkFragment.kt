package com.android.searchpage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.searchpage.databinding.FragmentBookmarkBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BookmarkFragment : Fragment() {

    private lateinit var mContext: Context
    private var binding: FragmentBookmarkBinding? = null
    private lateinit var adapter: BookmarkAdapter

    private var likeItem : List<SearchItemModel> = listOf()

    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainActivity=activity as MainActivity
        likeItem = mainActivity.itemcheck

        adapter = BookmarkAdapter(mContext).apply {
            items = likeItem.toMutableList()
        }
        binding = FragmentBookmarkBinding.inflate(inflater,container,false).apply {
            RecyclerViewBookmark.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            RecyclerViewBookmark.adapter = adapter
        }
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookmarkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}