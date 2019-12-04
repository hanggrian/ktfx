package ktfx.controls

import javafx.scene.control.Label
import javafx.scene.shape.Rectangle
import ktfx.util.millis
import ktfx.test.ToolkitInitializer
import kotlin.test.Test
import kotlin.test.assertEquals

class NodeTransitionsTest : ToolkitInitializer {

    @Test fun fadeTransition() {
        val node = Label()
        val transition = node.fadeTransition()
        assertEquals(node, transition.node)
        assertEquals(400.millis, transition.duration)
    }

    @Test fun fillTransition() {
        val shape = Rectangle()
        val transition = shape.fillTransition()
        assertEquals(shape, transition.shape)
        assertEquals(400.millis, transition.duration)
    }

    @Test fun pathTransition() {
        val node = Label()
        val transition = node.pathTransition()
        assertEquals(node, transition.node)
        assertEquals(400.millis, transition.duration)
    }

    @Test fun rotateTransition() {
        val node = Label()
        val transition = node.rotateTransition()
        assertEquals(node, transition.node)
        assertEquals(400.millis, transition.duration)
    }

    @Test fun scaleTransition() {
        val node = Label()
        val transition = node.scaleTransition()
        assertEquals(node, transition.node)
        assertEquals(400.millis, transition.duration)
    }

    @Test fun sequentialTransition() {
        val node = Label()
        val transition = node.sequentialTransition()
        assertEquals(node, transition.node)
    }

    @Test fun strokeTransition() {
        val shape = Rectangle()
        val transition = shape.strokeTransition()
        assertEquals(shape, transition.shape)
        assertEquals(400.millis, transition.duration)
    }

    @Test fun translateTransition() {
        val node = Label()
        val transition = node.translateTransition()
        assertEquals(node, transition.node)
        assertEquals(400.millis, transition.duration)
    }
}