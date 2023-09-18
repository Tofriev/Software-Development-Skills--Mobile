package com.example.part1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.part1.ui.theme.Part1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Part1Theme {

                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                Calculator()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }

    val sum = remember { derivedStateOf {
        val intNum1 = num1.toIntOrNull() ?: 0
        val intNum2 = num2.toIntOrNull() ?: 0
        intNum1 + intNum2
    } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "The Summing App",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
                )
            )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = num1,
            onValueChange = { value ->
                num1 = value
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next),
            label = { Text("Number 1") },
            modifier = Modifier.padding(20.dp),
            maxLines = 1
        )

        TextField(
            value = num2,
            onValueChange = { value ->
                num2 = value
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            label = { Text("Number 2") },
            modifier = Modifier.padding(20.dp),
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
                text = "Sum: ${sum.value}"
            )

    }
}




@Preview(showBackground = true)
@Composable
fun TextPreview() {
    Part1Theme {
        Calculator()
    }
}
