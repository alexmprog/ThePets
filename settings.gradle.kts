@file:Suppress("UnstableApiUsage")

include(":common:dispatchers")


include(":core:ui")


include(":feature:dogs:impl")


include(":feature:dogs:api")


rootProject.name = "ThePets"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":app")
include(":common:utils")
include(":common:logger")
include(":core:database")
include(":core:network")