package com.example.sports
//Midterm Exam = Jerome Gabriel N. Almenie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sports.data.Datasource
import com.example.sports.ui.theme.SportsTheme
import androidx.compose.material3.Card
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.sports.model.Sport


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), // fill the max size of the background
                    color = MaterialTheme.colorScheme.secondary // adds secondary color to the background
                ) {
                    SportApp() // name of the app 1
                   //SportButtonApp() // what is sport
                }
            }
        }
    }
}
@Composable
fun SportButtonApp() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.differentbg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(), // for the width of the picture on the sportbuttonapp
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "A human activity involving physical exertion and skill as the primary focus of the activity",
            fontSize = 20.sp, // font size of the text
            modifier = Modifier
                .padding(5.dp) // padding of the text that will show in How to play
        )
    }
}


@Composable
fun SportApp(){ // connected to the start of the game the name of the App  SportApp
    SportList(
        sportList = Datasource().loadSport(), // for the source of data in datasource
    )
}
@Composable
fun SportCard(sport: Sport, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {
        Column{
            Image(
                painter = painterResource(sport.imageResourceId),
                contentDescription = stringResource(sport.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth() // width of the card the will be use
                    .height(300.dp), // height of the picture in the app
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = LocalContext.current.getString(sport.stringResourceId), // string resource id in sports.kt
                modifier = Modifier.padding(10.dp), // padding of the text in the app
                style = MaterialTheme.typography.headlineMedium // fontsize of the text in the app
            )
        }
    }
}
@Preview
@Composable
private fun SportCardPreview() { // preview
    SportCard(Sport(R.string.sport1, R.drawable.basketball)) // preview of the app // description of basketball and the picture of the sports
}
@Composable
fun SportList(sportList: List<Sport>, modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {
        items(sportList) { sport ->
            SportCard(
                sport = sport,
                modifier = Modifier.padding(8.dp) // padding for whole pictures
            )
        }
    }
}

