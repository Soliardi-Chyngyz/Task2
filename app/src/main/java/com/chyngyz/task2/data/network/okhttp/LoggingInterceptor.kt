package com.chyngyz.task2.data.network.okhttp

import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptor {
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}