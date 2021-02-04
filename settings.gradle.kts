pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "KMM-Sample"


include(
    ":android:app",
    // ":android:components",
    // ":ios:components",
    ":shared:api",
    ":shared:data:model",
    ":shared:data:infra",
    ":shared:presentation",
    ":shared:components"
)

