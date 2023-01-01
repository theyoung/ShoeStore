# The Shoe Store

This project is an app that manages users' shoes.

This project consisted of five screens.

- Login screen: Email and password fields and labels plus create and login buttons
- Welcome onboarding screen
- Instructions onboarding screen
- Shoe Listing screen
- Shoe Detail screen for adding a new shoe

## Getting Started

Here are the few steps on how you could clone and running on your devices.

1. clone repository
```
git clone https://github.com/theyoung/ShoeStore.git
```

2. Open Projects with Android Studio
3. Sync Project with gradle files
4. Run 'app'

### Dependencies

This project is on couple of dependencies.
- kotlin library
- navigation and safeargs
- Data Binding and View Model
- Observer and Kotlin annotation

```
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.5.1'
    implementation 'com.google.android.material:material:1.7.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'

    def nav_version = "2.5.3"

    // Java language implementation
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    implementation "androidx.navigation:navigation-ui:$nav_version"

    // Kotlin
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

    // Feature module Support
    implementation "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"

    // Testing Navigation
    androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"

    // Jetpack Compose Integration
    implementation "androidx.navigation:navigation-compose:$nav_version"

    def fragment_version = "1.5.4"

    // Kotlin
    implementation "androidx.fragment:fragment-ktx:$fragment_version"

    def lifecycle_version = "2.5.1"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // ViewModel utilities for Compose
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    // Saved state module for ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
```

### Installation

There are two types of installation into devices.

1. Run 'app' in Android Studio function
2. install apk : Generated APK file from 'Build APKs' of Android Studio Menu
```
adb install -r <<apk name>>
```

## Testing

Not Support At This Moment

### Break Down Tests

Not Support At This Moment
