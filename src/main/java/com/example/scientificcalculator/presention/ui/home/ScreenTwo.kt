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
import com.example.scientificcalculator.ui.theme.darkBlue
import com.example.scientificcalculator.ui.theme.lightBlue2

@Composable
fun SambolesScreen(
    text: MutableState<String> ,
) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (row1 , row2 , row3 , row4 , row5) = createRefs()


        Row(
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .constrainAs(row1) {
                    top.linkTo(parent.top , margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            Button(
                onClick = {
                    text.value += "π"

                } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "π" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "npr" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "nPr" ,
                    fontSize = 24.sp ,
                    modifier = Modifier.alpha(1f)
                )
            }
            Spacer(modifier = Modifier.width(24.dp))


            Button(
                onClick = { text.value = text.value.dropLast(1) } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
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
                onClick = {
                    text.value += "!"
                } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(darkBlue)
            ) {
                Text(
                    text = "x!" ,
                    fontSize = 24.sp ,
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
                onClick = { text.value += "sin" } ,
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
                    text = "Sin" ,
                    fontSize = 24.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "cos" } ,
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
                    text = "Cos" ,
                    fontSize = 24.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))


            Button(
                onClick = { text.value += "tan" } ,
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
                    text = "Tan" ,
                    fontSize = 24.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { text.value += "X" } ,
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
                    fontSize = 18.sp ,
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
                onClick = { text.value += "^2" } ,
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
                    text = "x²" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "^3" } ,
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
                    text = "x³" ,
                    fontSize = 32.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "e" } ,
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
                    text = "e" ,
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
                onClick = { text.value += "log" } ,
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
                    text = "Log" ,
                    fontSize = 24.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "exp" } ,
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
                    text = "EXP" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "inv" } ,
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
                    text = "INV" ,
                    fontSize = 24.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { text.value += "-" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(8.dp)) ,
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
                onClick = { text.value += "^-10" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(124.dp)
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
                    text = "1^-10",
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))

            Button(
                onClick = { text.value += "^10" } ,
                modifier = Modifier
                    .height(90.dp)
                    .width(124.dp)
                    .clip(RoundedCornerShape(20.dp)) ,
                contentPadding = ButtonDefaults.ContentPadding ,
                shape = RectangleShape ,
                colors = ButtonDefaults.buttonColors(lightBlue2)
            ) {
                Text(
                    text = "1^10" ,
                    fontSize = 20.sp ,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = {
                    text.value += "√"
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
                    text = "√" ,
                    fontSize = 40.sp ,
                )
            }
        }
    }
}

