@file:Suppress("ClassName")

package javafxx.styles.internal

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.paint.Color
import javafxx.styles.FlowPaneStyleBuilder
import javafxx.styles.GridPaneStyleBuilder
import javafxx.styles.HBoxStyleBuilder
import javafxx.styles.RegionStyleBuilder
import javafxx.styles.StackPaneStyleBuilder
import javafxx.styles.TilePaneStyleBuilder
import javafxx.styles.Urls
import javafxx.styles.VBoxStyleBuilder

@PublishedApi
internal class _FlowPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), FlowPaneStyleBuilder {
    override var hgap: Number by map
    override var vgap: Number by map
    override var alignment: Pos by map
    override var columnHalignment: HPos by map
    override var rowValignment: VPos by map
    override var orientation: Orientation by map
}

@PublishedApi
internal class _GridPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), GridPaneStyleBuilder {
    override var hgap: Number by map
    override var vgap: Number by map
    override var alignment: Pos by map
    override var gridLinesVisible: Boolean by map
}

@PublishedApi
internal class _HBoxStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), HBoxStyleBuilder {
    override var spacing: Number by map
    override var alignment: Pos by map
    override var fillHeight: Boolean by map
}

open class _RegionStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), RegionStyleBuilder {
    override var backgroundColor: Color by map
    override var backgroundInsets: Insets by map
    override var backgroundRadius: Insets by map
    override var backgroundImage: Urls by map
    override var backgroundPosition: String by map
    override var backgroundRepeat: String by map
    override var backgroundSize: String by map
    override var borderColor: Color by map
    override var borderInsets: Insets by map
    override var borderRadius: String by map
    override var borderStyle: String by map
    override var borderWidth: Number by map
    override var borderImageSource: Urls by map
    override var borderImageRepeat: String by map
    override var borderImageSlice: String by map
    override var borderImageWidth: Number by map
    override var padding: Insets by map
    override var positionShape: Boolean by map
    override var scaleShape: Boolean by map
    override var shape: String by map
    override var snapToPixel: Boolean by map
    override var backgroundFills: String by map
    override var backgroundImages: String by map
    override var strokeBorders: String by map
    override var imageBorders: String by map
}

@PublishedApi
internal class _StackPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), StackPaneStyleBuilder {
    override var alignment: Pos by map
}

@PublishedApi
internal class _TilePaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), TilePaneStyleBuilder {
    override var orientation: Orientation by map
    override var prefRows: Int by map
    override var prefColumns: Int by map
    override var prefTileWidth: Number by map
    override var prefTileHeight: Number by map
    override var hgap: Number by map
    override var vgap: Number by map
    override var alignment: Pos by map
    override var tileAlignment: Pos by map
}

@PublishedApi
internal class _VBoxStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), VBoxStyleBuilder {
    override var spacing: Number by map
    override var alignment: Pos by map
    override var fillWidth: Boolean by map
}