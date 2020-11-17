package com.alrayes.moviesworld.di

import com.alrayes.moviesworld.data.remote.HomeEndpoints
import com.alrayes.moviesworld.data.repository.HomeRepositoryImpl
import com.alrayes.moviesworld.domain.repositories.HomeRepository
import org.koin.dsl.module


val repositoryModule = module {

   single { provideHomeRepository(get()) }
}

fun provideHomeRepository(remote: HomeEndpoints) : HomeRepository {
    return HomeRepositoryImpl(remote)
}


