package com.example.scientificcalculator.presention.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.scientificcalculator.domain.Repository
import com.example.scientificcalculator.model.db.DataBase
import com.google.accompanist.permissions.ExperimentalPermissionsApi


@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("NewApi")
@Composable
fun MyApp(navController: NavHostController) {

    val context = LocalContext.current
    val db = DataBase.getDatabase(context)
    val repo = Repository(db)
    NestedNavgationGraph(navController = navController , repo)


}