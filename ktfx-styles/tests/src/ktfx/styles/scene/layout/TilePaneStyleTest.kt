package ktfx.styles.scene.layout

import javafx.geometry.Orientation.VERTICAL
import javafx.geometry.Pos.BOTTOM_LEFT
import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.layout.TilePane
import ktfx.styles.NodeTest
import ktfx.styles.tilePaneStyle
import kotlin.test.assertEquals

class TilePaneStyleTest : NodeTest<TilePane>() {

    override fun newInstance() = TilePane()

    override val style: String
        get() = tilePaneStyle {
            orientation = VERTICAL
            prefRows = 3
            prefColumns = 2
            prefTileWidth = 50
            prefTileHeight = 25
            hgap = 10
            vgap = 20
            alignment = TOP_RIGHT
            tileAlignment = BOTTOM_LEFT
        }

    override fun TilePane.assertion() {
        assertEquals(orientation, VERTICAL)
        assertEquals(prefRows, 3)
        assertEquals(prefColumns, 2)
        assertEquals(prefTileWidth, 50.0)
        assertEquals(prefTileHeight, 25.0)
        assertEquals(hgap, 10.0)
        assertEquals(vgap, 20.0)
        assertEquals(alignment, TOP_RIGHT)
        assertEquals(tileAlignment, BOTTOM_LEFT)
    }
}