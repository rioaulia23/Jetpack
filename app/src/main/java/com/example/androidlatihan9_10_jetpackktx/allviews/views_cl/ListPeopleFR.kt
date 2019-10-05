package com.example.androidlatihan9_10_jetpackktx.allviews.views_cl

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidlatihan9_10_jetpackktx.R
import com.example.androidlatihan9_10_jetpackktx.datareff.model.People
import kotlinx.android.synthetic.main.fr_list_contact.*

class ListPeopleFR : Fragment(), ListpeopleAdapter.OnItemClickListener{
    private lateinit var viewModel: PeopleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this)
            .get(PeopleListViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_list_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPeopleList().observe(this, Observer<List<People>>{
            peoples -> peoples?.let{
            populatedPeopleList(peoples)
        }
        })
    }
    private fun populatedPeopleList(peopleList : List<People>){
        peopleRCView.adapter = ListpeopleAdapter(peopleList, this)
    }

    override fun onItemClick(people: People, itemView: View) {
       d("TAG_PEOPLE", "People List")
        Toast.makeText(activity!!.applicationContext,
            "Test People", Toast.LENGTH_SHORT).show()
    }
}
