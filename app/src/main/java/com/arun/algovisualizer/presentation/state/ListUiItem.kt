package com.arun.algovisualizer.presentation.state

import androidx.compose.ui.graphics.Color

data class ListUiItem(
    val id:Int,
    val isCurrentlyCompared:Boolean,
    val value:Int,
    val color: Color
)