package com.example.scientificcalculator.presention.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.scientificcalculator.R.drawable.camera_ic
import com.example.scientificcalculator.R.drawable.history_ic
import com.example.scientificcalculator.R.drawable.robot_2_ic
import com.example.scientificcalculator.presention.navigation.Screens
import com.example.scientificcalculator.ui.theme.darkBlue
import com.example.scientificcalculator.ui.theme.darkBlue2
import com.example.scientificcalculator.ui.theme.darkGreen
import com.example.scientificcalculator.ui.theme.lightBlue
import com.example.scientificcalculator.ui.theme.lightGray
import com.example.scientificcalculator.ui.theme.midPurple
import com.example.scientificcalculator.ui.theme.white
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MenuContent(
    drawerState: DrawerState , navController: NavHostController , haspermission: Boolean ,
    onResultRequestPermission: () -> Unit
) {

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(darkBlue2)
    ) {
        Box(
            Modifier
                .fillMaxHeight()
                .width(300.dp)
                .clip(RoundedCornerShape(topStart = 20.dp , topEnd = 20.dp))
        ) { }
        Column(
            horizontalAlignment = Alignment.Start ,
            verticalArrangement = Arrangement.Top ,
            modifier = Modifier
                .padding(top = 300.dp)
                .fillMaxHeight()
                .width(300.dp)
                .background(darkBlue)
        ) {

            Spacer(Modifier.height(16.dp))

            MenuItemButton(
                "Home" ,
                Icons.Default.Home ,
                lightGray
            ) {
                scope.launch {
                    drawerState.close()

                }
            }
            Spacer(Modifier.height(16.dp))
            MenuItemButton(
                "AI Assistant" ,
                ImageVector.vectorResource(robot_2_ic) ,
                Color.Red
            ) {
                scope.launch {
                    drawerState.close()
                    navController.navigate(Screens.AiAssistantScreen.route)

                }
            }
            Spacer(Modifier.height(16.dp))

            MenuItemButton(
                "Camera" ,
                ImageVector.vectorResource(camera_ic) ,
                midPurple
            ) {
                scope.launch {
                    if (!haspermission) {
                        onResultRequestPermission()
                    }
                    drawerState.close()
                    navController.navigate(Screens.CameraScreen.route)
                }
            }
            Spacer(Modifier.height(16.dp))

            MenuItemButton(
                "History" ,
                ImageVector.vectorResource(history_ic) ,
                darkGreen
            ) {
                scope.launch {
                    drawerState.close()
                    navController.navigate(Screens.HistoryScreen.route)

                }
            }

        }
    }

}


@Composable
fun MenuItemButton(
    text: String ,
    icon: ImageVector ,
    tint: Color ,
    onClick: () -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.Start ,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Spacer(Modifier.width(16.dp))
        Icon(
            imageVector = icon ,
            contentDescription = text ,
            tint = tint ,
            modifier = Modifier.size(34.dp)
        )
        Spacer(Modifier.width(32.dp))
        Text(text , color = lightBlue , fontSize = 24.sp , fontWeight = FontWeight.Bold)
    }
}