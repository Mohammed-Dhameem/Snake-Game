# Snake Game

Welcome to the Snake Game project! This is a simple but fun game built using Java 21 and JavaFX 25.0.1.

## Project Overview

This project includes:

- Core game logic implemented in Java.
- User interface built with JavaFX.
- The compiled game can be run as a standalone JAR or packaged app.

## Current Project Structure

- The runnable game JAR file is now located in the `Jar` folder as:

  `Jar/SnakeGame.jar`

- All packaging folders (`input`, `SnakeGame` app-image) have been cleaned up for simplicity.

## Prerequisites

- Java Development Kit (JDK) 21 installed.
- JavaFX SDK 25.0.1 (Linux version if using Linux).
- Required native libraries on your system for JavaFX rendering:

  For Linux, install these packages:

sudo apt install libgtk-3-0 libgl1 libglu1-mesa mesa-utils libasound2t64 libgdk-pixbuf2.0-0 libx11-xcb1 libxcomposite1 libxrandr2

text

## Running the Game

Run the game jar with this command:

export PATH_TO_FX=/path/to/javafx-sdk-25.0.1/lib
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.graphics -jar Jar/SnakeGame.jar

text

Replace `/path/to/javafx-sdk-25.0.1/lib` with the actual path where you extracted the JavaFX SDK on your system.

## Troubleshooting

- If the game fails with graphics errors, try software rendering mode:

java --enable-native-access=javafx.graphics --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.graphics -Dprism.order=sw -jar Jar/SnakeGame.jar

text

- On Linux, ensure you are running in a graphical desktop environment and have installed all the required native libraries listed above.

## Notes

- Use matching Java and JavaFX versions for your platform.
- Windows `.exe` packaging requires building on Windows with Windows JavaFX SDK.
- Java 21 and JavaFX 25.0.1 are compatible and used in this project.
- The warnings about "restricted method" are normal on recent JDKs and can be suppressed using the native access flag.

## Contributions and Feedback

Feel free to contribute or report issues via GitHub repository.

---

Enjoy playing and happy coding!
