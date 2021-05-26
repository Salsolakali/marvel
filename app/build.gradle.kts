plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")
    flavorDimensions("default")
    buildFeatures {
        viewBinding = true
    }
    defaultConfig {
        applicationId = "com.example.marvel"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
        }
        getByName("debug") {}
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField(
                "okhttp3.logging.HttpLoggingInterceptor.Level",
                "LEVEL_LOGS",
                "okhttp3.logging.HttpLoggingInterceptor.Level.NONE"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            buildConfigField(
                "okhttp3.logging.HttpLoggingInterceptor.Level",
                "LEVEL_LOGS",
                "okhttp3.logging.HttpLoggingInterceptor.Level.BODY"
            )
        }
    }

    productFlavors {
        create("pro") {
            buildConfigField("String", "HOST", "\"https://gateway.marvel.com/v1/public/\"")
            buildConfigField("String", "PUBLIC_KEY", project.property("PUBLIC_KEY") as String)
            buildConfigField("String", "PRIVATE_KEY", project.property("PRIVATE_KEY") as String)
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // Kotlin
    implementation(kotlin("stdlib-jdk7", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")

    // Android jetpack
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.lifecycle:lifecycle-runtime:2.3.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Support
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    // Dagger
    implementation("com.google.dagger:hilt-android:2.28.3-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28.3-alpha")

    // Retrofit OkHttp
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.6.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.9.3")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    // Required for local unit tests
    testImplementation("junit:junit:4.13.2")

}