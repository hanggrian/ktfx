package ktfx.controls

import io.github.hendraanggrian.ktfx.test.initToolkit
import javafx.animation.FadeTransition
import javafx.animation.FillTransition
import javafx.scene.control.Label
import javafx.scene.shape.Rectangle
import ktfx.time.ms
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnimationsTest {

    @BeforeTest fun start() = initToolkit()

    @Test fun fadeTransition() {
        val node = Label()
        val transition = node.fadeTransition { }
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun fillTransition() {
        val shape = Rectangle()
        val transition = shape.fillTransition { }
        assertEquals(shape, transition.shape)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun pathTransition() {
        val node = Label()
        val transition = node.pathTransition { }
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun rotateTransition() {
        val node = Label()
        val transition = node.rotateTransition { }
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun scaleTransition() {
        val node = Label()
        val transition = node.scaleTransition { }
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun strokeTransition() {
        val shape = Rectangle()
        val transition = shape.strokeTransition { }
        assertEquals(shape, transition.shape)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun translateTransition() {
        val node = Label()
        val transition = node.translateTransition { }
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test fun parallelTransition() {
        val node = Label()
        val transition = node.parallelTransition {
            fade { }
        }
        assertEquals(node, transition.node)
        assertTrue(transition.children.first() is FadeTransition)
    }

    @Test fun shapeParallelTransition() {
        val shape = Rectangle()
        val transition = shape.shapeParallelTransition {
            fill { }
        }
        assertEquals(shape, transition.node)
        assertTrue(transition.children.first() is FillTransition)
    }

    @Test fun sequentialTransition() {
        val node = Label()
        val transition = node.sequentialTransition {
            fade { }
        }
        assertEquals(node, transition.node)
        assertTrue(transition.children.first() is FadeTransition)
    }

    @Test fun shapeSequentialTransition() {
        val shape = Rectangle()
        val transition = shape.shapeSequentialTransition {
            fill { }
        }
        assertEquals(shape, transition.node)
        assertTrue(transition.children.first() is FillTransition)
    }
}
