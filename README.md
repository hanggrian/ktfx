KotFX
=====
Kotlin DSL and extension functions for minimalist JavaFX development.

KotFX consists of several parts:
 * *KotFX Core*: full of helpers for bindings, collections, dialogs, and so on.
 * *KotFX Layout*: write JavaFX layouts dynamically with Kotlin DSL.
 * *KotFX Coroutines*: utilities based on the experimental [kotlinx.coroutines] library.
  
Download
--------
*KotFX Layout* and *KotFX Coroutines* are based on *KotFX Core* library.

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.hendraanggrian:kotfx:0.33'
    compile 'com.hendraanggrian:kotfx-layout:0.33'
    compile 'com.hendraanggrian:kotfx-coroutines:0.33'
}
```

KotFX Core
----------
#### Bindings
`kotfx.bindings` simplifies the process using kotlin infix and operator functions.
```kotlin
button.disableProperty.bind(passwordField.textProperty().isEmpty
    or passwordConfirmField.textProperty().isEmpty
    or (passwordField.textProperty().length() less 4)
    or (passwordConfirmField.textProperty().length() less 4)
    or (passwordField.textProperty() neq passwordConfirmField.textProperty()))
```

#### Collections
In JavaFX, collections are wrapped into observable version of themselves.
`kotfx.collections` provides static functions to create new or convert existing into observable collections,
`kotfx.collections` aims to extend those functions with Kotlin's extension functions.

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

#### Dialogs
Create `Dialog`, `ChoiceDialog`, `TextInputDialog`, and `Alert` with Kotlin DSL.

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
    content = gridPane { }
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

KotFX Layout
------------
Generate JavaFX layouts and controls with Kotlin DSL, no FXML required.
```kotlin
vbox {
    val name = textField()
    button("Say Hello") {
        setOnAction { alert("Hello, ${name.text}!") }
    } marginTop 8
}
```

![Demo][demo_scenedsl]

KotFX Coroutines
----------------
*KotFX Coroutines* is based on the experimental [kotlinx.coroutines] library,
it allows invoking JavaFX listeners the coroutine way:
 * `EventHandler`: button action, window showing, animation finished, etc.
 * `Callback`: list cell factory, table row factory, dialog result converter, etc.
 * `StringConverter`: choice converter, binding `StringProperty` bidirectionally, etc.

License
-------
    Copyright 2017 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
[kotlinx.coroutines]: https://github.com/Kotlin/kotlinx.coroutines
[demo_scenedsl]: /art/demo_scenedsl.png
