import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    `android-multiplatform`
    id("kotlinx-serialization")
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"

                export(project(":shared:data:model"))
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:data:model"))
                implementation(Libraries.Serialization.core)
                implementation(Libraries.Coroutines.core)
                implementation(Libraries.Ktor.client)
                implementation(Libraries.Ktor.clientLogging)
                implementation(Libraries.Ktor.serialization)
                implementation(Libraries.Ktor.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Ktor.clientOkHttp)
                implementation(Libraries.Okhttp3.loggingIntercerptor)
                implementation(Libraries.Jetpack.viewModel)
                implementation(Libraries.Jetpack.commonJava8)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Libraries.Ktor.clientIos)
            }
        }
        val iosTest by getting
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)
