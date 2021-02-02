plugins {
    `android-multiplatform`
}

kotlin {
    android()
    ios()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:api"))
                implementation(project(":shared:data:model"))
                implementation(project(":shared:data:infra"))
                implementation(Libraries.Coroutines.core)
                implementation(Libraries.Kodein.core)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Jetpack.viewModel)
                implementation(Libraries.Jetpack.commonJava8)
                implementation(Libraries.Kodein.android)
                implementation(Libraries.Kodein.androidX)
            }
        }
        val androidTest by getting
        val iosMain by getting
        val iosTest by getting
    }
}
