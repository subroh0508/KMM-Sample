@file:Suppress("HardcodedStringLiteral")

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Android {
    const val applicationId = "net.subroh0508.colormaster"
    const val versionCode = 1
    const val versionName = "0.0.1"

    object Versions {
        const val compileSdk = 28
        const val minSdk = 21
        const val targetSdk = 28
    }
}

val Project.androidGradlePlugin get() = "com.android.tools.build:gradle:${version("android-gradle-plugin")}"

internal fun Project.androidBaseExt() = (this as ExtensionAware).extensions.configure<BaseExtension>("android") {
    compileSdkVersion(Android.Versions.compileSdk)

    defaultConfig {
        minSdkVersion(Android.Versions.minSdk)
        targetSdkVersion(Android.Versions.targetSdk)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets.forEach {
        it.java.setSrcDirs(files("src/${it.name}/kotlin"))
    }

    tasks.withType(KotlinCompile::class).all {
        kotlinOptions { jvmTarget = "1.8" }
    }

    buildFeatures.viewBinding = true
}
