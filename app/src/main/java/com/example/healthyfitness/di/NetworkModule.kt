package com.example.healthyfitness.di

import com.example.healthyfitness.data.data_source.remote.RemoteConstants.Companion.BASE_URL
import com.example.healthyfitness.data.data_source.remote.retrofit.api.MealPlannerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideMealPlannerApi(retrofit: Retrofit): MealPlannerApi =
        retrofit.create(MealPlannerApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()

}