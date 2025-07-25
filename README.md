# Pokémon API Android App

This Android application allows users to search for any Pokémon using the PokéAPI and view its basic information. The app uses `AsyncHttpClient` to make API calls and displays data using a simple user interface built with XML and Kotlin.

## 📱 Features Implemented

### ✅ Required Features

| Feature | Implemented | Code Location |
|---------|-------------|---------------|
| Make an API call with `AsyncHTTPClient` | ✅ Yes | `MainActivity.kt` (line ~35) |
| Display at least three pieces of data for each API entry | ✅ Yes | `name`, `base_experience`, `ability`, and image |
| A working button that requests a new API entry and updates the data | ✅ Yes | `btnSearch.setOnClickListener` (line ~25) |

### 🌟 Stretch Features

| Feature | Implemented | Code Location |
|---------|-------------|---------------|
| Add a query to the API request | ✅ Yes | User input from `etSearch` in URL (line ~36) |
| Build a UI to allow users to add that query | ✅ Yes | `EditText` (`etSearch`) defined in XML layout |

## 💡 How It Works

1. User enters a Pokémon name or ID in the input field.
2. Taps the "Search" button.
3. The app queries the PokéAPI using AsyncHttpClient.
4. The following data is parsed from the JSON response:
   * Pokémon Name
   * Base Experience
   * First Ability
   * Front-facing image sprite
5. All of this data is displayed dynamically in the app.

## 🧪 Sample Query

```kotlin
val url = "https://pokeapi.co/api/v2/pokemon/$query"
```

## 📸 Screenshots & Demo

Include a GIF of:
* Opening the app
* Searching for a Pokémon (e.g. pikachu)
* Data and image updating correctly

## 🗂 Project Structure

```
├── MainActivity.kt
├── activity_main.xml
├── build.gradle
└── AndroidManifest.xml
```

## 📄 activity_main.xml Snippet

```xml
<EditText
    android:id="@+id/etSearch"
    ... />
<Button
    android:id="@+id/btnSearch"
    ... />
<ImageView
    android:id="@+id/ivPokemon"
    ... />
<TextView
    android:id="@+id/tvName"
    ... />
<TextView
    android:id="@+id/tvExperience"
    ... />
```

## 🔧 Dependencies

```groovy
implementation 'com.loopj.android:android-async-http:1.4.10'
implementation 'com.github.bumptech.glide:glide:4.15.1'
annotationProcessor 'com.github.bumptech.glide:compiler:4.15.1'
```

## 📜 AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## 🤖 Tools Used

* Kotlin
* Android Studio
* PokeAPI
* AsyncHttpClient
* Glide

## 🧠 Reflection

This project helped reinforce:
* Working with external APIs
* Parsing complex JSON data
* Handling user input and UI updates in Android

## 📬 Submission Requirements Checklist

- [x] API call made with AsyncHTTPClient
- [x] 3+ data fields displayed
- [x] Button functionality implemented
- [x] Input field for user query
- [x] README and demo GIF

---

Feel free to modify or expand this README as needed for your project or submission.
