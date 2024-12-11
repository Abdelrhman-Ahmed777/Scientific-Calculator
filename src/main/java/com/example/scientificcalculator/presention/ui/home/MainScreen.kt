package com.example.scientificcalculator.presention.ui.home

import android.Manifest
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
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.scientificcalculator.domain.Item
import com.example.scientificcalculator.domain.Repository
import com.example.scientificcalculator.presention.viewModel.DataBaseViewModel
import com.example.scientificcalculator.ui.theme.Orange80
import com.example.scientificcalculator.ui.theme.black
import com.example.scientificcalculator.ui.theme.darkPurple
import com.example.scientificcalculator.ui.theme.digital
import com.example.scientificcalculator.ui.theme.lightBlue
import com.example.scientificcalculator.ui.theme.lightPurple
import com.example.scientificcalculator.ui.theme.midPurple
import com.example.scientificcalculator.ui.theme.white
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sqrt

@OptIn(ExperimentalMaterial3Api::class , ExperimentalPermissionsApi::class)
@Composable
fun MainCalculatorScreen(
    navController: NavHostController ,
    repository: Repository ,
) {


    val backgroud = Brush.verticalGradient(
        listOf(
            black ,
            black ,
            darkPurple ,
            darkPurple ,
            midPurple ,
            lightPurple ,
            lightPurple
        )
    )


    val viewModel = DataBaseViewModel(repository)


    val pagerState = rememberPagerState(
        initialPage = 0 ,
        pageCount = { 2 } ,
        initialPageOffsetFraction = 0f
    )
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val problem = remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var index = remember { mutableIntStateOf(pagerState.currentPage) }
    val cameraPermissionState =
        rememberPermissionState(Manifest.permission.CAMERA)

    LaunchedEffect(pagerState.currentPage , pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            pagerState.currentPage.also { index.intValue = it }
        }
    }



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
                    .background(backgroud)
            ) {
                ConstraintLayout(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    val (title , icon , indexRef , resultRef , keyboard) = createRefs()


                    Text(
                        "Scientific Calculator" ,
                        color = Color.White ,
                        fontFamily = digital ,
                        fontSize = 30.sp ,
                        modifier = Modifier
                            .constrainAs(title) {
                                top.linkTo(parent.top , margin = 32.dp)
                                start.linkTo(icon.end , margin = 24.dp)
                            })


                    Icon(
                        Icons.Default.Menu ,
                        contentDescription = "Menu" ,
                        modifier = Modifier
                            .constrainAs(icon) {
                                start.linkTo(parent.start , margin = 24.dp)
                                top.linkTo(parent.top , margin = 24.dp)
                            }
                            .padding(16.dp)
                            .clickable {
                                scope.launch(Dispatchers.IO) {
                                    drawerState.open()
                                }
                            } ,
                        tint = Color.White
                    )


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .constrainAs(resultRef) {
                                top.linkTo(title.bottom , margin = 8.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Text(
                            problem.value ,
                            fontSize = 42.sp ,
                            color = white ,
                            modifier = Modifier
                                .wrapContentSize()
                                .weight(1f)
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState())
                                .align(Alignment.Start)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = result ,
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
                        flingBehavior = PagerDefaults.flingBehavior(
                            state = pagerState ,
                            pagerSnapDistance = PagerSnapDistance.atMost(2)
                        ) ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f)
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
                                onClear = {
                                    problem.value = ""
                                    result = ""
                                } ,
                                onResult = {
                                    scope.launch {
                                        try {
                                            val e = 2.718281828459045
                                            val refinedExpression = refineExpression(problem.value)
                                            result = calculateExpression(refinedExpression
                                                .replace("e", e.toString())
                                            ).toString()
                                            val item = Item(
                                                problem = problem.value ,
                                                answer = result
                                            )
                                            viewModel.insertItem(item)

                                        } catch (e: Exception) {
                                            Log.i("ok" , "the error is $e")
                                        }

                                    }

                                }
                            )

                            1 -> SambolesScreen(
                                problem
                            )
                        }
                    }
                    DotIndicator(
                        totalDots = 2 ,
                        selectedIndex = index.intValue ,
                        selectedColor = lightBlue ,
                        unselectedColor = Color.Gray ,
                        dotSize = 8.dp ,
                        dotSpacing = 40.dp ,
                        modifier = Modifier
                            .constrainAs(indexRef) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom , margin = 32.dp)
                            })
                }
            }

        }
    }
}


fun calculateExpression(expression: String): Double {
    val exp = ExpressionBuilder(expression).build()
    return exp.evaluate()
}

fun factorial(n: Int): Int = if (n == 0 || n == 1) 1 else n * factorial(n - 1)

fun refineExpression(expression: String): String {
    val factorialRegex = Regex("""(\d+)!""")
    return factorialRegex.replace(expression) { matchResult ->
        val number = matchResult.groupValues[1].toInt()
        factorial(number).toString()
    }}