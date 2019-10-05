package com.example.androidlatihan9_10_jetpackktx.datareff.databases

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import com.example.androidlatihan9_10_jetpackktx.datareff.data_raw.PeopleListInfo
import com.example.androidlatihan9_10_jetpackktx.datareff.model.People


@Database(entities = [People::class], version = 1)
abstract class PeopleDB : RoomDatabase(){
    abstract fun peopleDao() : PeopleDAO

    companion object {
        private val lock = Any()
        private const val DB_NAME = "people.db"
        private var INSTANCE: PeopleDB? = null

        fun getInstance(application: Application) : PeopleDB{
            synchronized(lock){
                if (PeopleDB.INSTANCE == null){
                    PeopleDB.INSTANCE =
                            Room.databaseBuilder(application,
                                PeopleDB::class.java, PeopleDB.DB_NAME)
                                .allowMainThreadQueries()
                                .addCallback(object  : RoomDatabase.Callback(){
                                    override fun onCreate(db: SupportSQLiteDatabase) {
                                        super.onCreate(db)
                                        PeopleDB.INSTANCE?.let{
                                            PeopleDB.prePopulated(it,
                                                PeopleListInfo.peopleListInfo)
                                        }
                                    }
                                }).build()
                }
            }
            return INSTANCE!!
        }
        fun prePopulated(db: PeopleDB, peopleList: List<People>){
            for (people in peopleList){
                AsyncTask.execute { db.peopleDao().insert(people) }
            }
        }
    }
}