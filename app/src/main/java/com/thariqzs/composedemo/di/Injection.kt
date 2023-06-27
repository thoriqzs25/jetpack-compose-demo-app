package com.thariqzs.composedemo.di

import com.thariqzs.composedemo.data.ShoeRepository

object Injection {
    fun provideRepository(): ShoeRepository {
        return ShoeRepository.getInstance()
    }
}