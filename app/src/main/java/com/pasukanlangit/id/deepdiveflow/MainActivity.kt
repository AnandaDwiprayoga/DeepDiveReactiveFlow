package com.pasukanlangit.id.deepdiveflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pasukanlangit.id.deepdiveflow.ui.theme.DeepDiveFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepDiveFlowTheme {
                val viewModel = viewModel<MainViewModel>()
                val countDown = viewModel.countDown.collectAsState(initial = 10)
                Box(modifier = Modifier.fillMaxSize()){
                    Text(
                        text = countDown.value.toString(),
                        fontSize = 24.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}
