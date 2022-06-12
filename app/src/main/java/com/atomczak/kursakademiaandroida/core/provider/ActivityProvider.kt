package com.atomczak.kursakademiaandroida.core.provider

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityProvider(application: Application) {
    var foregroundActivity: Activity? = null

    init {
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, p1: Bundle?) = Unit
            override fun onActivityStarted(activity: Activity) = Unit
            override fun onActivityStopped(activity: Activity) = Unit
            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) = Unit
            override fun onActivityDestroyed(activity: Activity) = Unit
            override fun onActivityResumed(activity: Activity) {
                foregroundActivity = activity
            }

            override fun onActivityPaused(activity: Activity) {
                foregroundActivity = null
            }
        })
    }
}