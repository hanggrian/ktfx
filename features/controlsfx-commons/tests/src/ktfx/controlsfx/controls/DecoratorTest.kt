package ktfx.controlsfx.controls

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
import ktfx.test.initToolkit
import org.controlsfx.control.decoration.Decorator
import org.controlsfx.control.decoration.GraphicDecoration
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DecoratorTest {
    private lateinit var node: Node

    @BeforeTest fun start() {
        initToolkit()
        node = Label("Hello world")
    }

    @Test fun addDecoration() {
        val decoration = GraphicDecoration(Button())
        node.addDecoration(decoration)
        assertEquals(1, node.decorations.size)
    }

    @Test fun addDecorations() {
        node.addDecorations(GraphicDecoration(Button()), GraphicDecoration(Hyperlink()))
        assertEquals(2, node.decorations.size)
    }

    @Test fun removeDecoration() {
        val decoration1 = GraphicDecoration(Button())
        val decoration2 = GraphicDecoration(Hyperlink())
        node.addDecorations(decoration1, decoration2)
        node.removeDecoration(decoration1)
        assertEquals(decoration2, node.decorations.single())
    }

    @Test fun clearDecorations() {
        node.addDecorations(GraphicDecoration(Button()), GraphicDecoration(Hyperlink()))
        node.clearDecorations()
        assertNull(Decorator.getDecorations(node))
    }

    @Test fun decorations() {
        node.addDecorations(GraphicDecoration(Button()), GraphicDecoration(Hyperlink()))
        assertEquals(Decorator.getDecorations(node), node.decorations)
    }
}