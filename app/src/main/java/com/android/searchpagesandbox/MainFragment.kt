package com.android.searchpage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.searchpage.databinding.FragmentMainBinding
import com.android.searchpage.databinding.FragmentSearchBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var Context: Context

    //private lateinit var adapter : MainAdapter
    //private var items : ArrayList<MainItemModel> = ArryList()
    private var param1: String? = null
    private var param2: String? = null

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
        val binding = FragmentMainBinding.inflate(inflater, container, false)
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

        setView()
        setListenser()

        return binding.root
    }


    private fun setView() {
        val viewmanager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        //binding.RecyclerView.layoutManager = viewmanager
        //adapter = MainAdapter(Context)
        //binding.RecyclerView.adapter=adapter
        //binding.RecyclerView.itemAnimator=null

    }

    private fun setListenser() {
//        binding.SearchButton.setOnClickListener {
//            val input = binding.SearchText.text.toString()
//            if(input.isEmpty()){
//                Toast.makeText(Context,"검색어를 입력해 주세요",Toast.LENGTH_SHORT).show()}
//                else{
//                    //adapter.clearItem()
//                    //fetchImageResult(query)
//                }
//            }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}