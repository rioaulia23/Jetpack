package com.example.androidlatihan9_10_jetpackktx.allviews.views_cl

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.example.androidlatihan9_10_jetpackktx.StartApp
import com.example.androidlatihan9_10_jetpackktx.datareff.model.People

class PeopleListViewModel (application: Application) :AndroidViewModel(application){
    private val peopleRepo = getApplication<StartApp>().getPeopleRepo()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllpeople()
    }
    fun getPeopleList() : LiveData<List<People>>{
        return peopleList
    }
    fun getAllpeople(){
        peopleList.addSource(peopleRepo.getAllPeople()){
            peoples -> peopleList.postValue(peoples)
        }
    }
}