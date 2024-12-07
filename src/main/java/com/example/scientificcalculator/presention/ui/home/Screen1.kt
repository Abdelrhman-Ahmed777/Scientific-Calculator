package com.example.scientificcalculator.presention.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.Orange80
import com.example.scientificcalculator.ui.theme.Red80
import com.example.scientificcalculator.ui.theme.darkBlue
import com.example.scientificcalculator.ui.theme.lightBlue
import com.example.scientificcalculator.ui.theme.lightBlue2


@Composable
fun NumberScreen(
    text: MutableState<String> ,
    onResult: (String) -> Unit
) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (row0 , row1 , row2 , row3 , row4 , row5) = createRefs()

        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .constrainAs(row0) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = {
                    text.value +=  "("

                } ,
                modifier = Modifier
                    .height(56.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue)
            ) {
                Text(
                    text = "(" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(32.dp))

            Button(
                onClick = { text.value += ")" } ,
                modifier = Modifier
                    .height(56.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue)
            ) {
                Text(
                    text = ")" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(32.dp))


            Button(
                onClick = { text.value += "nCr" } ,
                modifier = Modifier
                    .height(56.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue)
            ) {
                Text(
                    text = "nCr" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(
                onClick = { text.value += "∪" } ,
                modifier = Modifier
                    .height(56.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue)
            ) {
                Text(
                    text = "∪" ,
                    fontSize = 32.sp ,
                )
            }


        }

        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .constrainAs(row1) {
                    top.linkTo(row0.bottom , margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = {
                    text.value = ""

                } ,
                modifier = Modifier
                    .height(70.dp)
                    .width(132.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(Red80)
            ) {
                Text(
                    text = "AC" ,
                    fontSize = 20.sp ,

                    )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "%" } ,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "%" ,
                    fontSize = 20.sp ,
                    modifier = Modifier.alpha(1f)
                )
            }
            Spacer(modifier = Modifier.width(24.dp))


            Button(
                onClick = { text.value = text.value.dropLast(1) } ,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.delete_ic) ,
                    contentDescription = "Delete" ,

                    )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { text.value += "/" } ,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "\u00F7" ,
                    fontSize = 32.sp ,
                )
            }


        }

        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .constrainAs(row2) {
                    top.linkTo(row1.bottom , margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = { text.value += "7" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "7" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "8" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "8" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))


            Button(
                onClick = { text.value += "9" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "9" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { text.value += "*" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "X" ,
                    fontSize = 20.sp ,
                )
            }
        }


        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .constrainAs(row3) {
                    top.linkTo(row2.bottom , margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = { text.value += "4" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "4" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "5" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "5" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "6" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "6" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { text.value += "+" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "+" ,
                    fontSize = 32.sp ,
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .constrainAs(row4) {
                    top.linkTo(row3.bottom , margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = { text.value += "1" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "1" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "2" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "2" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "3" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "3" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { text.value += "-" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "-" ,
                    fontSize = 32.sp ,
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .constrainAs(row5) {
                    top.linkTo(row4.bottom , margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = { text.value += "00" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .shadow(
                        elevation = 32.dp ,
                        shape = RectangleShape ,
                        ambientColor = Color.Black.copy(alpha = 5f) ,
                        spotColor = Color.Black.copy(alpha = 5f)
                    )
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2) ,
                elevation = ButtonDefaults.buttonElevation(32.dp)
            ) {
                Text(
                    text = "00" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "0" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2)
            ) {
                Text(
                    text = "0" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))


            Button(
                onClick = { text.value += "." } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(60.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "." ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = {
                    onResult(text.value)
                } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(124.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(Orange80)
            ) {
                Text(
                    text = "=" ,
                    fontSize = 40.sp ,
                )
            }
        }
    }
}

