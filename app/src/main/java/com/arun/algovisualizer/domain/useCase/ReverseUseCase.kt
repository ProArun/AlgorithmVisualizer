package com.arun.algovisualizer.domain.useCase

import com.arun.algovisualizer.domain.model.SortInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by Arun Aditya on 13-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */
class ReverseUseCase {
    operator fun invoke(list: MutableList<Int>): Flow<SortInfo> = flow {

        var n = list.size - 1
        var i = 0
        while (i < n) {
            emit(
                SortInfo(currentItem = i, shouldSwap = false, hadNoEffect = false)
            )
            delay(500)
            list.swap(i,n)
            emit(
                SortInfo(currentItem = i, shouldSwap = true, hadNoEffect = false)
            )
            i++
            n--
            emit(
                SortInfo(currentItem = i, shouldSwap = false, hadNoEffect = true)
            )
        }
    }
}