[![download](https://api.bintray.com/packages/hendraanggrian/ktfx/ktfx/images/download.svg)](https://bintray.com/hendraanggrian/ktfx/ktfx/_latestVersion)
[![build](https://travis-ci.com/hendraanggrian/ktfx.svg)](https://travis-ci.com/hendraanggrian/ktfx)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![license](https://img.shields.io/github/license/hendraanggrian/ktfx)](http://www.apache.org/licenses/LICENSE-2.0)

KtFX
====
Written in spirit of [anko], it aims to make JavaFX app development less painful with the help of Kotlin technologies.
* Full of helpers for common JavaFX operations.
* Write dynamic layout with Kotlin DSL.
* Use coroutines directly from JavaFX API.

[Download](https://github.com/hendraanggrian/ktfx/wiki/Download)
----------
```gradle
repositories {
    jcenter()
}

dependencies {
    // all the main artifacts combined
    compile 'com.hendraanggrian.ktfx:ktfx:$version'

    // or download separately
    compile 'com.hendraanggrian.ktfx:ktfx-commons:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-layouts:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-listeners:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-coroutines:$version'

    // third-party artifacts
    compile 'com.hendraanggrian.ktfx:ktfx-controlsfx:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-jfoenix:$version'
}
```

[Ktfx Commons](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Commons-–-Threads)
--------------
Full of extensions for JavaFX, packaged accordingly. The main goal of core library is not to add any new feature to the existing JavaFX APIs. Below are preview of some of the packages.

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

[Ktfx Layouts](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Layouts)
--------------
Generate JavaFX layouts, controls, shapes, and charts with Kotlin DSL. It's a direct replacement of FXML files.

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

![Layouts demo][demo_layouts]

[Ktfx Listeners](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Listeners)
----------------
Trade common JavaFX listener with Kotlin DSL. Currently includes string converters and table cells.

```kotlin
// string converter
val dateBox = ChoiceBox<Date>()
dateBox.converter {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    fromString {
        dateFormat.parse(it)
    }
    toString {
        dateFormat.format(it)
    }
}

// custom list cell
val personList = ListView<Person>()
personList.cellFactory {
    onUpdateItem { person, empty ->
        if (person != null && !empty) {
            graphic = Button("Do something")
        }
    }
}
```

[Ktfx Coroutines](https://github.com/hendraanggrian/ktfx/wiki/Ktfx-Coroutines)
-----------------
Based on the [kotlinx.coroutines] library, it allows invoking JavaFX `EventHandler` the coroutine way.

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

Third-party
-----------
At the moment, ControlsFX and JFoenix are supported.

[anko]: https://github.com/Kotlin/anko
[kotlinx.coroutines]: https://github.com/Kotlin/kotlinx.coroutines
[releases]: https://github.com/hendraanggrian/ktfx/releases
[TestFX]: https://github.com/TestFX/TestFX
[demo_layouts]: /art/demo_layouts.png
Center]: https://bintray.com/bintray/jcenter
[demo_layouts]: /art/demo_layouts.png
oroutines]: https://github.com/Kotlin/kotlinx.coroutines
[releases]: https://github.com/hendraanggrian/ktfx/releases
[TestFX]: https://github.com/TestFX/TestFX
[demo_layouts]: /art/demo_layouts.png
Center]: https://bintray.com/bintray/jcenter
[demo_layouts]: /art/demo_layouts.png
