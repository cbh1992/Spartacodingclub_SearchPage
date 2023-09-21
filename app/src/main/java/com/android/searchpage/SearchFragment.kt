package com.android.searchpage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.searchpage.databinding.FragmentSearchBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding
    private lateinit var mContext: Context
    private lateinit var adapter: SearchAdapter
    private lateinit var gridmanager: StaggeredGridLayoutManager
    private var resItems:ArrayList<SearchItemModel> = ArrayList()

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
        binding= FragmentSearchBinding.inflate(inflater,container,false)

        setupView()
        setupListener()

        return binding.root
    }


    private fun setupView() {
        gridmanager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        binding.RecyclerView.layoutManager = gridmanager
        adapter = SearchAdapter(mContext)
        binding.RecyclerView.adapter = adapter
        binding.RecyclerView.itemAnimator=null


    }

    private fun setupListener() {
        //검색버튼 클릭시 이벤트
        binding.SearchButton.setOnClickListener {
            //데이터 저장하기
            val pref = requireActivity().getSharedPreferences("pref", 0)
            val edit = pref.edit()
            edit.putString("input", binding.SearchText.text.toString())
            edit.apply()
        }
        //데이터 불러오기
        val pref = requireActivity().getSharedPreferences("pref", 0)
        binding.SearchText.setText(pref.getString("input", ""))
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}