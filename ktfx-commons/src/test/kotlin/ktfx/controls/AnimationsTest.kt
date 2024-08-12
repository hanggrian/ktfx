package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.animation.FadeTransition
import javafx.animation.FillTransition
import javafx.animation.PathTransition
import javafx.animation.RotateTransition
import javafx.animation.ScaleTransition
import javafx.animation.StrokeTransition
import javafx.animation.TranslateTransition
import javafx.scene.control.Label
import javafx.scene.shape.Rectangle
import ktfx.time.ms
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class AnimationsTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun fadeTransition() {
        val node = Label()
        val transition = node.fadeTransition {}
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun fillTransition() {
        val shape = Rectangle()
        val transition = shape.fillTransition {}
        assertEquals(shape, transition.shape)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun pathTransition() {
        val node = Label()
        val transition = node.pathTransition {}
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun rotateTransition() {
        val node = Label()
        val transition = node.rotateTransition {}
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun scaleTransition() {
        val node = Label()
        val transition = node.scaleTransition {}
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun strokeTransition() {
        val shape = Rectangle()
        val transition = shape.strokeTransition {}
        assertEquals(shape, transition.shape)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun translateTransition() {
        val node = Label()
        val transition = node.translateTransition {}
        assertEquals(node, transition.node)
        assertEquals(400.ms, transition.duration)
    }

    @Test
    fun parallelTransition() {
        val node = Label()
        val transition =
            node.parallelTransition {
                fade {}
            }
        assertEquals(node, transition.node)
        assertIs<FadeTransition>(transition.children.first())
    }

    @Test
    fun shapeParallelTransition() {
        val shape = Rectangle()
        val transition =
            shape.shapeParallelTransition {
                path {}
            }
        assertEquals(shape, transition.node)
        assertIs<PathTransition>(transition.children.first())
    }

    @Test
    fun sequentialTransition() {
        val node = Label()
        val transition =
            node.sequentialTransition {
                rotate {}
                scale {}
                translate {}
            }
        assertEquals(node, transition.node)
        assertIs<RotateTransition>(transition.children[0])
        assertIs<ScaleTransition>(transition.children[1])
        assertIs<TranslateTransition>(transition.children[2])
    }

    @Test
    fun shapeSequentialTransition() {
        val shape = Rectangle()
        val transition =
            shape.shapeSequentialTransition {
                fill {}
                stroke {}
            }
        assertEquals(shape, transition.node)
        assertIs<FillTransition>(transition.children.first())
        assertIs<StrokeTransition>(transition.children.last())
    }
}
