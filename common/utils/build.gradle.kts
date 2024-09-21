plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.kotlinx.coroutines.android)
        }
    }
}

android {
    namespace = "com.alexmprog.thepets.common.logger"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig { minSdk = libs.versions.android.minSdk.get().toInt() }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
