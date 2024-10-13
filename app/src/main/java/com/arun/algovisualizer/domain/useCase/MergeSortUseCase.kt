package com.arun.algovisualizer.domain.useCase

import com.arun.algovisualizer.domain.model.mergesort.SortInfo
import com.arun.algovisualizer.domain.model.mergesort.SortState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.UUID

class MergeSortUseCase {

    val sortFlow = MutableSharedFlow<SortInfo>()

    suspend operator fun invoke(list: List<Int>, depth:Int):List<Int> {
        delay(100)
        sortFlow.emit(SortInfo(
            id = UUID.randomUUID().toString(),
            depth = depth,
            sortParts = list,
            sortState = SortState.DIVIDED,
        ))
        val listSize = list.size
        if (listSize <= 1) {
            return list
        }
        //14 -> 0 .. 6 and 7 .. 13
        //13 -> 0 .. 6 and 7 .. 12
        var leftList = list.slice(0 until (listSize + 1) / 2)
        var rightList = list.slice((listSize + 1) / 2 until listSize)
        leftList = this(leftList, depth + 1)
        rightList = this(rightList,depth + 1)
        return merge(leftList.toMutableList(), rightList.toMutableList(), depth)
    }

    private suspend fun merge(leftList:MutableList<Int>, rightList:MutableList<Int>, depth:Int):List<Int>{

        val mergeList = mutableListOf<Int>()
        while (leftList.isNotEmpty() && rightList.isNotEmpty()){
            if(leftList.first() <= rightList.first()){
                mergeList.add(mergeList.size,leftList.removeFirst())
            }else{
                mergeList.add(mergeList.size,rightList.removeFirst())
            }
        }
        mergeList.addAll(leftList)
        mergeList.addAll(rightList)
        delay(500)
        sortFlow.emit(SortInfo(
            UUID.randomUUID().toString(),
            depth = depth,
            sortParts = mergeList,
            sortState = SortState.MERGED,
        ))
        return mergeList
    }
}