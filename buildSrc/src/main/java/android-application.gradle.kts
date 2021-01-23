plugins {
    id("com.android.application")
    kotlin("android")
}

androidBaseExt()
android {
    defaultConfig {
        applicationId = Android.applicationId
        versionCode = Android.versionCode
        versionName = Android.versionName
    }

    packagingOptions {
        exclude("META-INF/*")
    }
}
