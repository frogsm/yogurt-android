// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0")
        classpath(kotlin("gradle-plugin", "1.3.72"))
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")
        classpath("io.realm:realm-gradle-plugin:6.0.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.29.1-alpha")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}