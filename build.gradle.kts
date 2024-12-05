plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.scientificcalculator"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.scientificcalculator"
        minSdk = 21
        targetSdk = 35
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"  // Add this line with the appropriate version
    }
}

dependencies {

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.3")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.generativeai)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.material3)



    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx.v262) // Replace with the latest version
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // Replace with the latest version
    implementation(libs.androidx.lifecycle.livedata.ktx) // Replace with the latest version

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.exp4j) // Replace with the latest version
    implementation(libs.play.services.mlkit.text.recognition)

/*    //KSP
    implementation(libs.androidx.room.runtime)
    // for ksp
    ksp("com.example:my-annotation-processor:1.0.0")

    ksp(libs.androidx.room.room.compiler)

    implementation(libs.androidx.room.runtime.v261)

    // To use Kotlin Symbol Processing (KSP) - If using KSP
    ksp(libs.androidx.room.room.compiler)*/

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // for camera x
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)


    implementation("com.google.accompanist:accompanist-permissions:0.31.2-alpha")
}

