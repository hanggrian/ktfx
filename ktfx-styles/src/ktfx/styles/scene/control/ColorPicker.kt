package ktfx.styles

interface ColorPickerStyleBuilder {

    var colorLabelVisible: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _ColorPickerStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint),
    ColorPickerStyleBuilder {
    override var colorLabelVisible: Boolean by map
}

inline fun colorPickerStyle(
    prettyPrint: Boolean = false,
    builder: ColorPickerStyleBuilder .() -> Unit
): String = _ColorPickerStyleBuilder(prettyPrint).apply(builder).toString()