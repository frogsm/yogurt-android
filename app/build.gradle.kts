plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

apply(plugin = "androidx.navigation.safeargs.kotlin")
apply(plugin = "dagger.hilt.android.plugin")

android {
    compileSdkVersion(Versions.compile_sdk)
    buildToolsVersion(Versions.build_tools)

    defaultConfig {
        applicationId = "com.frogsm.yogurt"
        versionCode = Versions.code
        versionName = Versions.name

        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xallow-result-return-type")
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(project(path = ":data"))
    implementation(project(path = ":domain"))

    implementation(Kotlin.stdlib)

    implementation(AndroidX.core)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.activity)
    implementation(AndroidX.fragment)
    implementation(AndroidX.lifecycle_ktx)
    implementation(AndroidX.lifecycle_java8)
    implementation(AndroidX.viewpager)
    implementation(AndroidX.constraint_layout)

    implementation(AndroidX.hilt_lifecycle)
    kapt(AndroidX.hilt_compiler)

    implementation(Navigation.ui)
    implementation(Navigation.fragment)

    implementation(Hilt.android)
    kapt(Hilt.android_compiler)

    implementation(Material.base)

    implementation(Retrofit.base)
    implementation(Retrofit.convert_moshi)

    implementation(OkHttp.logging_interceptor)

    implementation(Moshi.kotlin)
    kapt(Moshi.kotlin_codegen)

    implementation(Glide.base)
    kapt(Glide.compiler)

    testImplementation(Test.junit)
    androidTestImplementation(Test.ext_junit)
    androidTestImplementation(Test.espresso)
}

kapt {
    correctErrorTypes = true
}