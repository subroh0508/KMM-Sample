plugins {
    `android-multiplatform`
}

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
        val iosMain by getting
        val iosTest by getting
    }
}
