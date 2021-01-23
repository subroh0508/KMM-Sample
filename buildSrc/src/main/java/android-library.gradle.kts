plugins {
    id("com.android.library")
    kotlin("android")
}

androidBaseExt()
android {
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}
