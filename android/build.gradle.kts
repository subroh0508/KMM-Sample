plugins {
    `android-application`
}

dependencies {
    implementation(project(":shared"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.constraintLayout)
}
