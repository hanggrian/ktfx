package kfx.styles

import javafx.scene.Cursor
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.effect.BlendMode
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

    override fun assertion() {
        //assertEquals(button.blendMode, BlendMode.RED)
        assertEquals(node.cursor, Cursor.CROSSHAIR)
        assertTrue(node.isFocusTraversable)
        assertEquals(node.opacity, 0.5)
        assertEquals(node.rotate, 0.5)
        assertEquals(node.scaleX, 0.5)
        assertEquals(node.scaleY, 0.5)
        assertEquals(node.scaleZ, 0.5)
        assertEquals(node.translateX, 0.5)
        assertEquals(node.translateY, 0.5)
        assertEquals(node.translateZ, 0.5)
        assertFalse(node.isVisible)
    }
}