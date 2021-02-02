import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Kodein.core)
            }
        }
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
        val iosMain by getting
        val iosTest by getting
    }
}

androidBaseExt()
android {
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}
