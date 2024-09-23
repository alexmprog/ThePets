# ThePets

![GitHub Logo](/screenshots/android_app_flow.gif)

## About
Compose Multiplatform application simply loads data from API and stores it in persistence storage (i.e. SQLite Database).
* User real  [Cats](https://thecatapi.com) and [Dogs](https://dog.ceo/dog-api) api.<br>
* Clean and Simple Material UI.<br>
* Use multi-module Gradle architecture.<br>

## Built With 🛠
[Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.<br>
[Kotlin Gradle DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Provides an alternative syntax to the traditional Groovy DSL for Gradle build system. <br>
[Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Kotlin Asynchronous or non-blocking programming.<br>
[Compose](https://developer.android.com/develop/ui/compose/documentation) - The modern toolkit for building native Android UI.<br>
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.<br>
[Voyager](https://voyager.adriel.cafe) - Component helps you implement navigation.<br>
[Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.<br>
[Koin](https://insert-koin.io) - The pragmatic Kotlin Dependency Injection framework.<br>
[Ktor](https://ktor.io) - A type-safe Kotlin Multiplatform HTTP client.<br>
[Kotlin Serialization](https://kotlinlang.org/docs/serialization.html)) - A modern JSON library for Kotlin and Java.<br>

## Module Graph

```mermaid
%%{
  init: {
    'theme': 'base',
    'themeVariables': {"primaryTextColor":"#F6F8FAff","primaryColor":"#5a4f7c","primaryBorderColor":"#5a4f7c","tertiaryColor":"#40375c","lineColor":"#f5a623","fontSize":"12px"}
  }
}%%

graph TB
  subgraph :common
    :common:utils["utils"]
    :common:logger["logger"]
    :common:dispatchers["dispatchers"]
  end
  subgraph :core
    :core:database["database"]
    :core:network["network"]
    :core:ui["ui"]
  end
  subgraph :feature:cats
    :feature:cats:api["api"]
    :feature:cats:impl["impl"]
  end
  subgraph :feature:dogs
    :feature:dogs:api["api"]
    :feature:dogs:impl["impl"]
  end
  subgraph :feature:home
    :feature:home:impl["impl"]
    :feature:home:api["api"]
  end
  :feature:dogs:api --> :common:utils
  :core:database --> :common:logger
  :core:database --> :common:dispatchers
  :feature:home:impl --> :common:dispatchers
  :feature:home:impl --> :common:logger
  :feature:home:impl --> :common:utils
  :feature:home:impl --> :core:database
  :feature:home:impl --> :core:network
  :feature:home:impl --> :feature:cats:api
  :feature:home:impl --> :feature:dogs:api
  :feature:home:impl --> :feature:home:api
  :feature:cats:api --> :common:utils
  :app --> :common:dispatchers
  :app --> :common:logger
  :app --> :core:network
  :app --> :core:database
  :app --> :core:ui
  :app --> :feature:cats:api
  :app --> :feature:cats:impl
  :app --> :feature:dogs:api
  :app --> :feature:dogs:impl
  :app --> :feature:home:api
  :app --> :feature:home:impl
  :feature:home:api --> :common:utils
  :core:network --> :common:logger
  :core:network --> :common:utils
  :feature:dogs:impl --> :common:dispatchers
  :feature:dogs:impl --> :common:logger
  :feature:dogs:impl --> :common:utils
  :feature:dogs:impl --> :core:database
  :feature:dogs:impl --> :core:network
  :feature:dogs:impl --> :core:ui
  :feature:dogs:impl --> :feature:dogs:api
  :feature:cats:impl --> :common:dispatchers
  :feature:cats:impl --> :common:logger
  :feature:cats:impl --> :common:utils
  :feature:cats:impl --> :core:database
  :feature:cats:impl --> :core:network
  :feature:cats:impl --> :core:ui
  :feature:cats:impl --> :feature:cats:api

classDef kotlin-multiplatform fill:#C792EA,stroke:#fff,stroke-width:2px,color:#fff;
classDef android-application fill:#2C4162,stroke:#fff,stroke-width:2px,color:#fff;
class :feature:dogs:api kotlin-multiplatform
class :common:utils kotlin-multiplatform
class :core:database kotlin-multiplatform
class :common:logger kotlin-multiplatform
class :common:dispatchers kotlin-multiplatform
class :feature:home:impl kotlin-multiplatform
class :core:network kotlin-multiplatform
class :feature:cats:api kotlin-multiplatform
class :feature:home:api kotlin-multiplatform
class :app android-application
class :core:ui kotlin-multiplatform
class :feature:cats:impl kotlin-multiplatform
class :feature:dogs:impl kotlin-multiplatform

```

## Architecture
This repository uses recommended Android [App architecture](https://developer.android.com/topic/architecture).
![Image of Clean Architecture](https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-overview.png)