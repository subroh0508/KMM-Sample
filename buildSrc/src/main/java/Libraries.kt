@file:Suppress("HardcodedStringLiteral")

object Libraries {
    object Jetpack {
        private const val coreVersion = "1.3.1"
        private const val appCompatVersion = "1.2.0"
        private const val activityVersion = "1.2.0-rc01"
        private const val constraintLayoutVersion = "2.0.4"
        private const val recyclerViewVersion = "1.1.0"
        private const val materialVersion = "1.2.1"
        private const val lifecycleVersion = "2.3.0-rc01"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val activity = "androidx.activity:activity-ktx:$activityVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
        const val material = "com.google.android.material:material:$materialVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
    }

    object Serialization {
        const val version = "1.0.1"

        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }

    object Coroutines {
        private const val version = "1.4.2-native-mt"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"

        const val testAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Ktor {
        private const val version = "1.5.0"

        const val client = "io.ktor:ktor-client-core:$version"
        const val clientOkHttp = "io.ktor:ktor-client-okhttp:$version"
        const val clientIos = "io.ktor:ktor-client-ios:$version"
        const val clientLogging = "io.ktor:ktor-client-logging:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"

        const val clientMock = "io.ktor:ktor-client-mock:$version"
    }

    object Okhttp3 {
        private const val version = "4.6.0"

        const val client = "com.squareup.okhttp3:okhttp:$version"
        const val loggingIntercerptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Kodein {
        private const val version = "7.2.0"

        const val core = "org.kodein.di:kodein-di:$version"
        const val android = "org.kodein.di:kodein-di-framework-android-core:$version"
        const val androidX = "org.kodein.di:kodein-di-framework-android-x:$version"
    }
}
