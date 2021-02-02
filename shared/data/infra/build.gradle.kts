plugins {
    `android-multiplatform`
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:api"))
                implementation(project(":shared:data:model"))
                implementation(Libraries.Serialization.core)
                implementation(Libraries.Coroutines.core)
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
