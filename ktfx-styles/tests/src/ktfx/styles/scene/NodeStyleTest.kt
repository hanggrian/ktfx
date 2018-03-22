package ktfx.styles.scene

import javafx.scene.Cursor
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.effect.BlendMode
import ktfx.styles.NodeTest
import ktfx.styles.Visibility
import ktfx.styles.nodeStyle
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NodeStyleTest : NodeTest<Node>() {

    override fun newInstance() = Button("Hello world")

    override val style: String
        get() = nodeStyle {
            blendMode = BlendMode.RED
            cursor = Cursor.CROSSHAIR
            focusTraversable = true
            opacity = 0.5
            rotate = 0.5
            scaleX = 0.5
            scaleY = 0.5
            scaleZ = 0.5
            translateX = 0.5
            translateY = 0.5
            translateZ = 0.5
            visibility = Visibility.HIDDEN
        }

    override fun Node.assertion() {
        //assertEquals(button.blendMode, BlendMode.RED)
        assertEquals(cursor, Cursor.CROSSHAIR)
        assertTrue(isFocusTraversable)
        assertEquals(opacity, 0.5)
        assertEquals(rotate, 0.5)
        assertEquals(scaleX, 0.5)
        assertEquals(scaleY, 0.5)
        assertEquals(scaleZ, 0.5)
        assertEquals(translateX, 0.5)
        assertEquals(translateY, 0.5)
        assertEquals(translateZ, 0.5)
        assertFalse(isVisible)
    }
}