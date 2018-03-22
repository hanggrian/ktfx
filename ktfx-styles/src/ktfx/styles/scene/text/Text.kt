package ktfx.styles

import javafx.geometry.VPos
import javafx.scene.text.FontPosture
import javafx.scene.text.FontSmoothingType
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment

class TextStyleBuilder : ShapeStyleBuilder() {

    /** Shorthand property for font-size, font-family, font-weight and font-style. */
    @Incubating
    var font: String by map

    var fontFamily: String by map

    var fontSize: Number by map

    var fontStyle: FontPosture by map

    var fontWeight: FontWeight by map

    var fontSmoothingType: FontSmoothingType by map

    var strikethrough: Boolean by map

    var textAlignment: TextAlignment by map

    var textOrigin: VPos by map

    var underline: Boolean by map
}

inline fun textStyle(builder: TextStyleBuilder.() -> Unit): String =
    TextStyleBuilder().apply(builder).toString()