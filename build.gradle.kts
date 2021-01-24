buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(kotlinGradlePlugin)
        classpath(kotlinSerializationPlugin)
        classpath(androidGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}
