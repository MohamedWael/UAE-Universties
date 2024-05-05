package com.mowael.universities.di

import com.mowael.core.LocalStorage
import com.mowael.core.di.AppComponent
import com.mowael.core.di.AppModule
import com.mowael.universities.BuildConfig
import com.mowael.universities.data.api.UniversitiesEndpoint
import com.mowael.universities.data.repo.UniversitiesRepo
import com.mowael.universities.data.repo.UniversitiesRepoImpl
import com.mowael.universities.domain.UniversitiesUseCase
import com.mowael.universities.domain.UniversitiesUseCaseImpl
import com.mowael.universities.presentation.UniversitiesViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val APP_BASE_URL = "http://universities.hipolabs.com/"

@Module
class UniversitiesModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(APP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideUniversitiesEndpoint(retrofit: Retrofit): UniversitiesEndpoint =
        retrofit.create(UniversitiesEndpoint::class.java)

    @Provides
    fun provideUniversitiesViewModelFactory(universitiesUseCase: UniversitiesUseCase): UniversitiesViewModelFactory =
        UniversitiesViewModelFactory(universitiesUseCase)

    @Provides
    fun provideUniversitiesRepo(
        universitiesEndpoint: UniversitiesEndpoint,
        localStorage: LocalStorage
    ): UniversitiesRepo = UniversitiesRepoImpl(universitiesEndpoint, localStorage)

    @Provides
    fun provideUniversitiesUseCase(universitiesRepo: UniversitiesRepo): UniversitiesUseCase =
        UniversitiesUseCaseImpl(universitiesRepo)
}