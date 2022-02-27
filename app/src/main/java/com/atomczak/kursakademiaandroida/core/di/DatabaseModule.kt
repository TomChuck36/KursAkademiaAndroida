package com.atomczak.kursakademiaandroida.core.di

import androidx.room.Room
import com.atomczak.kursakademiaandroida.core.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java, "app_database"
        ).build()
    }

    single {
        get<AppDatabase>().episodeDao()
    }
}