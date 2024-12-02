plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //id("com.google.devtools.ksp") version "1.8.21-1.0.11"
}

android {
    namespace = "com.example.scientificcalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.scientificcalculator"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt") ,
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.material3)
    //KSP
    implementation(libs.androidx.room.runtime) // Replace with the latest version
    //ksp("androidx.room:room-compiler:2.5.1")


    // Coroutines
    implementation(libs.kotlinx.coroutines.android) // Replace with the latest version

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx.v262) // Replace with the latest version
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // Replace with the latest version
    implementation(libs.androidx.lifecycle.livedata.ktx) // Replace with the latest version

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Replace with the latest version
    implementation(libs.androidx.navigation.compose)
}


