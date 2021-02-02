plugins {
    `android-application`
}

dependencies {
    implementation(project(":shared:data:model"))
    implementation(project(":shared:presentation"))
    implementation(project(":android:components"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.recyclerView)
    implementation(Libraries.Kodein.core)
    implementation(Libraries.Kodein.android)
    implementation(Libraries.Kodein.androidX)
}
