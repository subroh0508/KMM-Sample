plugins {
    `android-library`
}

dependencies {
    implementation(project(":shared"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.recyclerView)
}
