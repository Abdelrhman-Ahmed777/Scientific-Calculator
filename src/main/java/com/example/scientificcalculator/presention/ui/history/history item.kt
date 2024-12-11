package com.example.scientificcalculator.presention.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.scientificcalculator.domain.Item
import com.example.scientificcalculator.ui.theme.Orange80
import com.example.scientificcalculator.ui.theme.black
import com.example.scientificcalculator.ui.theme.white

@Composable

fun HistoryItem(item: Item) {
    Card(
        shape = RectangleShape ,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(black)

        ) {
            val (problem , answer , date , time) = createRefs()
            Text(text = item.problem ,
                fontSize = 18.sp ,
                color = white,
                modifier = Modifier.constrainAs(problem) {
                    top.linkTo(parent.top , margin = 16.dp)
                    start.linkTo(parent.start , margin = 16.dp)
                })
            Text(text = item.answer ,
                fontSize = 18.sp ,
                color = Orange80,
                modifier = Modifier.constrainAs(answer) {
                top.linkTo(problem.bottom , margin = 16.dp)
                end.linkTo(parent.end , margin = 16.dp)
            })
            Text(text = item.date , color = white ,modifier = Modifier.constrainAs(date) {
                bottom.linkTo(parent.bottom , margin = 16.dp)
                end.linkTo(time.start , margin = 16.dp)
            })
            Text(text = item.time , color = white , modifier = Modifier.constrainAs(time) {
                bottom.linkTo(parent.bottom , margin = 16.dp)
                end.linkTo(parent.end , margin = 16.dp)
            })
        }
    }
}
