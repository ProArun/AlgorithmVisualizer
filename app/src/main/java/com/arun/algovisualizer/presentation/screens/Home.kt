package com.arun.algovisualizer.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.algovisualizer.Option
import com.arun.algovisualizer.domain.useCase.swap
import kotlinx.coroutines.delay


/**
 * Created by Arun Aditya on 11-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */
@Composable
fun Home(modifier: Modifier = Modifier, onMenuClicked: (option: Option) -> Unit) {
//    var colorIndex by remember {
//        mutableStateOf(0)
//    }
    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xffFA98ff),
            Color(0xffF6CFAA)
        )
    )

    var colorList =
        remember {
            mutableStateListOf<Color>(
                Color(0xffFAC301),
                Color(0xffFca7f7),
                Color(0xff81e9e7),
                Color(0xfff2d9fd),
                Color(0xffecfa85),
                Color(0xffc5ff7f),
                Color(0xfff5f787),
//                Color.White
//                Color.Red,
//                Color.Gray,
//                Color.Blue,
//                Color.DarkGray,
//                Color.Green,
//                Color.LightGray,
//                Color.Yellow,
//                Color.Cyan,
//                Color.Magenta,
//                Color.White
            )
        }

//    LaunchedEffect(key1 = Unit) {
//        while (true) {
//            delay(3000)
//            colorList.shiftList()
//            colorList.forEachIndexed { index, color ->
//                println("color list : $index -> $color")
//            }
//
////            colorIndex = (colorIndex + 1) % colorList.size
//        }
//    }


//    LaunchedEffect(key1 = Unit) {
//        val colors = listOf(
//            Color.White
//        )
//        colorList.addAll(colors)
//    }
//    LaunchedEffect(key1 = colorList.value) {
//        delay(1000)
//        colorList.shuffle()
//    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    colors = colorList
//                    colors = listOf(colorList[colorIndex],Color.Transparent)
                )
            )
    ) {
        Column {
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F2F9),
                ),
                onClick = {
                    onMenuClicked.invoke(Option.BUBBLE_SORT)
                }) {
                Box(
                    modifier = Modifier.background(
                        brush = horizontalGradientBrush
                    )
                ) {
                    Text(
                        text = "Bubble sort",
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 30.dp, bottom = 30.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }

            }
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F2F9),
                ),
                onClick = {
                    onMenuClicked.invoke(Option.MERGE_SORT)
                }) {
                Box(
                    modifier = Modifier.background(
                        brush = horizontalGradientBrush
                    )
                ) {
                    Text(
                        text = "Merge sort",
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 30.dp, bottom = 30.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F2F9),
                ),
                onClick = {
                    onMenuClicked.invoke(Option.INSERTION_SORT)
                }) {
                Box(
                    modifier = Modifier.background(
                        brush = horizontalGradientBrush
                    )
                ) {
                    Text(
                        text = "Insertion sort",
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 30.dp, bottom = 30.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F2F9),
                ),
                onClick = {
                    onMenuClicked.invoke(Option.REVERSE)
                }) {
                Box(
                    modifier = Modifier.background(
                        brush = horizontalGradientBrush
                    )
                ) {
                    Text(
                        text = "Reverse",
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 30.dp, bottom = 30.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F2F9),
                ),
                onClick = {
                    onMenuClicked.invoke(Option.SELECTION_SORT)
                }) {
                Box(
                    modifier = Modifier.background(
                        brush = horizontalGradientBrush
                    )
                ) {
                    Text(
                        text = "Selection Sort",
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 30.dp, bottom = 30.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}

fun MutableList<Color>.shiftList() {
    if (this.isNotEmpty()) {
        val lastElement = this.removeAt(this.size - 1)
        this.add(0, lastElement)
    }
}