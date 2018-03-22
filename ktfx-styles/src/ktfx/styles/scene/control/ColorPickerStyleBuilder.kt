package ktfx.styles

class ColorPickerStyleBuilder : ControlStyleBuilder() {

    var colorLabelVisible: Boolean by map
}

inline fun colorPickerStyle(builder: ColorPickerStyleBuilder .() -> Unit): String =
    ColorPickerStyleBuilder().apply(builder).toString()