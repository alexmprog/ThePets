plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.logger)
            implementation(projects.common.utils)
            implementation(projects.core.database)
            implementation(projects.core.network)
            implementation(projects.feature.cats.api)
            implementation(projects.feature.dogs.api)
            implementation(projects.feature.home.api)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)

            implementation(libs.voyager.koin)
            implementation(libs.voyager.screenModel)

            implementation(libs.coil.compose)
            implementation(libs.coil.network)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.alexmprog.thepets.feature.home.impl"
    generateResClass = auto
}

android {
    namespace = "com.alexmprog.thepets.feature.home.impl"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig { minSdk = libs.versions.android.minSdk.get().toInt() }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
