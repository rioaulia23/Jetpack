package com.example.androidlatihan9_10_jetpackktx.datareff

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.androidlatihan9_10_jetpackktx.datareff.databases.PeopleDAO
import com.example.androidlatihan9_10_jetpackktx.datareff.databases.PeopleDB
import com.example.androidlatihan9_10_jetpackktx.datareff.model.People

class Main2 (application: Application){
    private val peopleDAO : PeopleDAO

    init {
        val peopleDB = PeopleDB.getInstance(application)
        peopleDAO = peopleDB.peopleDao()
    }
    fun getAllPeople() : LiveData<List<People>>{
        return peopleDAO.getAll()
    }
    fun insertPeople(people: People){
        peopleDAO.insert(people)
    }
    fun findPeople(id : Int) : People?{
        return peopleDAO.find(id)
    }
}