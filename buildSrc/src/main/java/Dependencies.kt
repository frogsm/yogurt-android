
object Versions {
    const val code = 1
    const val name = "1.0"

    const val min_sdk = 22
    const val target_sdk = 30
    const val compile_sdk = 30
    const val build_tools = "30.0.2"
}

object Kotlin {
    private object Versions {
        const val kotlin = "1.4.10"
    }

    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
}

object Coroutines {
    private object Versions {
        const val coroutines = "1.3.5"
    }

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object Android {
    private object Versions {
        const val gradle = "4.1.0"
    }

    const val plugin = "com.android.tools.build:gradle:${Versions.gradle}"
}

object AndroidX {
    private object Versions {
        const val core = "1.3.2"
        const val appcompat = "1.2.0"
        const val activity = "1.1.0"
        const val fragment = "1.2.5"
        const val lifecycle = "2.2.0"
        const val viewpager = "1.0.0"
        const val constraint_layout = "2.0.2"
        const val hilt = "1.0.0-alpha02"
    }

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycle_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_java8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val viewpager = "androidx.viewpager2:viewpager2:${Versions.viewpager}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val hilt_lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
    const val hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"
}

object Navigation {
    private object Versions {
        const val navigation = "2.3.0"
    }

    const val plugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
}

object Hilt {
    private object Versions {
        const val hilt = "2.29.1-alpha"
    }

    const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val android_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}

object Dagger {
    private object Versions {
        const val dagger = "2.30.1"
    }

    const val base = "com.google.dagger:dagger:${Versions.dagger}"
    const val android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val compiler_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Test {
    private object Versions {
        const val junit = "4.13.1"
        const val ext_junit = "1.1.2"
        const val espresso = "3.3.0"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Realm {
    private object Versions {
        const val realm = "6.0.2"
    }

    const val plugin = "io.realm:realm-gradle-plugin:${Versions.realm}"
}

object Material {
    private object Versions {
        const val material = "1.2.1"
    }

    const val base = "com.google.android.material:material:${Versions.material}"
}

object Retrofit {
    private object Versions {
        const val retrofit = "2.9.0"
    }

    const val base = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val convert_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
}

object OkHttp {
    private object Versions {
        const val okhttp = "4.9.0"
    }

    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}

object Moshi {
    private object Versions {
        const val moshi = "1.11.0"
    }

    const val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val kotlin_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object Glide {
    private object Versions {
        const val glide = "4.11.0"
    }

    const val base = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}