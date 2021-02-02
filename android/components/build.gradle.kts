plugins {
    `android-library`
}

dependencies {
    implementation(project(":shared:api"))
    implementation(project(":shared:data:infra"))
    implementation(project(":shared:data:model"))
    implementation(Libraries.Jetpack.material)
    implementation(Libraries.Jetpack.appCompat)
    implementation(Libraries.Jetpack.activity)
    implementation(Libraries.Jetpack.constraintLayout)
    implementation(Libraries.Jetpack.recyclerView)
    implementation(Libraries.Kodein.core)
}
