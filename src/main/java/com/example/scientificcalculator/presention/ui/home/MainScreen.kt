package com.example.scientificcalculator.presention.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.scientificcalculator.ui.theme.Orange80
import com.example.scientificcalculator.ui.theme.darkBlue
import com.example.scientificcalculator.ui.theme.digital
import com.example.scientificcalculator.ui.theme.white
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

@OptIn(ExperimentalMaterial3Api::class , ExperimentalPermissionsApi::class)
@Preview
@Composable
fun MainCalculatorScreen(navController: NavHostController = rememberNavController()) {
    val pagerState = rememberPagerState(
        initialPage = 0 ,
        pageCount = { 2 } ,
        initialPageOffsetFraction = 0f
    )
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val problem = remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val cameraPermissionState =
        rememberPermissionState(android.Manifest.permission.CAMERA)

    ModalNavigationDrawer(
        drawerState = drawerState ,
        drawerContent = {
            MenuContent(
                drawerState ,
                navController ,
                cameraPermissionState.status.isGranted ,
                onResultRequestPermission = {
                    scope.launch(Dispatchers.IO) {
                        cameraPermissionState.launchPermissionRequest()
                    }
                })
        }
    ) {
        Scaffold(
        ) { padding ->
            Box(
                Modifier
                    .fillMaxSize()
                    .background(white)
            ) {
                ConstraintLayout(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    val (iconm , resultRef , keyboard) = createRefs()

                    Icon(
                        Icons.Default.Menu ,
                        contentDescription = "Menu" ,
                        modifier = Modifier
                            .constrainAs(iconm) {
                                start.linkTo(parent.start , margin = 24.dp)
                                top.linkTo(parent.top , margin = 24.dp)
                            }
                            .padding(16.dp)
                            .clickable {
                                scope.launch(Dispatchers.IO) {
                                    drawerState.open()
                                }
                            } ,
                        tint = Color.Black
                    )


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .constrainAs(resultRef) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Text(
                            problem.value ,
                            fontSize = 42.sp ,
                            fontFamily = digital ,
                            color = darkBlue ,
                            modifier = Modifier
                                .wrapContentSize()
                                .weight(1f)
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState())
                                .align(Alignment.Start)
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = result ,
                            fontFamily = digital ,
                            fontSize = 64.sp ,
                            color = Orange80 ,
                            modifier = Modifier
                                .padding(16.dp)
                                .horizontalScroll(rememberScrollState())
                                .align(Alignment.End)
                                .wrapContentSize()
                        )
                    }

                    HorizontalPager(
                        state = pagerState ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.6f)
                            .padding(top = 64.dp)
                            .constrainAs(keyboard) {
                                bottom.linkTo(parent.bottom , margin = 32.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) { page ->
                        when (page) {
                            0 -> NumberScreen(
                                text = problem ,
                                onResult = {
                                    scope.launch(Dispatchers.IO) {
                                        try {
                                            result = calculateExpression(problem.value).toString()
                                        } catch (e: Exception) {
                                            Log.i("ok" , "the error is $e")
                                        }

                                    }

                                }
                            )

                            1 -> SinesScreen()
                        }
                    }
                }
            }

        }
    }
}


fun calculateExpression(expression: String): Double {
    val exp = ExpressionBuilder(expression).build()
    return exp.evaluate()
}

