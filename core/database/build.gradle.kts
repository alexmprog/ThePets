plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.dispatchers)
            implementation(projects.common.logger)
            implementation(libs.sqldelight.runtime)
            implementation(libs.sqldelight.coroutines)
            implementation(libs.koin.core)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android)
        }
    }
}

sqldelight {
    databases.create("PetsDatabase") {
        packageName.set("com.alexmprog.thepets.core.database")
    }
}

android {
    namespace = "com.alexmprog.thepets.core.database"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig { minSdk = libs.versions.android.minSdk.get().toInt() }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
