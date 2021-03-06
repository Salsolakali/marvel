// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
     val kotlin_version = "1.4.30"
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io/")
    }
}
