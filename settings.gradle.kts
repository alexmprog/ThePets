@file:Suppress("UnstableApiUsage")

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
include(":common:dispatchers")
include(":common:logger")
include(":common:utils")
include(":core:database")
include(":core:network")
include(":core:ui")
include(":data:cats")
include(":data:dogs")
include(":domain:cats")
include(":domain:dogs")
include(":feature:cats:impl")
include(":feature:cats:api")
include(":feature:dogs:impl")
include(":feature:dogs:api")
include(":feature:home:impl")
include(":feature:home:api")