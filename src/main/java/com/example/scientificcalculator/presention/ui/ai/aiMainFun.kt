package com.example.scientificcalculator.presention.ui.ai

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.scientificcalculator.R.drawable.send_ic
import com.example.scientificcalculator.presention.viewModel.AiViewModel
import com.example.scientificcalculator.ui.theme.black
import com.example.scientificcalculator.ui.theme.darkBlue2
import com.example.scientificcalculator.ui.theme.digital
import com.example.scientificcalculator.ui.theme.lightBlue
import com.example.scientificcalculator.ui.theme.white

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun MainAiChat(navController: NavController) {

    val message = remember { mutableStateOf("") }
    val aiViewModel = AiViewModel()
    val messageList by aiViewModel.messageListState.collectAsState()



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (back , title , messages , chatBox , sendButton) = createRefs()





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
                text = "AI Assistant" ,
                fontFamily = digital ,
                fontSize = 40.sp ,
                color = white ,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top , margin = 64.dp)
                        start.linkTo(back.end , margin = 24.dp)
                    }
            )
            MessageList(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 60.dp , bottom = 48.dp)
                .constrainAs(messages) {
                    top.linkTo(title.bottom , margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(chatBox.top , margin = 16.dp)
                } , messageList = messageList)

            AiInPut(
                message = message ,
                onMessageSend = {
                    aiViewModel.onMessageSend(message.value)
                    message.value = ""
                } ,
                modifier = Modifier.constrainAs(chatBox) {
                    bottom.linkTo(parent.bottom , margin = 64.dp)
                    start.linkTo(parent.start , margin = 16.dp)
                }
            )

            Button(
                onClick = {
                    aiViewModel.onMessageSend(message.value)
                    message.value = ""

                } ,
                modifier = Modifier
                    .height(60.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .constrainAs(sendButton) {
                        bottom.linkTo(parent.bottom , margin = 32.dp)
                        start.linkTo(chatBox.end , margin = 16.dp)
                    } ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(
                    lightBlue
                ) ,
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(send_ic) ,
                    tint = darkBlue2 ,
                    modifier = Modifier
                        .requiredSize(30.dp) ,
                    contentDescription = null
                )


            }
        }
    }
}









