[![Travis CI](https://img.shields.io/travis/com/hendraanggrian/ktfx)](https://travis-ci.com/github/hendraanggrian/ktfx/)
[![Codecov](https://img.shields.io/codecov/c/github/hendraanggrian/ktfx)](https://codecov.io/gh/hendraanggrian/ktfx/)
[![Maven Central](https://img.shields.io/maven-central/v/com.hendraanggrian.ktfx/ktfx)](https://repo1.maven.org/maven2/com/hendraanggrian/ktfx/ktfx/)
[![Nexus Snapshot](https://img.shields.io/nexus/s/com.hendraanggrian.ktfx/ktfx?server=https%3A%2F%2Fs01.oss.sonatype.org)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/hendraanggrian/ktfx/ktfx/)
[![OpenJDK](https://img.shields.io/badge/jdk-1.8%2B-informational)](https://openjdk.java.net/projects/jdk8/)

# KtFX

Written in spirit of [anko](https://github.com/Kotlin/anko/), it aims to make
JavaFX app development less painful with the help of Kotlin technologies.

- Full of helpers for common JavaFX operations.
- Write dynamic layout with Kotlin DSL.
- Use coroutines directly from JavaFX API.

## [Download](https://github.com/hendraanggrian/ktfx/wiki/Download/)

```gradle
repositories {
    mavenCentral()
}
dependencies {
    // all the main artifacts combined
    compile "com.hendraanggrian.ktfx:ktfx:$version"

    // or download separately
    compile "com.hendraanggrian.ktfx:ktfx-commons:$version"
    compile "com.hendraanggrian.ktfx:ktfx-layouts:$version"
    compile "com.hendraanggrian.ktfx:ktfx-coroutines:$version"

    // third-party artifacts, also available individually
    compile "com.hendraanggrian.ktfx:ktfx-controlsfx:$version"
    compile "com.hendraanggrian.ktfx:ktfx-jfoenix:$version"
}
```

Snapshots of the development version are available in [Sonatype's snapshots repository](https://s01.oss.sonatype.org/content/repositories/snapshots/).

## [Ktfx Commons](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Commons-–-Threads/)

Full of extensions for JavaFX, packaged accordingly. The main goal of core
library is not to add any new feature to the existing JavaFX APIs. Below are
preview of some packages.

### Collections

```kotlin
// create unmodifiable observable collection
val emptyUnmodifiableList = emptyObservableList()
val unmodifiableList = observableListOf(1)

// create modifiable observable collection
val emptyModifiableList = mutableObservableListOf()
val modifiableList = mutableObservableListOf(1, 2, 3)

// convert existing
val list = myList.toObservableList() // or toMutableObservableList() for modifiable version
```

### Bindings

```kotlin
// infix conditional binding
button.disableProperty().bind(firstName.textProperty().isEmpty or lastName.textProperty().isEmpty)

// operator binding for number properties
totalProperty.bind(qtyProperty * priceProperty)

// infix binding for number properties
loginButton.disableProperty().bind(passwordField.textProperty.length() less 4)

// custom binding
label.graphicProperty().bind(stringBindingOf(listView.selectionModel.selectedIndexProperty()) {
    "${listView.selectionModel.selectedIndex} selected"
})
imageView.imageProperty().bind(bindingOf(urlField.textProperty()) {
    Image(urlField.text)
})
```

### Dialogs

```kotlin
// show an alert
alert("Here's an alert").show()

// show a confirmation alert and wait for input
confirmAlert("Are you sure?").showAndWait()

// custom init a text input dialog
inputDialog("Question #1") {
    contentText = "Why does the chicken cross the road?"
    editor.promptText = "Hint"
}.showAndWait()

// a choice dialog
choiceDialog("Pick an item", ImageView("/my/image.png"), items)
    .showAndWait()

// show a custom dialog
dialog<String>("Who's a little piggy?") {
    content = ...
    yesButton()
    noButton()
    customButton("What's a piggy?") {
        // explain what a piggy is
    }
    resultConverter {
        if(it == button1)  "Me" else null
    }
}.showAndWait()
```

## [Ktfx Layouts](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Layouts/)

Generate JavaFX layouts, controls, shapes, and charts with Kotlin DSL. It's a
direct replacement of FXML files.

```kotlin
gridPane {
    gaps = 8
    label("First name") row 0 col 0
    val firstName = textField() row 0 col 1
    label("Last name") row 1 col 0
    val lastName = textField() row 1 col 1
    button("Say hello") {
        onAction {
            infoAlert("Hello, ${firstName.text} ${lastName.text}!")
        }
    } row 2 col 1 hpos HPos.RIGHT
}
```

![Layouts preview.](https://github.com/hendraanggrian/ktfx/raw/assets/preview_layouts.png)

## [Ktfx Coroutines](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Coroutines/)

Based on the [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines)
library, it allows invoking JavaFX `EventHandler` the coroutine way.

```kotlin
button.setOnAction {
    doSomethingInBackground()// might freeze UI
    celebrateCompletion()
}

button.onAction(CommonPool) {
    doSomethingInBackground() // non-blocking in common pool
    launch(FX) {
        celebrateCompletion()
    }
}
```

## Third-party

> Work in progress.
