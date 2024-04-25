package com.example.sports.data

import com.example.sports.R
import com.example.sports.model.Sport // imports

class Datasource() { // datasource for the app

    fun loadSport(): List<Sport> {
        return listOf<Sport>(
            Sport(R.string.sport1, R.drawable.basketball),
            Sport(R.string.sport2, R.drawable.boxing),
            Sport(R.string.sport3, R.drawable.chess_),
            Sport(R.string.sport4, R.drawable.golf), // the description of the game like name, year and the inventor of the game and the image
            Sport(R.string.sport5, R.drawable.karate), // strings.xml contains the information like the text of the desription and name
            Sport(R.string.sport6, R.drawable.racing),
            Sport(R.string.sport7, R.drawable.rugby),
            Sport(R.string.sport8, R.drawable.swimming)
        )
    }
}