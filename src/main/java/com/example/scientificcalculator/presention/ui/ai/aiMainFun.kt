
package com.example.scientificcalculator.presention.ui.ai

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.scientificcalculator.R
import com.example.scientificcalculator.R.drawable.send_ic
import com.example.scientificcalculator.domain.MessageData
import com.example.scientificcalculator.presention.viewModel.AiViewModel
import com.example.scientificcalculator.ui.theme.black
import com.example.scientificcalculator.ui.theme.darkBlue
import com.example.scientificcalculator.ui.theme.darkBlue2
import com.example.scientificcalculator.ui.theme.darkGreen
import com.example.scientificcalculator.ui.theme.darkPurple
import com.example.scientificcalculator.ui.theme.lightBlue
import com.example.scientificcalculator.ui.theme.white
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
fun MainAiChat(navController: NavController) {

    val message = remember { mutableStateOf("") }
    val aiViewModel = AiViewModel()
    val messageList by aiViewModel.messageListState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                        Icons.Default.Menu ,
                        contentDescription = "Menu" ,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { scope.launch { drawerState.open() } } ,
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
                            start.linkTo(parent.start, margin = 32.dp)
                        }
                    )

                    Button(
                        onClick = {
                            aiViewModel.onMessageSend(message.value)
                            message.value = ""

                        } ,
                        modifier = Modifier
                            .size(50.dp)
                            .constrainAs(sendButton) {
                                bottom.linkTo(parent.bottom , margin = 32.dp)
                                start.linkTo(chatBox.end , margin = 16.dp)
                            } ,
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


@Composable
fun AiInPut(message: MutableState<String> , onMessageSend: (String) -> Unit , modifier: Modifier) {


    TextField(
        value = message.value ,
        onValueChange = {
            message.value = it
        } ,
        enabled = true ,
        modifier = modifier
            .wrapContentHeight()
            .width(330.dp)
            .shadow(
                elevation = 10.dp ,
                shape = RoundedCornerShape(50.dp) ,
                ambientColor = black ,
                spotColor = black
            )
            .scrollable(
                state = rememberScrollState() ,
                orientation = Orientation.Vertical
            )
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 2.dp ,
                color = lightBlue ,
                shape = RoundedCornerShape(50.dp)
            ) ,
        placeholder = {
            Text(text = "Type something......." , style = TextStyle(color = Color.Gray))
        } ,
        maxLines = 50 ,
        colors = TextFieldDefaults.colors(
            focusedTextColor = lightBlue ,
            unfocusedTextColor = lightBlue ,
            focusedContainerColor = darkBlue ,
            unfocusedContainerColor = darkBlue ,
            focusedIndicatorColor = darkBlue ,
            unfocusedIndicatorColor = darkBlue ,
            cursorColor = lightBlue
        ) ,
        singleLine = false ,

        textStyle = TextStyle(
            color = Color.White ,
            fontSize = 18.sp ,
        ) ,

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done) ,
        keyboardActions = KeyboardActions(onDone = {
            onMessageSend(message.value)
            message.value = ""
        }) ,

        )

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MessageList(
    modifier: Modifier ,
    messageList: List<MessageData> ,
) {

    LazyColumn(
        verticalArrangement = Arrangement.Bottom ,
        modifier = modifier ,
        reverseLayout = true
    ) {
        items(messageList.reversed()) { message ->
            if (message.user == "user") {
                Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.CenterEnd) {
                    UserMessages(messageContent = message)
                }
            } else if (message.user == "model") {
                Box(modifier = Modifier.fillMaxWidth() , contentAlignment = Alignment.CenterStart) {
                    FriendMessage(messageContent = message)
                }
            }
        }
    }
}


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



