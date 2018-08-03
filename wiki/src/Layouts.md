`KtFX Layouts` supports writing dynamic JavaFX layouts with Kotlin DSL.
Due to its complexity, there are instances of class (`LayoutManager`) in this
artifact.

General rules:
 * Classes prefixed with `_` character are marked as internal DSL components.
 * All classes are packaged under `ktfx.layouts`.