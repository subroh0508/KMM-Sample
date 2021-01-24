plugins {
    `android-application`
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":shared:data:model"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.recyclerView)
}
