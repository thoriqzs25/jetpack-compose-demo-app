package com.thariqzs.composedemo.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ShoeRepository {
    private val shoeList = mutableListOf<ShoeSale>()

    init {
        if (shoeList.isEmpty()) {
            DummyData.shoeSales.forEach {
                shoeList.add(it)
            }
        }
    }

    fun getAllRewards(): Flow<List<ShoeSale>> {
        return flowOf(shoeList)
    }

    fun getShoeDetailById(shoeId: Int): ShoeSale {
        return shoeList.first {
            it.id == shoeId
        }
    }

//    fun updateOrderReward(rewardId: Long, newCountValue: Int): Flow<Boolean> {
//        val index = shoeList.indexOfFirst { it.reward.id == rewardId }
//        val result = if (index >= 0) {
//            val orderReward = shoeList[index]
//            shoeList[index] =
//                orderReward.copy(reward = orderReward.reward, count = newCountValue)
//            true
//        } else {
//            false
//        }
//        return flowOf(result)
//    }

//    fun getAddedShoeList(): Flow<List<ShoeSale>> {
//        return getAllRewards()
//            .map { shoeList ->
//                shoeList.filter { shoeList ->
//                    shoeList.count != 0
//                }
//            }
//    }

    companion object {
        @Volatile
        private var instance: ShoeRepository? = null

        fun getInstance(): ShoeRepository =
            instance ?: synchronized(this) {
                ShoeRepository().apply {
                    instance = this
                }
            }
    }
}