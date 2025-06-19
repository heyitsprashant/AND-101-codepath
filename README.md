# Week 2 – Kotlin Debug-a-thon 🔍

This project is part of the **CodePath AND-101** course — Week 2 assignment.  
The goal of this project was to **debug and fix a broken Kotlin Android app** through hands-on practice.

---

## ✅ Fixed Features

### 🔹 Hello World Activity
- ❌ Crashed due to `ClassCastException`
- ✅ Fixed by replacing `404 as Context` with `this`

### 🔹 Number Sum Activity
- ❌ Crashed due to unsafe cast from `String` to `Int`
- ✅ Used `"2".toInt()` for safe parsing

### 🔹 Current Day Activity
- ❌ Crashed due to `Resources$NotFoundException`
- ✅ Converted `Int` to `String` before assigning to TextView

### 🔹 Random Color Activity
- ❌ Caused infinite recursion in `getRandomColor()`
- ✅ Removed recursive call

### 🔹 Print List Activity
- ❌ Crashed due to `ArrayIndexOutOfBoundsException`
- ✅ Fixed loop by removing `+1` or using `for (word in words)`

### 🔹 Favorite Number Activity
- ❌ Crashed from forced null value on non-null `Int`
- ✅ Removed `!!`, made it nullable or initialized to valid number

---

## 🧠 What I Learned

- How to read Android stack traces (e.g. `ClassCastException`, `NullPointerException`)
- Safe Kotlin casting and type conversion
- Importance of context when using `Intent`
- Debugging recursion and layout logic

---



---

## 🗂 Folder Structure

This project lives inside the `/week2` directory:


# Week 2 – Kotlin Debug-a-thon 🔍

This project is part of the **CodePath AND-101** course — Week 2 assignment.  
The goal of this project was to **debug and fix a broken Kotlin Android app** through hands-on practice.

---

## ✅ Fixed Features

### 🔹 Hello World Activity
- ❌ Crashed due to `ClassCastException`
- ✅ Fixed by replacing `404 as Context` with `this`

### 🔹 Number Sum Activity
- ❌ Crashed due to unsafe cast from `String` to `Int`
- ✅ Used `"2".toInt()` for safe parsing

### 🔹 Current Day Activity
- ❌ Crashed due to `Resources$NotFoundException`
- ✅ Converted `Int` to `String` before assigning to TextView

### 🔹 Random Color Activity
- ❌ Caused infinite recursion in `getRandomColor()`
- ✅ Removed recursive call

### 🔹 Print List Activity
- ❌ Crashed due to `ArrayIndexOutOfBoundsException`
- ✅ Fixed loop by removing `+1` or using `for (word in words)`

### 🔹 Favorite Number Activity
- ❌ Crashed from forced null value on non-null `Int`
- ✅ Removed `!!`, made it nullable or initialized to valid number

---

## 🧠 What I Learned

- How to read Android stack traces (e.g. `ClassCastException`, `NullPointerException`)
- Safe Kotlin casting and type conversion
- Importance of context when using `Intent`
- Debugging recursion and layout logic

---


---

## 🗂 Folder Structure

This project lives inside the `/week2` directory:
