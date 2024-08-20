package ktfx.controlsfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.Region
import org.controlsfx.tools.Borders
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BordersTest {
    lateinit var label: Label

    @BeforeTest
    fun start() {
        initToolkit()
        label = Label()
    }

    @Test
    fun wrapBorders() {
        val wrappedLabel =
            label.wrapBorders {
                empty {}
                etched {}
                line {}
                addBorder(MyBorder())
            } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }

    @Test
    fun emptyBorder() {
        val wrappedLabel1 = label.wrapEmptyBorder { padding = 5.0 } as Region
        wrappedLabel1.border.strokes.single().let {
            assertEquals(5.0, it.widths.top)
            assertEquals(5.0, it.widths.right)
            assertEquals(5.0, it.widths.bottom)
            assertEquals(5.0, it.widths.left)
        }

        val wrappedLabel2 = label.wrapEmptyBorder { padding(10.0, 15.0, 20.0, 25.0) } as Region
        wrappedLabel2.border.strokes.single().let {
            assertEquals(10.0, it.widths.top)
            assertEquals(15.0, it.widths.right)
            assertEquals(20.0, it.widths.bottom)
            assertEquals(25.0, it.widths.left)
        }

        val wrappedLabel3 = label.wrapEmptyBorder { topPadding = 30.0 } as Region
        assertEquals(30.0, wrappedLabel3.border.strokes.single().widths.top)

        val wrappedLabel4 = label.wrapEmptyBorder { rightPadding = 35.0 } as Region
        assertEquals(35.0, wrappedLabel4.border.strokes.single().widths.right)

        val wrappedLabel5 = label.wrapEmptyBorder { bottomPadding = 40.0 } as Region
        assertEquals(40.0, wrappedLabel5.border.strokes.single().widths.bottom)

        val wrappedLabel6 = label.wrapEmptyBorder { leftPadding = 45.0 } as Region
        assertEquals(45.0, wrappedLabel6.border.strokes.single().widths.left)
    }

    @Test
    fun etchedBorder() {
        val wrappedLabel = label.wrapEtchedBorder { title = "Hello world" } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }

    @Test
    fun lineBorder() {
        val wrappedLabel = label.wrapLineBorder { title = "Hello world" } as Region
        assertEquals(1, wrappedLabel.border.strokes.size)
    }

    @Test
    fun outerPadding() {
        val wrappedLabel = label.wrapLineBorder { outerPadding = 1.0 } as Region
        wrappedLabel.border.strokes.single().widths.let {
            assertEquals(1.0, it.top)
            assertEquals(1.0, it.right)
            assertEquals(1.0, it.bottom)
            assertEquals(1.0, it.left)
        }
    }

    @Test
    fun outerTopPadding() {
        val wrappedLabel = label.wrapLineBorder { outerTopPadding = 2.0 } as Region
        assertEquals(2.0, wrappedLabel.border.strokes.single().widths.top)
    }

    @Test
    fun outerRightPadding() {
        val wrappedLabel = label.wrapLineBorder { outerRightPadding = 3.0 } as Region
        assertEquals(3.0, wrappedLabel.border.strokes.single().widths.right)
    }

    @Test
    fun outerBottomPadding() {
        val wrappedLabel = label.wrapLineBorder { outerBottomPadding = 4.0 } as Region
        assertEquals(4.0, wrappedLabel.border.strokes.single().widths.bottom)
    }

    @Test
    fun outerLeftPadding() {
        val wrappedLabel = label.wrapLineBorder { outerLeftPadding = 5.0 } as Region
        assertEquals(5.0, wrappedLabel.border.strokes.single().widths.left)
    }

    class MyBorder : Borders.Border {
        override fun wrap(p0: Node): Node = p0
    }
}
