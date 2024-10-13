package com.arun.algovisualizer.domain.useCase

import com.arun.algovisualizer.domain.model.SortInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by Arun Aditya on 12-10-2024.
 * LinkedIn: https://www.linkedin.com/in/arun-aditya-82a94914a/
 */
class InsertionSortUseCase {
    operator fun invoke(list: MutableList<Int>): Flow<SortInfo> = flow {

        val n = list.size

        for (i in 1 until n) {
            val current = list[i]
            var j = i - 1
            emit(
                SortInfo(currentItem = j, shouldSwap = false, hadNoEffect = false)
            )
            delay(500)

            while (j >= 0 && list[j] > current) {
                emit(
                    SortInfo(currentItem = j, shouldSwap = true, hadNoEffect = false)
                )
                delay(500)
                list[j + 1] = list[j]
                j -= 1
            }
            list[j + 1] = current
            if (j >=0){
                emit(
                    SortInfo(currentItem = j, shouldSwap = false, hadNoEffect = true)
                )
                delay(500)
            }
        }
    }
}