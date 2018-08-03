Replace common JavaFX listeners with Kotlin DSL.
Currently supports operations related to `StringConverter` and table cells.

General rules:
 * Classes prefixed with `_` character are marked as internal DSL components.
 * All classes are packaged under `ktfx.listeners`.