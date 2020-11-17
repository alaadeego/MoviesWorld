 
<h1 align="center">Movies World</h1></br>

<p align="center">  
A demo Movie app  based on MVVM architecture.<br>
  adding more feartures in progress.
</p>
</br>

### Building the app

- Open local.properties in the root directory.
- Add your TMDB API key as follows
- TMDB_API_KEY=ADD_YOUR_API_KEY_HERE
- Run the app.

## Tech stack & Open-source libraries

- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
 for asynchronous.
- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Navigation Component - Navigate between app's destinations
  - View Binding - write code that interacts with views more easily
- Architecture
  - MVVM Architecture (View - ViewModel - Model)
  - Repository pattern
  - [Koin](https://github.com/InsertKoinIO/koin) - dependency injection
- Material Design & Animations ---> soon 
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor, logging and mocking web server
- [Picasso](https://square.github.io/picasso/) - loading images
- [Timber](https://github.com/JakeWharton/timber) - logging

## Unit Testing Frameworks

- soon 

## Screenshots
<p align="center">
<img src="/images/image1.png" width="32%"/>

</p>
