package com.example.scientificcalculator.presention.ui.ai

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.scientificcalculator.R.drawable.send_ic
import com.example.scientificcalculator.presention.viewModel.AiViewModel
import com.example.scientificcalculator.ui.theme.darkBlue2
import com.example.scientificcalculator.ui.theme.lightBlue
import com.example.scientificcalculator.ui.theme.white

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
fun MainAiChat(navController: NavController) {

    val message = remember { mutableStateOf("") }
    val aiViewModel = AiViewModel()
    val messageList by aiViewModel.messageListState.collectAsState()


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .windowInsetsPadding(WindowInsets.ime) ,
        topBar = {
            TopAppBar(
                title = { Text("Ai Assistant" , fontSize = 32.sp , color = Color.White) } ,
                navigationIcon = {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack ,
                        contentDescription = "Menu" ,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { navController.popBackStack() } ,
                        tint = Color.White
                    )
                } ,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = lightBlue)
            )
        } ,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(white)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val (messages , chatBox , sendButton) = createRefs()

                    MessageList(modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 60.dp , bottom = 48.dp)
                        .constrainAs(messages) {
                            top.linkTo(parent.top)
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
                            bottom.linkTo(parent.bottom , margin = 32.dp)
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
    )
}








