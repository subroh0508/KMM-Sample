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
    ":android:components",
    ":ios:components",
    ":shared",
    ":shared:api",
    ":shared:data:model"
)

