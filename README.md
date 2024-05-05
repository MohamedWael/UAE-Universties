# UAE Universities - Android Application

This project is an Android application developed as part of an assignment. The application is named **UAE Universities** and is available on GitHub. It is built using **Kotlin** and follows the **Model-View-Intent (MVI)** architectural pattern. The application also uses **Clean Architecture** principles to separate concerns and make the code more maintainable and testable.

## Key Technologies and Libraries

- **MVI (Model-View-Intent)**: This project uses the MVI pattern, which works exceptionally well with Kotlin Coroutines and Flow for managing state in a predictable way.

- **Clean Architecture**: The codebase follows Clean Architecture principles, separating the code into distinct layers with defined responsibilities. This helps in separation of concerns and making the code more maintainable.

- **Navigation Component**: The Navigation Component from Jetpack is used to simplify the implementation of navigation in the app, including the back stack and passing data between destinations.

- **Room Database**: Room persistence library, which is part of the Android Jetpack, is used for data storage. Room provides an abstraction layer over SQLite and allows for more robust database access while harnessing the full power of SQLite.

- **Dagger2**: Dagger2 is used for dependency injection, which makes the codebase more scalable and the dependencies between components more visible and manageable.

- **Kotlin Coroutines**: The project uses Kotlin Coroutines for handling background tasks. Coroutines simplify asynchronous programming and make the code more readable and straightforward.

## Project Structure

The project is structured into three primary layers following Clean Architecture:

1. **Presentation Layer**: This layer contains the UI code, including Activities, Fragments, and Views. It also includes the ViewModel classes, which act as a bridge between the UI and the domain layer.

2. **Domain Layer**: This layer contains all the use cases of the application. Each use case represents a single action that the user can perform in the app.

3. **Data Layer**: This layer handles data retrieval and storage. It includes the code for accessing the database, network, or any other data sources.

## Running the Application

To run the application, you need to have Android Studio installed. Open the project in Android Studio and run it on an emulator or a real device.

## Contributions

Contributions are welcome. Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
