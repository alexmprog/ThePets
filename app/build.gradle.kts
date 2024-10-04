import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

compose.resources {
    generateResClass = never
}

kotlin {
    androidTarget()

    //jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "app"
            binaryOptions["bundleId"] = "com.alexmprog.thepets.app"
        }
    }

    sourceSets {

        //val desktopMain by getting

        commonMain.dependencies {
            implementation(projects.common.logger)
            implementation(projects.core.database)
            implementation(projects.core.dispatchers)
            implementation(projects.core.network)
            implementation(projects.core.ui)
            implementation(projects.data.cats)
            implementation(projects.data.dogs)
            implementation(projects.domain.cats)
            implementation(projects.domain.dogs)
            implementation(projects.feature.cats.api)
            implementation(projects.feature.cats.impl)
            implementation(projects.feature.dogs.api)
            implementation(projects.feature.dogs.impl)
            implementation(projects.feature.home.api)
            implementation(projects.feature.home.impl)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.voyager.koin)
            implementation(libs.voyager.screenModel)
            implementation(libs.voyager.navigator)
        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
        }

//        desktopMain.dependencies {
//            implementation(compose.desktop.currentOs)
//            implementation(libs.kotlinx.coroutines.swing)
//        }
    }
}

android {
    namespace = "com.alexmprog.thepets"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.alexmprog.thepets"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

compose.desktop {
    application {
        mainClass = "com.alexmprog.thepets.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.alexmprog.thepets"
            packageVersion = "1.0.0"
        }
    }
}
