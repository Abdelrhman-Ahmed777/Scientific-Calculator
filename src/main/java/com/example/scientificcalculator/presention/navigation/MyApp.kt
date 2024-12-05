package com.example.scientificcalculator.presention.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState


@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("NewApi")
@Composable
fun MyApp(navController: NavHostController) {


    NestedNavgationGraph(navController = navController)


}