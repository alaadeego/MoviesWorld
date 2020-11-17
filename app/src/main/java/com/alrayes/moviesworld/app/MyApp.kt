package com.alrayes.moviesworld.app

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.alrayes.moviesworld.BuildConfig
import com.alrayes.moviesworld.di.applicationModule
import com.alrayes.moviesworld.di.networkModule
import com.alrayes.moviesworld.di.repositoryModule
import com.profito.wharehouse.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
      //  LocaleManager.setLocale(this)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)
            modules(
                listOf(
                    applicationModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
        setupTimber()
    }

/*

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
*/

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}