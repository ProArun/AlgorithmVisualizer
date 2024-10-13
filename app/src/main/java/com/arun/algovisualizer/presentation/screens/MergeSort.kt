package com.arun.algovisualizer.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arun.algovisualizer.Option
import com.arun.algovisualizer.presentation.MergeSortViewModel
import com.arun.algovisualizer.ui.theme.gray
import com.arun.algovisualizer.ui.theme.orange

@Composable
fun MergeSort(modifier: Modifier = Modifier,onMenuClicked:(option: Option)->Unit) {
//     val sortViewModel by viewModels<SortViewModel>()
     val mergesortViewModel = MergeSortViewModel()
    var colorList =
        remember {
            mutableStateListOf<Color>(
                Color(0xffFAC301),
                Color(0xff81e9e7),
                Color(0xffecfa85),
                Color(0xfff5f787),
                Color(0xffF7F2F9),
                Color(0xffFca7f7),
                Color(0xfff2d9fd),
                Color(0xffc5ff7f),
            )
        }
    LaunchedEffect(key1 = Unit) {
        colorList.shuffle()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.sweepGradient(colors = colorList))
            .padding(10.dp)
            .clickable {
                onMenuClicked.invoke(Option.MENU)
            },
        contentAlignment = Alignment.Center
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.run { spacedBy(30.dp) },
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            itemsIndexed(
                mergesortViewModel.sortInfoUiItemList,
                key = { _, it ->
                    it.id
                }
            ){ index, it ->
                val depthParts = it.sortParts
                if(index == 0){
                    Text(
                        "Dividing",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 26.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
                if(index == 4){
                    Text(
                        "Merging",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 26.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    for(part in depthParts){
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier
                                .padding(start = if (depthParts.indexOf(part) == 0) 0.dp else 17.dp)
                                .background(it.color, RoundedCornerShape(10.dp))
                                .padding(5.dp)

                        ){
                            for(numberInformation in part){
                                if (part.indexOf(numberInformation) != part.size-1){
                                    Text(
                                        "$numberInformation |",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 19.sp
                                    )
                                }else{
                                    Text(
                                        "$numberInformation",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 19.sp
                                    )
                                }

                            }
                        }
                    }
                }

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(gray)
                .padding(15.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            Text(
                "${mergesortViewModel.listToSort}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Button(
                onClick = {
                    mergesortViewModel.startSorting()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = orange,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
            ){
                Text(
                    "Start sort",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

}