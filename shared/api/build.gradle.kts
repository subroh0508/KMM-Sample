plugins {
    `android-multiplatform`
    id("kotlinx-serialization")
}

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Serialization.core)
                implementation(Libraries.Coroutines.core)
                implementation(Libraries.Ktor.client)
                implementation(Libraries.Ktor.clientLogging)
                implementation(Libraries.Ktor.serialization)
                implementation(Libraries.Ktor.json)
                implementation(Libraries.Kodein.core)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Ktor.clientOkHttp)
                implementation(Libraries.Okhttp3.loggingIntercerptor)
                implementation(Libraries.Jetpack.viewModel)
                implementation(Libraries.Jetpack.commonJava8)
            }
        }
        val androidTest by getting
        val iosMain by getting {
            dependencies {
                implementation(Libraries.Ktor.clientIos)
            }
        }
        val iosTest by getting
    }
}
