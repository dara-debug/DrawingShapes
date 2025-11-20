# DrawingShapes

A simple JavaFX application that generates colorful shapes and patterns on a canvas. Each run produces a different visual output, including concentric shapes, randomly positioned circles, rectangles, and polygons.

---

## Features

* Randomly draws shapes or concentric patterns.
* Multiple color palettes (vibrant, soft, earthy).
* Continuous animation updating every 0.5 seconds.
* Fully customizable canvas size.

---

## Requirements

* Java JDK 17+ (or newer)
* JavaFX SDK 17+ (or equivalent OpenJFX modules)
* Operating System: Windows, macOS, or Linux

> Note: To compile or create an executable (.exe), you will need the JavaFX `jmods` folder or equivalent modules for your JDK. This allows `jpackage` to bundle JavaFX correctly into the installer.

---

## Setup & Running

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/DrawingShapes.git
cd DrawingShapes
```

### 2. Compile the project

Replace `/path/to/javafx-sdk/lib` with the path to your JavaFX SDK `lib` folder (or equivalent OpenJFX modules):

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out ./DrawingShapes.java
```

### 3. Run the application

```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp out DrawingShapes
```

---

## Creating an Executable (.exe) on Windows

To make a distributable `.exe` file, use `jpackage` (included in JDK 17+):

```bash
jpackage \
  --name DrawingShapes \
  --input out/ \
  --main-jar DrawingShapes.jar \
  --module-path /path/to/javafx-sdk/jmods \
  --add-modules javafx.controls,javafx.fxml \
  --win-installer
```

* This will generate a Windows installer (`.exe`) or `.msi` in the current folder.
* You can optionally add an icon using `--icon path/to/icon.ico`.
* Make sure the `jmods` folder (or equivalent modules) is available for packaging JavaFX correctly.

---

## Usage

1. Launch the application (from JAR or installed `.exe`).
2. The window will display an animated canvas.
3. Observe random shapes and concentric patterns being drawn continuously.
4. Modify `DrawingShapes.java` to customize colors, sizes, or patterns.

---

## Notes

* For best results, keep your JavaFX SDK version compatible with your JDK version.
* The animation refresh rate is set to **0.5 seconds** but can be modified in `Timeline`.
* Large generated files like `/output/` are ignored in Git to keep the repository lightweight.
* When packaging the application with `jpackage`, ensure you have the JavaFX `jmods` folder (or equivalent modules) so the executable includes all required JavaFX components.
