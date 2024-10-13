package com.arun.algovisualizer.presentation


/**
 * Created by Arun Aditya on 11-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun.algovisualizer.domain.useCase.MergeSortUseCase
import com.arun.algovisualizer.presentation.state.SortInfoUiItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.UUID

class MergeSortViewModel(
    private val mergeSortUseCase: MergeSortUseCase = MergeSortUseCase()
) :ViewModel() {

    var listToSort = mutableListOf<Int>()

    var sortInfoUiItemList = mutableStateListOf<SortInfoUiItem>()

    init {
        for(i in 0 until 8){
            listToSort.add(
                (10..99).random()
            )
        }
    }

    fun startSorting(){
        sortInfoUiItemList.clear()
        subscribeToSortChanges()
        viewModelScope.launch {
            mergeSortUseCase(listToSort, 0)
        }
    }

    private var job: Job? = null
    private fun subscribeToSortChanges(){
        job?.cancel()
        job = viewModelScope.launch {
            mergeSortUseCase.sortFlow.collect { sortInfo ->
                val depthAlreadyExistListIndex = sortInfoUiItemList.indexOfFirst {
                    println("AKA depth ${it.depth}")
                    println("AKA sortInfo.depth ${sortInfo.depth}")
                    println("AKA sortState ${it.sortState}")
                    println("AKA sortInfo.sortState ${sortInfo.sortState}")
                    it.depth == sortInfo.depth && it.sortState == sortInfo.sortState
                }

                println("AKA depthAlreadyExistListIndex $depthAlreadyExistListIndex")

                if(depthAlreadyExistListIndex == -1){
                    println("AKA depthAlreadyExistListIndex if $depthAlreadyExistListIndex")
                    sortInfoUiItemList.add(
                        SortInfoUiItem(
                            id = UUID.randomUUID().toString(),
                            depth = sortInfo.depth,
                            sortState = sortInfo.sortState,
                            sortParts = listOf(sortInfo.sortParts),
                            color = Color(
                                (0..255).random(),
                                (0..200).random(),
                                (0..200).random(),
                                255)
                        )
                    )
                }else{
                    println("AKA depthAlreadyExistListIndex else $depthAlreadyExistListIndex")
                    val currentPartList = sortInfoUiItemList[depthAlreadyExistListIndex].sortParts.toMutableList()

                    currentPartList.add(sortInfo.sortParts)

                    sortInfoUiItemList.set(
                        depthAlreadyExistListIndex,
                        sortInfoUiItemList[depthAlreadyExistListIndex].copy(sortParts = currentPartList)
                    )
                }
                println("AKA depthAlreadyExistListIndex end $depthAlreadyExistListIndex")

                sortInfoUiItemList.sortedWith(
                    compareBy(
                        {
                            it.sortState
                        },
                        {
                            it.depth
                        }
                    )
                )
            }
        }
    }

}