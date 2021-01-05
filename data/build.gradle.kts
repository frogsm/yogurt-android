plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

apply(plugin = "realm-android")
apply(plugin = "dagger.hilt.android.plugin")

android {
    compileSdkVersion(Versions.compile_sdk)
    buildToolsVersion(Versions.build_tools)

    defaultConfig {
        versionCode = Versions.code
        versionName = Versions.name

        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
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
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(project(path = ":domain"))

    implementation(Kotlin.stdlib)

    implementation(Coroutines.core)

    implementation(AndroidX.core)
    implementation(AndroidX.appcompat)

    implementation(Hilt.android)
    kapt(Hilt.android_compiler)

    implementation(Retrofit.base)
    implementation(Retrofit.convert_moshi)

    implementation(OkHttp.logging_interceptor)

    implementation(Moshi.kotlin)
    kapt(Moshi.kotlin_codegen)

    testImplementation(Test.junit)
    androidTestImplementation(Test.ext_junit)
    androidTestImplementation(Test.espresso)
}