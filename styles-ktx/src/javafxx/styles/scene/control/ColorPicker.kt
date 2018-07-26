package javafxx.styles

import javafxx.styles.internal._ColorPickerStyleBuilder

interface ColorPickerStyleBuilder {

    var colorLabelVisible: Boolean
}

inline fun colorPickerStyle(
    prettyPrint: Boolean = false,
    builder: ColorPickerStyleBuilder .() -> Unit
): String = _ColorPickerStyleBuilder(prettyPrint).apply(builder).toString()