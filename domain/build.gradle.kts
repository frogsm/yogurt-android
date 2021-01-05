plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(Kotlin.stdlib)

    implementation(Coroutines.core)

    implementation(Dagger.base)
    kapt(Dagger.compiler)
    kapt(Dagger.compiler_processor)
}