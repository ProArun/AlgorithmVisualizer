package com.arun.algovisualizer.domain.useCase

import com.arun.algovisualizer.domain.model.SortInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by Arun Aditya on 13-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */

class SelectionSortUseCase {
    operator fun invoke(list: MutableList<Int>): Flow<SortInfo> = flow {
        var n = list.size
        for(i in 0 until n-1){
            var minIndex = i
            for (j in i+1 until n){
                emit(
                    SortInfo(currentItem = minIndex, nextItem = j, shouldSwap = false, hadNoEffect = false)
                )
                delay(500)
                if(list[j] < list[minIndex]){
                    list.swap(minIndex,j)
                    emit(
                        SortInfo(currentItem = minIndex, nextItem = j, shouldSwap = true, hadNoEffect = false)
                    )
                }else{
                    emit(
                        SortInfo(currentItem = minIndex, nextItem = j, shouldSwap = false, hadNoEffect = true)
                    )
                }
                delay(500)
            }

        }

    }
}