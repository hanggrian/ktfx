KFX
===
[Kotlin] extensions for JavaFX app development and more. 
Written in spirit of [android-ktx] and [anko].

Consists of several parts:
 * *KFX Commons*: full of helpers for common JavaFX application logic.
 * *KFX Layout*: dynamic JavaFX layout with Kotlin DSL.
 * *KFX Listeners*: write common JavaFX listeners with Kotlin DSL.
 * *KFX Coroutines*: utilities based on the experimental [kotlinx.coroutines] library.

Download
--------
To download all features, use KFX main library:

```gradle
dependencies {
    compile 'com.hendraanggrian.kfx:kfx:0.1.1'
}
```

Or download separate library if only specific feature is desired:

```gradle
dependencies {
    compile 'com.hendraanggrian.kfx:kfx-commons:0.1.1'
    compile 'com.hendraanggrian.kfx:kfx-layouts:0.1.1'
    compile 'com.hendraanggrian.kfx:kfx-listeners:0.1.1'
    compile 'com.hendraanggrian.kfx:kfx-coroutines:0.1.1'
}
```

All artifacts are hosted on [jcenter].

KFX Commons
-----------
Full of extensions for JavaFX, packaged accordingly.
The main goal of core library is not to add any new feature to the existing JavaFX APIs.
Below are preview of some of the packages.

#### Collections

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

#### Bindings

```kotlin
// infix conditional binding
button.disableProperty.bind(firstName.textProperty().isEmpty or lastName.textProperty().isEmpty)

// operator binding for number properties
totalProperty.bind(qtyProperty * priceProperty)

// infix binding for number properties
loginButton.disableProperty.bind(passwordField.textProperty.length() less 4)

// custom binding
label.graphic().bind(stringBindingOf(listView.selectionModel.selectedIndexProperty()) {
    "${listView.selectionModel.selectedIndex} selected"
})
imageView.imageProperty().bind(bindingOf(urlField) {
    Image(urlField.text)
})
```

#### Dialogs

```kotlin
// show an alert
alert("Here's an alert").show()

// show a confirmation alert and wait for input
confirmAlert("Are you sure?").showAndWait()

// custom init a text input dialog
inputDialog() {
    headerText = "Question #1"
    contentText = "Why does the chicken cross the road?"
    editor.promptText = "Hint"
}.showAndWait()

// a choice dialog
choiceDialog(items, defaultItem) {
    headerText = "Pick an item"
    graphic = ImageView("/my/image.png")
    expandableContent = Label("Just an image")
}.showAndWait()

// show a custom dialog
dialog<String>("Who's a little piggy?") {
    content = ...
    val button1 = yesButton("Me")
    noButton("Not me")
    helpButton("What's a piggy?") {
        // explain what a piggy is
    }
    resultConverter {
        if(it == button1)  "Me" else null  
    }
}.showAndWait()
```

KFX Layouts
-----------
Generate JavaFX layouts and controls with Kotlin DSL, no FXML required.

```kotlin
gridPane {
    gaps = 8
    label("First name") row 0 col 0
    val firstName = textField() row 0 col 1
    label("Last name") row 1 col 0
    val lastName = textField() row 1 col 1
    button("Say hello") {
        setOnAction {
            infoAlert("Hello, ${firstName.text} ${lastName.text}!").show()
        }
    } hpos RIGHT row 2 col 1
}
```

![Layouts demo][demo_layouts]

KFX Listeners
-------------
Trade common JavaFX listener with Kotlin DSL.

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

KFX Coroutines
--------------
Based on the experimental [kotlinx.coroutines] library, it allows invoking JavaFX `EventHandler` the coroutine way.

```kotlin
button.setOnAction {
    doSomethingInBackground() // might freeze UI
    celebrateCompletion()
}

button.onAction(CommonPool) {
    doSomethingInBackground() // non-blocking in common pool
    launch(FX) {
        celebrateCompletion()
    }
}
```

License
-------
    Copyright 2018 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[Kotlin]: https://kotlinlang.org/
[android-ktx]: https://github.com/android/android-ktx
[anko]: https://github.com/Kotlin/anko
[kotlinx.coroutines]: https://github.com/Kotlin/kotlinx.coroutines
[jcenter]: https://bintray.com/hendraanggrian/kfx
[demo_layouts]: /art/demo_layouts.png