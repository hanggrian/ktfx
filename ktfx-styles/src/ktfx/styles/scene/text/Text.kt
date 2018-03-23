package ktfx.styles

import javafx.geometry.VPos
import javafx.scene.text.FontPosture
import javafx.scene.text.FontSmoothingType
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment

interface TextStyleBuilder {

    /** Shorthand property for font-size, font-family, font-weight and font-style. */
    @Incubating
    var font: String

    var fontFamily: String

    var fontSize: Number

    var fontStyle: FontPosture

    var fontWeight: FontWeight

    var fontSmoothingType: FontSmoothingType

    var strikethrough: Boolean

    var textAlignment: TextAlignment

    var textOrigin: VPos

    var underline: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _TextStyleBuilder(prettyPrint: Boolean) : _ShapeStyleBuilder(prettyPrint), TextStyleBuilder {
    override var font: String by map
    override var fontFamily: String by map
    override var fontSize: Number by map
    override var fontStyle: FontPosture by map
    override var fontWeight: FontWeight by map
    override var fontSmoothingType: FontSmoothingType by map
    override var strikethrough: Boolean by map
    override var textAlignment: TextAlignment by map
    override var textOrigin: VPos by map
    override var underline: Boolean by map
}

inline fun textStyle(
    prettyPrint: Boolean = false,
    builder: TextStyleBuilder.() -> Unit
): String = _TextStyleBuilder(prettyPrint).apply(builder).toString()