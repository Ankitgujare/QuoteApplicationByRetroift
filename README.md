# Retrofit Implementation with Jetpack Compose

This project demonstrates how to use Retrofit with Jetpack Compose to fetch and display data from a REST API in a LazyColumn.

## Overview

The application fetches quotes from the DummyJSON API and displays them in a scrollable list using Jetpack Compose's LazyColumn. Instead of using a ViewModel, we've implemented a singleton pattern for data management.

## Architecture

### Components

1. **Data Layer**
   - `Quote.kt` - Data class representing a single quote
   - `Quotes.kt` - Data class representing the response from the API
   - `Retrofitinstance.kt` - Singleton object that creates and provides the Retrofit instance
   - `QuoteRepository.kt` - Singleton repository for fetching and caching quote data

2. **Domain Layer**
   - `TodoApi.kt` - Interface defining the API endpoints

3. **UI Layer**
   - `MainActivity.kt` - Contains composables for displaying the UI
     - `QuoteListScreen` - Main screen that fetches and displays quotes
     - `QuoteItem` - Individual item composable for each quote

## How It Works

### 1. Network Setup
The [Retrofitinstance](file:///d:/All%20about%20programing/RetrofitImplementation/app/src/main/java/com/example/retrofitimplementation/data/remote/Retrofitinstance.kt#L8-L17) object creates a singleton Retrofit instance with:
- Base URL: https://dummyjson.com
- Gson converter factory for JSON serialization/deserialization

### 2. API Definition
The [TodoApi](file:///d:/All%20about%20programing/RetrofitImplementation/app/src/main/java/com/example/retrofitimplementation/domain/repository/TodoApi.kt#L7-L11) interface defines the endpoint:
```kotlin
@GET("/quotes")
suspend fun getQuotes(): Response<Quotes>
```

### 3. Data Repository
The [QuoteRepository](file:///d:/All%20about%20programing/RetrofitImplementation/app/src/main/java/com/example/retrofitimplementation/data/repository/QuoteRepository.kt#L9-L29) singleton handles:
- Making network requests using Retrofit
- Caching the results
- Error handling
- Thread management with coroutines

### 4. UI Implementation
In [MainActivity.kt](file:///d:/All%20about%20programing/RetrofitImplementation/app/src/main/java/com/example/retrofitimplementation/MainActivity.kt):
- `QuoteListScreen` composable manages the state and fetches data
- `LaunchedEffect` triggers the API call when the screen is displayed
- `LazyColumn` efficiently displays the list of quotes
- `QuoteItem` displays individual quotes with proper styling

## Key Features

- **Singleton Pattern**: Used for both Retrofit instance and Repository
- **Coroutines**: Asynchronous network calls without blocking the UI
- **Error Handling**: Graceful handling of network failures
- **Loading State**: Shows a progress indicator while fetching data
- **Efficient Rendering**: LazyColumn only renders visible items
- **Material Design**: Uses Material 3 components for a modern UI

## Dependencies

- Retrofit 2.9.0
- Gson Converter 2.9.0
- Kotlin Coroutines
- Jetpack Compose

## How to Run

1. Clone the repository
2. Open in Android Studio
3. Build and run the application

The app will automatically fetch quotes from the API and display them in a scrollable list.
