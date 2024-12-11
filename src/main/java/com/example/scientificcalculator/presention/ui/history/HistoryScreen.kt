package com.example.scientificcalculator.presention.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.scientificcalculator.domain.Repository
import com.example.scientificcalculator.presention.viewModel.DataBaseViewModel
import com.example.scientificcalculator.ui.theme.black
import com.example.scientificcalculator.ui.theme.darkPurple
import com.example.scientificcalculator.ui.theme.digital
import com.example.scientificcalculator.ui.theme.lightPurple
import com.example.scientificcalculator.ui.theme.midPurple
import com.example.scientificcalculator.ui.theme.white

@Composable
fun HistoryScreen(navController: NavController , repository: Repository) {
    val backgroud = Brush.verticalGradient(listOf(
        black,
        black,
        darkPurple ,
        darkPurple ,
        midPurple ,
        lightPurple ,
        lightPurple
    ))

    val viewModel = DataBaseViewModel(repository)
    val allItems by viewModel.getAllItems().collectAsState(emptyList())

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(backgroud)
    ) {
        val (title , back , history) = createRefs()



        Icon(
            Icons.AutoMirrored.Filled.ArrowBack ,
            contentDescription = "back" ,
            modifier = Modifier
                .size(30.dp)
                .constrainAs(back) {
                    start.linkTo(parent.start , margin = 24.dp)
                    top.linkTo(parent.top , margin = 64.dp)
                }
                .clickable {
                    navController.popBackStack()
                } ,
            tint = white
        )


        Text(
            text = "History" ,
            fontFamily = digital ,
            fontSize = 40.sp ,
            color = white ,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top , margin = 64.dp)
                    start.linkTo(back.end , margin = 24.dp)
                }
        )




        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight().padding(top = 124.dp , bottom = 64.dp)
                .constrainAs(history) {
                    top.linkTo(parent.top , margin = 124.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            item(allItems) {
                allItems.forEach { item ->
                    HistoryItem(item)
                }
            }
        }
    }
}