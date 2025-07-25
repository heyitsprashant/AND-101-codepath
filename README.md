# 🐶 Dog Breed Gallery App

A simple Android app built using Kotlin that displays random dog breed images using the Dog CEO API. Users can view a scrollable list of dog breeds, search through them, and toggle between light and dark mode. Click on a breed to see a toast message!

---

## 📸 Features

### ✅ Required Features
| Feature | Description | Where Implemented |
|--------|-------------|-------------------|
| **AsyncHTTPClient** | Used to fetch data from the Dog CEO API | `MainActivity.kt` (function: `fetchDogs()`), `build.gradle` dependency |
| **API URL** | URL: `https://dog.ceo/api/breeds/image/random/50` | `MainActivity.kt` |
| **RecyclerView** | Scrollable list of dog breeds | `activity_main.xml` + `MainActivity.kt` |
| **3+ data points** | Each item shows: breed name, subtitle, image | `Dog.kt`, `DogAdapter.kt`, `item_dog.xml` |

### 🌟 Stretch Features
| Feature | Description | Where Implemented |
|--------|-------------|-------------------|
| **Search/Filter** | SearchView filters dog breeds live | `activity_main.xml`, `MainActivity.kt` |
| **Toast on click** | Clicking an item shows a toast with the breed name | `MainActivity.kt`, `DogAdapter.kt` |
| **Dividers** | Divider between list items | `MainActivity.kt` |
| **Theme Toggle** | Toggle light/dark mode via button | `activity_main.xml`, `MainActivity.kt` |

---

## 📂 File Structure

```
DogBreedGallery/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/dogbreedgallery/
│           │   ├── MainActivity.kt
│           │   ├── DogAdapter.kt
│           │   └── Dog.kt
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml
│               │   └── item_dog.xml
│               ├── drawable/
│               │   └── custom_divider.xml (optional)
│               └── values/
│                   ├── themes.xml
│                   └── colors.xml
```

---

## 💠 Setup & Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/DogBreedGallery.git
   ```

2. Open in **Android Studio**.

3. Add this dependency in `build.gradle (Module: app)`:
   ```groovy
   implementation 'com.loopj.android:android-async-http:1.4.11'
   ```

4. Sync Gradle and run the app on an emulator or real device.

---

## 🎥 Demo Screenshots

| Home Screen | Search Active | Dark Mode |
|-------------|----------------|-----------|
| ![home](screenshots/home.png) | ![search](screenshots/search.png) | ![dark](screenshots/dark.png) |

---

## 📱 API Used

- [Dog CEO API](https://dog.ceo/dog-api/): Returns random images of dog breeds.

---

## 🤖 Tech Stack

- Kotlin
- Android SDK
- RecyclerView
- AsyncHttpClient (for network)
- Material Design (Buttons, SearchView)
- Dark Mode (AppCompatDelegate)

---

## 👤 Author

**Prashant**  
Computer Science & Math @ Jacksonville State University  
Peer Mentor @ CodePath  
Web Developer @ IEEE JSU  
Researcher @ HTIR Lab  
🐾 Loves clean code and doggos

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
