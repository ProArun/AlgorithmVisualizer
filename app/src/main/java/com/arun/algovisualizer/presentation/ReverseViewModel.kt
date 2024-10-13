package com.arun.algovisualizer.presentation


import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.algovisualizer.domain.useCase.BubbleSortUseCase
import com.arun.algovisualizer.domain.useCase.ReverseUseCase
import com.arun.algovisualizer.presentation.state.ListUiItem
import kotlinx.coroutines.launch
import java.util.Random

/**
 * Created by Arun Aditya on 13-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */

class ReverseViewModel(
    private val reverseUseCase: ReverseUseCase = ReverseUseCase()
) :ViewModel() {

    var listToSort = mutableStateListOf<ListUiItem>()

    init {
        for(i in 0 until 9){
            val rnd = Random()
            listToSort.add(ListUiItem(
                id = i,
                isCurrentlyCompared = false,
                value = rnd.nextInt(150),
                color = Color(
                    255,
                    rnd.nextInt(256),
                    rnd.nextInt(256),
                    255)
            )
            )
        }
    }

    fun startSorting(){
        viewModelScope.launch {
            reverseUseCase(listToSort.map { listUiItem ->
                listUiItem.value
            }.toMutableList()).collect{ swapInfo ->

                val currentItemIndex = swapInfo.currentItem
                listToSort[currentItemIndex] = listToSort[currentItemIndex].copy(isCurrentlyCompared = true)
                listToSort[listToSort.size-currentItemIndex-1] = listToSort[listToSort.size-currentItemIndex-1].copy(isCurrentlyCompared = true)

                if(swapInfo.shouldSwap){
                    val firstItem = listToSort[currentItemIndex].copy(isCurrentlyCompared = false)
                    listToSort[currentItemIndex] = listToSort[listToSort.size-currentItemIndex-1].copy(isCurrentlyCompared = false)
                    listToSort[listToSort.size-currentItemIndex-1] = firstItem
                }
                if(swapInfo.hadNoEffect){
                    listToSort[currentItemIndex] = listToSort[currentItemIndex].copy(isCurrentlyCompared = false)
                    listToSort[listToSort.size-currentItemIndex-1] = listToSort[listToSort.size-currentItemIndex-1].copy(isCurrentlyCompared = false)
                }
            }
        }
    }
}