package ktfx.controlsfx.controls

import javafx.scene.control.Label
import javafx.scene.layout.Region
import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BordersTest {

    @BeforeTest fun start() = initToolkit()

    @Test fun emptyBorder() {
        val label = Label()
        assertNull(label.border)

        val wrappedLabel = Label().wrapBorders { empty { padding(1.0, 2.0, 3.0, 4.0) } } as Region
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

        val wrappedLabel = Label().wrapBorders { etched { title = "Hello world" } } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }

    @Test fun lineBorder() {
        val label = Label()
        assertNull(label.border)

        val wrappedLabel = Label().wrapBorders { line { title = "Hello world" } } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }
}