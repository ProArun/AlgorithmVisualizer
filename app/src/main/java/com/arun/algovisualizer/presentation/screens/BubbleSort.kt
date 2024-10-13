package com.arun.algovisualizer.presentation.screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.algovisualizer.Option
import com.arun.algovisualizer.presentation.BubbleSortViewModel
import com.arun.algovisualizer.ui.theme.gray
import com.arun.algovisualizer.ui.theme.orange


/**
 * Created by Arun Aditya on 11-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BubbleSort(modifier: Modifier = Modifier, onMenuClicked: (option: Option) -> Unit) {
    val bubbleSortViewModel = BubbleSortViewModel()
    var colorList =
        remember {
            mutableStateListOf<Color>(
                Color(0xffecfa85),
                Color(0xffc5ff7f),
                Color(0xfff5f787),
                Color(0xffF7F2F9),
                Color(0xffFAC301),
                Color(0xffFca7f7),
                Color(0xff81e9e7),
                Color(0xfff2d9fd),
            )
        }
    LaunchedEffect(key1 = Unit) {
        colorList.shuffle()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.sweepGradient(colors = colorList))
            .padding(20.dp)
            .clickable {
                onMenuClicked.invoke(Option.MENU)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            onClick = {
                bubbleSortViewModel.startSorting()
            }, colors = ButtonDefaults.buttonColors(containerColor = orange)
        ) {
            Text(
                "Sort List",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(
                bubbleSortViewModel.listToSort,
                key = {
                    it.id
                }
            ) {
                val borderStroke = if (it.isCurrentlyCompared) {
                    BorderStroke(width = 3.dp, Color.White)
                } else {
                    BorderStroke(width = 0.dp, Color.Transparent)
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(it.color, RoundedCornerShape(15.dp))
                        .border(borderStroke, RoundedCornerShape(15.dp))
                        .animateItemPlacement(
                            tween(300)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "${it.value}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}
