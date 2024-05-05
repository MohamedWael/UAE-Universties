package com.mowael.universities.di

import android.app.Application
import android.content.Context
import com.mowael.core.di.AppComponent
import com.mowael.core.di.AppModule
import com.mowael.universities.presentation.UniversitiesViewModel
import com.mowael.universities.presentation.UniversitiesViewModelFactory
import com.mowael.universities.view.UniversitiesFragment
import dagger.Component
import javax.inject.Singleton


@Component(modules = [UniversitiesModule::class, AppModule::class])
interface UniversitiesComponent {

    companion object{
        fun create(context: Application): UniversitiesComponent =
            DaggerUniversitiesComponent.builder().universitiesModule(UniversitiesModule())
                .appModule(AppModule(context)).build()
    }

    fun application(): Application
    fun universitiesViewModelFactory(): UniversitiesViewModelFactory

    fun inject(fragment: UniversitiesFragment)
}