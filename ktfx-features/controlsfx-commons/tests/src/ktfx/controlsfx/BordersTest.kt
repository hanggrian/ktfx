package ktfx.controlsfx

import javafx.scene.control.Label
import javafx.scene.layout.Region
import ktfx.testing.ToolkitTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BordersTest : ToolkitTest {

    @Test fun emptyBorder() {
        val label = Label()
        assertNull(label.border)

        val wrappedLabel = Label().wrapBorders { emptyBorder { padding(1.0, 2.0, 3.0, 4.0) } } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)

        val stroke = wrappedLabel.border.strokes.first()
        assertEquals(1.0, stroke.widths.top)
        assertEquals(2.0, stroke.widths.right)
        assertEquals(3.0, stroke.widths.bottom)
        assertEquals(4.0, stroke.widths.left)
    }

    @Test fun etchedBorder() {
        val label = Label()
        assertNull(label.border)

        val wrappedLabel = Label().wrapBorders { etchedBorder { title = "Hello world" } } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }

    @Test fun lineBorder() {
        val label = Label()
        assertNull(label.border)

        val wrappedLabel = Label().wrapBorders { lineBorder { title = "Hello world" } } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }
}