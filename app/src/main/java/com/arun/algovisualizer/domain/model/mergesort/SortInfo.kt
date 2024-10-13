package com.arun.algovisualizer.domain.model.mergesort


/**
 * Created by Arun Aditya on 11-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */
data class SortInfo(
    val id:String,
    val depth:Int,
    val sortParts:List<Int>,
    val sortState:SortState
)

enum class SortState(val value:Int){
    DIVIDED(0),
    MERGED(1)
}