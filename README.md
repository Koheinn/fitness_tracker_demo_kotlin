# Fitness Tracker Demo (Kotlin)

A small Android demo app built in Kotlin that demonstrates a simple fitness-tracking flow with authentication screens and a home dashboard. The project is a lightweight example showing modern Android tooling (Gradle Kotlin DSL, ViewBinding), animation support, and basic networking.

---

## Quick links
- License: LICENSE
- Key files:
  - HomeActivity: https://github.com/Koheinn/fitness_tracker_demo_kotlin/blob/main/app/src/main/java/com/example/fitness_tracker_demo/HomeActivity.kt
  - LoginActivity: https://github.com/Koheinn/fitness_tracker_demo_kotlin/blob/main/app/src/main/java/com/example/fitness_tracker_demo/LoginActivity.kt
  - RegisterActivity: https://github.com/Koheinn/fitness_tracker_demo_kotlin/blob/main/app/src/main/java/com/example/fitness_tracker_demo/RegisterActivity.kt
  - App build file: app/build.gradle.kts
  - Manifest: app/src/main/AndroidManifest.xml

---

## Overview

Fitness Tracker Demo is a compact Android application implemented in Kotlin, intended to demonstrate:
- Basic authentication screens (Register / Login)
- A simple home/dashboard Activity
- Modern UI considerations (edge-to-edge layout, ViewBinding)
- Lightweight networking with Volley
- Animated UI elements via Lottie

This is a demo project meant for learning, experimentation, and as a base for small prototypes.

---

## Features

- Register and Login screens (email/password flow in the demo)
- Home screen with edge-to-edge layout handling
- ViewBinding enabled for safe view access
- Lottie animations used to enhance UI
- Networking via Volley for lightweight requests
- Minimum Android SDK 24; target SDK 35

---

## Tech stack

- Language: Kotlin
- Android SDK: 35 (compileSdk = 35)
- Minimum SDK: 24 (minSdk = 24)
- Build: Gradle Kotlin DSL
- Libraries:
  - AndroidX Core / AppCompat / ConstraintLayout / Activity KTX
  - Material Components
  - Lottie (com.airbnb.android:lottie:5.2.0)
  - Volley (com.android.volley:volley:1.2.1)
- ViewBinding enabled

---

## Prerequisites

- Android Studio Flamingo or later recommended
- Android SDK for API 24+ installed
- JDK 11 (project targets jvmTarget = "11")
- A connected Android device or emulator

---

## Build & run

1. Clone the repository:
   git clone https://github.com/Koheinn/fitness_tracker_demo_kotlin.git

2. Open the project in Android Studio:
   - File → Open → select the project folder
   - Let Android Studio sync Gradle and download dependencies

Or from the command line:

- Build a debug APK:
  ./gradlew assembleDebug

- Install to a connected device/emulator:
  ./gradlew installDebug

Notes:
- Use the Android Studio Run configuration to launch on an emulator for easier debugging.
- If you prefer a release build, adapt proguard settings (app/proguard-rules.pro) and run assembleRelease.

---

## Project structure (high level)

- app/
  - build.gradle.kts — module build configuration
  - src/main/
    - java/com/example/fitness_tracker_demo/
      - LoginActivity.kt — login screen
      - RegisterActivity.kt — registration screen
      - HomeActivity.kt — main home/dashboard screen
    - AndroidManifest.xml — app manifest
    - res/ — layouts, drawables, animations (Lottie) and other resources

---

## Usage

- Launch the app on a device/emulator.
- Use the Register screen to create a demo account (app is a local/demo flow; check code for mock endpoints / behavior).
- After registering/logging in, you are taken to the Home screen which demonstrates edge-to-edge layout and content padding handling.

(For exact runtime behavior and how credentials are handled, see the Activities in `app/src/main/java/com/example/fitness_tracker_demo`.)

---

## Notes for developers

- ViewBinding is enabled (see `app/build.gradle.kts`), so use binding classes to reference UI elements.
- Networking: simple examples use Volley. Replace or expand with Retrofit/OkHttp if you need advanced features.
- Lottie: animation JSON files can be placed in `res/raw` and referenced in layouts or programmatically.
- ProGuard: release build currently keeps minify disabled; review `proguard-rules.pro` when enabling minification.

---

## Tests

- Unit tests: use `./gradlew test` to run JVM unit tests (if present).
- Instrumented tests: use `./gradlew connectedAndroidTest` on a connected device/emulator.

---

## Troubleshooting

- "SDK not found" — ensure Android SDK and corresponding API platform installed.
- Gradle sync issues — try File → Sync Project with Gradle Files and re-open Android Studio after SDK updates.
- Device install failures — confirm adb recognizes device (`adb devices`) and that the selected ABI is supported.

---

## Contributing

Contributions are welcome. Suggested workflow:
1. Fork the repo.
2. Create a feature branch: `git checkout -b feat/your-feature`
3. Make changes, commit, and push.
4. Open a pull request describing your changes.

Please keep changes small and include screenshots for UI updates.

---

## License

This project is released under the terms in the repository LICENSE file.

---

## Contact

Maintainer: Koheinn (repo owner)

If you want, I can also create a branch and open a pull request instead of committing directly. Reply "branch" if you'd prefer that option.