package com.arun.algovisualizer.domain.model

data class SortInfo(
    val currentItem:Int,
    var nextItem:Int = -1,
    val shouldSwap:Boolean,
    val hadNoEffect:Boolean
)
