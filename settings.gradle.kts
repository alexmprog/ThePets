@file:Suppress("UnstableApiUsage")

include(":feature:home:impl")


include(":feature:home:api")


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
include(":feature:cats:impl")
include(":feature:cats:api")
include(":feature:dogs:impl")
include(":feature:dogs:api")