@file:Suppress("HardcodedStringLiteral")

object Libraries {
    object Jetpack {
        private const val coreVersion = "1.3.1"
        private const val appCompatVersion = "1.2.0"
        private const val constraintLayoutVersion = "2.0.2"
        private const val materialVersion = "1.2.1"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val material = "com.google.android.material:material:$materialVersion"
    }
}
