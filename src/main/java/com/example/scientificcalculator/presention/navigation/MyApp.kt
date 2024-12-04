package com.example.scientificcalculator.presention.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
/*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
*/


@SuppressLint("NewApi")
@Composable
fun MyApp(navController: NavHostController) {

    //val permission: androidx.activity.result.contract.PermissionState =


        NestedNavgationGraph(navController = navController)


}