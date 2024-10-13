package com.arun.algovisualizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import com.arun.algovisualizer.presentation.screens.BubbleSort
import com.arun.algovisualizer.presentation.screens.Home
import com.arun.algovisualizer.presentation.screens.InsertionSort
import com.arun.algovisualizer.presentation.screens.MergeSort
import com.arun.algovisualizer.presentation.screens.Reverse
import com.arun.algovisualizer.presentation.screens.SelectionSort
import com.arun.algovisualizer.ui.theme.AlgoVisualizerTheme
import com.arun.algovisualizer.ui.theme.orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoVisualizerTheme {
                window.statusBarColor = orange.toArgb()
                window.navigationBarColor = orange.toArgb()
                val option = remember {
                    mutableStateOf(Option.MENU)
                }

                Box(modifier = Modifier.fillMaxSize()) {
                    when (option.value) {
                        Option.MENU -> Home{
                            option.value = it
                        }
                        Option.BUBBLE_SORT -> BubbleSort{
                            option.value = it
                        }
                        Option.MERGE_SORT -> MergeSort{
                            option.value = it
                        }

                        Option.INSERTION_SORT -> InsertionSort{
                            option.value = it
                        }
                        Option.SELECTION_SORT -> SelectionSort {
                            option.value = it
                        }

                        Option.REVERSE -> Reverse {
                            option.value = it
                        }
                    }
                }
            }
        }
    }
}

enum class Option {
    MENU,
    BUBBLE_SORT,
    INSERTION_SORT,
    SELECTION_SORT,
    REVERSE,
    MERGE_SORT,

}