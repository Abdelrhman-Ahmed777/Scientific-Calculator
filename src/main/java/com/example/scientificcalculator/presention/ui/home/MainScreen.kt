package com.example.scientificcalculator.presention.ui.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.scientificcalculator.ui.theme.lightBlue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

@OptIn(ExperimentalMaterial3Api::class)
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
    var problem = remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    ModalNavigationDrawer(
        drawerState = drawerState ,
        drawerContent = {
            MenuContent(drawerState , navController)
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Main Screen" , fontSize = 32.sp , color = Color.White) } ,
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
            }
        ) { padding ->
            ConstraintLayout(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                val (resultRef , keyboard) = createRefs()

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
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
                            .wrapContentSize()
                            .padding(16.dp)
                            .horizontalScroll(rememberScrollState())
                            .align(Alignment.End)
                    )
                }

                HorizontalPager(
                    state = pagerState ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .padding(top = 64.dp)
                        .constrainAs(keyboard) {
                            bottom.linkTo(parent.bottom, margin = 32.dp)
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


fun calculateExpression(expression: String): Double {
    val exp = ExpressionBuilder(expression).build()
    return exp.evaluate()
}

