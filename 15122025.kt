package com.example.a15122025

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a15122025.ui.theme._15122025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _15122025Theme {
                Scaffold{innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        ModalBottomSheetExample()
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  ModalBottomSheetExample(){
    val sheetState = rememberModalBottomSheetState()
    var openSheet by remember {mutableStateOf(false) }

    if (openSheet){
        ModalBottomSheet(
            onDismissRequest = { openSheet = false },
            sheetState = sheetState
        ){
            Text(text = "Bu Bir Modal Bottom Sheetdir", modifier = Modifier.padding(16.dp))
        }

    }

    Button(onClick = { openSheet = true }) {
        Text(text = "Sheet Aç")
    }
}
