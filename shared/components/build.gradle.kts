import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    `android-multiplatform`
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "iosArtifacts"

                export(project(":shared:data:model"))
                export(project(":shared:presentation"))
                export(Libraries.Kodein.core)
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":shared:data:model"))
                api(project(":shared:presentation"))
                api(Libraries.Kodein.core)

                implementation(project(":shared:api"))
                implementation(project(":shared:data:infra"))
                implementation(Libraries.Ktor.client)
            }
        }
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
        val iosMain by getting
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
