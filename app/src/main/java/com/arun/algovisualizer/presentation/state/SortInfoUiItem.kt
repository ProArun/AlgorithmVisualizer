package com.arun.algovisualizer.presentation.state


/**
 * Created by Arun Aditya on 11-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */
import androidx.compose.ui.graphics.Color
import com.arun.algovisualizer.domain.model.mergesort.SortState

data class SortInfoUiItem(
    val id:String,
    val depth:Int,
    val sortState: SortState,
    val sortParts:List<List<Int>>,
    val color: Color
)