@file:Suppress("ClassName")

package ktfx.styles.internal

import javafx.geometry.VPos
import javafx.scene.text.FontPosture
import javafx.scene.text.FontSmoothingType
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import ktfx.styles.TextStyleBuilder

@PublishedApi
internal class _TextStyleBuilder(
    prettyPrint: Boolean
) : _ShapeStyleBuilder(prettyPrint), TextStyleBuilder {
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