package com.example.scientificcalculator.presention.ui.ai

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scientificcalculator.R
import com.example.scientificcalculator.domain.MessageData
import com.example.scientificcalculator.presention.viewModel.AiViewModel
import com.example.scientificcalculator.ui.theme.darkBlue
import com.example.scientificcalculator.ui.theme.darkGreen
import com.example.scientificcalculator.ui.theme.darkPurple
import com.example.scientificcalculator.ui.theme.lightBlue
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserMessages(
    messageContent: MessageData
) {
    messageContent.sendingDate = LocalDate.now()

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .widthIn(min = 150.dp , max = 200.dp)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 30.dp ,
                        bottomStart = 30.dp ,
                        topStart = 30.dp
                    )
                ) ,
            colors = CardDefaults.cardColors(containerColor = lightBlue)
        ) {
            Column(
                verticalArrangement = Arrangement.Top ,
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Text(
                    text = messageContent.text ,
                    fontSize = 20.sp ,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(16.dp , 16.dp , 16.dp , 0.dp) ,
                    color = Color.White

                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.End ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp) ,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        text = messageContent.sendingTime ,
                        color = darkPurple
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (messageContent.isSent && !messageContent.isDelivered && !messageContent.isSeen) {
                                R.drawable.done_ic
                            } else {
                                R.drawable.done_all_ic
                            }
                        ) ,
                        contentDescription = null ,
                        tint = if (messageContent.isSeen) darkGreen else Color.Gray ,
                        modifier = Modifier
                            .size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                }
                Spacer(modifier = Modifier.height(8.dp))
            }


        }


    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FriendMessage(
    messageContent: MessageData
) {

    var isFav by remember { mutableStateOf(false) }
    val aiViewModel = AiViewModel()
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)

    ) {
        Card(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            isFav = !isFav
                            messageContent.isFav = isFav
                            Log.d("fav" , "isFav: ${messageContent.isFav}")
                        }
                    )
                }
                .wrapContentWidth()
                .widthIn(max = 350.dp)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp ,
                        topEnd = 30.dp ,
                        bottomEnd = 30.dp ,
                        bottomStart = 30.dp
                    )
                ) ,
            colors = CardDefaults.cardColors(containerColor = darkBlue)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                if (isFav) {
                    Icon(
                        imageVector = Icons.Default.Favorite ,
                        contentDescription = "Favorite" ,
                        tint = Color.Red ,
                        modifier = Modifier
                            .padding(16.dp , 16.dp , 16.dp , 0.dp)
                            .size(20.dp)
                            .align(Alignment.End)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Text(
                    text = messageContent.text ,
                    modifier = Modifier
                        .width(300.dp)
                        .wrapContentHeight()
                        .padding(
                            16.dp ,
                            if (messageContent.isFav) 0.dp else 16.dp ,
                            16.dp ,
                            0.dp
                        ) ,
                    color = Color.White ,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = messageContent.sendingTime ,
                    color = lightBlue ,
                    modifier = Modifier
                        .padding(16.dp , 0.dp , 16.dp , 16.dp)
                        .align(Alignment.End)

                )


            }


        }
    }
}