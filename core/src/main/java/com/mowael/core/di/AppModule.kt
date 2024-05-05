package com.mowael.core.di

import android.app.Application
import android.content.Context
import com.mowael.core.AppDatabase
import com.mowael.core.LocalStorage
import com.mowael.core.LocalStorageImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application

    @Provides
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext


    @Provides
    fun provideAppDatabase(context: Application): AppDatabase =
        AppDatabase.createDatabase(context)


    @Provides
    fun provideLocalStorage(appDatabase: AppDatabase): LocalStorage = LocalStorageImpl(appDatabase)

}
