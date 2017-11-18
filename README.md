kotfx
=====
Lightweight library full of Kotlin extension functions for JavaFX.

Bindings
--------
JavaFX bindings has easy fluent API, here's a button that disables itself if text field is empty.
```java
button.disableProperty().bind(textField.textProperty().isEmpty());
```

As it gets more complicated, its syntax can get messy. Here's a button for password and confirm password field.
```java
button.disableProperty().bind(passwordField.textProperty().isEmpty()
    .or(passwordConfirmField.textProperty().isEmpty())
    .or(passwordField.textProperty().length().lessThan(4))
    .or(passwordConfirmField.textProperty().length().lessThan(4))
    .or(passwordField.textProperty().isNotEqualTo(passwordConfirmField.textProperty())));
```

`kotfx.bindings` simplifies the process using kotlin infix and operator functions.
```kotlin
button.disableProperty().bind(passwordField.textProperty().isEmpty
    or passwordConfirmField.textProperty().isEmpty
    or (passwordField.textProperty().length() lessEq 4)
    or (passwordConfirmField.textProperty().length() lessEq 4)
    or (passwordField.textProperty() neq passwordConfirmField.textProperty()))
```

Collections
-----------
In JavaFX, collections are wrapped into observable version of themselves.
`FXCollections` provides static functions to create new or convert existing into observable collections,
`collections` package aims to extend those functions with Kotlin's extension functions.

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

Dialogs
-------
Dialogs that are most often used in JavaFX are: `Dialog`, `ChoiceDialog`, `TextInputDialog`, and `Alert`.

```kotlin
// show an alert
alert("Here's an alert")

// show a confirmation alert and wait for input
confirmAlert("Are you sure?") { buttonType ->
    if (buttonType == ButtonType.BUTTON_OK) {
        // do something
    }
}

// there is also infoAlert, warningAlert, and errorAlert

// custom init a text input dialog
inputDialog({
    title = "Input"
    contentText = "Enter something:"
    editor.promptText = "Hint"
}) { result ->
    // do something
}

// a choice dialog
choiceDialog(defaultItem, items) { item ->
    // do something
}

// show a custom dialog
dialog({
    title = "Custom dialog"
    dialogPane.content = ...
})
```

Download
--------
```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.hendraanggrian:kotfx:0.6'
}
```

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