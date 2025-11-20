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
* Operating System: Windows, macOS, or Linux

> Note: To compile, run, or create an executable (.exe), you will need both the **JavaFX SDK** and **JavaFX jmods** for the same JDK version. This allows `jpackage` to bundle JavaFX correctly into the installer.

---

## Installing JavaFX SDK and jmods

To run and package this project, you need **both the JavaFX SDK and the JavaFX jmods** for the **same JDK version**:

1. **Download JavaFX SDK** (for compiling and running the application):

   * Contains the `lib` folder needed to compile and run JavaFX programs.
   * [GluonHQ JavaFX SDK Downloads](https://gluonhq.com/products/javafx/)

2. **Download JavaFX jmods** (for creating executables with `jpackage`):

   * Contains the `jmods` folder needed to bundle JavaFX into a packaged installer.
   * [GluonHQ JavaFX jmods Downloads](https://gluonhq.com/products/javafx/)

> ⚠️ Make sure both downloads match your **JDK version** (e.g., JDK 17 → JavaFX 17 SDK and jmods).

3. **Unpack the files** somewhere on your computer, e.g.:

   * SDK: `C:\javafx-sdk-21\` → use the `lib` folder for compilation and running
   * jmods: `C:\javafx-jmods-21\` → use the `jmods` folder for `jpackage`

4. **Paths in commands**:

   * Compile/run: `--module-path /path/to/javafx-sdk/lib`
   * Package with jpackage: `--module-path /path/to/javafx-jmods`

---

## Setup & Running

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/DrawingShapes.git
cd DrawingShapes
```

### 2. Compile the project

Replace `/path/to/javafx-sdk/lib` with the path to your JavaFX SDK `lib` folder:

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out ./DrawingShapes.java
```

### 3. Create a JAR file

Package the compiled classes into a JAR in the `out/` folder:

```bash
jar --create -m Manifest.txt --file out/DrawingShapes.jar -C out/ .
```

> This JAR will be used later for running or packaging with `jpackage`.

### 4. Run the application

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
  --module-path /path/to/javafx-jmods \
  --add-modules javafx.controls,javafx.fxml \
  --type msi \
  --win-shortcut \
  --win-menu \
  --win-per-user-install \
  --win-dir-chooser
```

One line:

```bash
jpackage --name DrawingShapes --input out/ --main-jar DrawingShapes.jar --module-path C:\openjfx-21.0.9_windows-x64_bin-jmods\javafx-jmods-21.0.9 --add-modules javafx.controls,javafx.fxml --type msi --win-shortcut --win-menu --win-per-user-install --win-dir-chooser
```

> Don’t forget to replace `/path/to/javafx-jmods` with the path to your JavaFX jmods folder.

* This will generate a Windows installer (`.exe`) or `.msi` in the current folder.
* You can optionally add an icon using `--icon path/to/icon.ico`.
* Make sure the `jmods` folder is available for packaging JavaFX correctly.

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
