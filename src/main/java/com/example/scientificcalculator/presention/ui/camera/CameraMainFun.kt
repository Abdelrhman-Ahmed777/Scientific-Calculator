package com.example.scientificcalculator.presention.ui.camera

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.scientificcalculator.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview(showBackground = true , apiLevel = 33)
@Composable
fun CameraMainFun(navController: NavController = rememberNavController()) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }
    LaunchedEffect(key1 = cameraController) {
        cameraController.bindToLifecycle(lifecycleOwner)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        val (cameraPreview , button , text , back) = createRefs()

        Icon(
            Icons.Default.ArrowBack ,
            contentDescription = "Back" ,
            tint = Color.White ,
            modifier = Modifier
                .clickable {
                    scope.launch(Dispatchers.IO) {
                        navController.popBackStack()
                    }
                }
                .constrainAs(back) {
                    top.linkTo(parent.top , margin = 32.dp)
                    start.linkTo(parent.start , margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(cameraPreview) {
                    top.linkTo(parent.top , margin = 64.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }
                .fillMaxWidth()
                .height(700.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            AndroidView(
                modifier = Modifier
                    .fillMaxSize() ,
                factory = { context ->
                    PreviewView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(
                            MATCH_PARENT , MATCH_PARENT
                        )
                        scaleType = PreviewView.ScaleType.FIT_START
                    }.also { PreviewView ->
                        PreviewView.controller = cameraController
                    }
                }
            )
        }

    }
}