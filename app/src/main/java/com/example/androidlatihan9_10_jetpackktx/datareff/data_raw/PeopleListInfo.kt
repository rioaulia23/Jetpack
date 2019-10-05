package com.example.androidlatihan9_10_jetpackktx.datareff.data_raw

import com.example.androidlatihan9_10_jetpackktx.datareff.model.People

class PeopleListInfo {
    companion object{
        var peopleListInfo = initPeopleList()
        fun initPeopleList() : MutableList<People> {
            var po_peoples = mutableListOf<People>()
            po_peoples.add(
                People(
                    "Rio",
                    "Bontang",
                    "082229255707",
                    "rioaulia23@gmail.com",
                    "rioauliayahya",
                    "rioaulia"
                )
            )
            po_peoples.add(
                People(
                    "Peter",
                    "New York",
                    "021858",
                    "perterr@gmail.com",
                    "peterganteng",
                    "petercool"
                )
            )
            po_peoples.add(
                People(
                    "Paimin",
                    "Asmat",
                    "089638145",
                    "paimin@gmail.com",
                    "paimin",
                    "paimin"
                )
            )
            po_peoples.add(
                People(
                    "Tejo",
                    "Maluku",
                    "082229247",
                    "tejo@gmail.com",
                    "tejoaja",
                    "tejoaja"
                )
            )
            return po_peoples
        }
    }
}