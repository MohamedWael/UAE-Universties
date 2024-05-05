package com.mowael.core.di

import android.app.Application
import android.content.Context
import com.mowael.core.AppDatabase
import com.mowael.core.LocalStorage
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
//    @Component.Builder
//    interface Builder {
//        fun build(): AppComponent
//
//        @BindsInstance
//        fun application(application: Application): Builder
//    }

    fun application(): Application
}

