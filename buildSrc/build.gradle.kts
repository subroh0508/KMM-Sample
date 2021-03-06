import java.util.*

plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

val props = Properties().apply {
    file("../gradle.properties").inputStream().use(this::load)
}

fun version(target: String) = props.getProperty("${target}.version")

dependencies {
    implementation("com.android.tools.build:gradle:${version("android-gradle-plugin")}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${version("kotlin")}")
}
