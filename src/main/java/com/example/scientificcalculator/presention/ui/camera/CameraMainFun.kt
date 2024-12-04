package com.example.scientificcalculator.presention.ui.camera

import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.scientificcalculator.R

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun CameraMainFun(navController: NavController = rememberNavController()) {
val lifecycle = LocalLifecycleOwner.current
val context = LocalContext.current
val cameraFeatureProvider = remember {
    ProcessCameraProvider.getInstance(context)
}
   val previewView = remember { PreviewView(context).apply {
       id = R.id.camera
   }}


}