package ktfx.styles

class ColorPickerStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var colorLabelVisible: Boolean by map
}

inline fun colorPickerStyle(
    prettyPrint: Boolean = false,
    builder: ColorPickerStyleBuilder .() -> Unit
): String = ColorPickerStyleBuilder(prettyPrint).apply(builder).toString()