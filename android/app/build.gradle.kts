plugins {
    `android-application`
}

dependencies {
    implementation(project(":shared:components"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.recyclerView)
    implementation(Libraries.Kodein.android)
    implementation(Libraries.Kodein.androidX)
}
