plugins {
    `android-application`
}

dependencies {
    implementation(project(":shared:data:model"))
    implementation(project(":shared:presentation"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.recyclerView)
}
