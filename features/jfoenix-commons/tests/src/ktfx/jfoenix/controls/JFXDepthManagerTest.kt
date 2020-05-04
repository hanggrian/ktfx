package ktfx.jfoenix.controls

import com.jfoenix.effects.JFXDepthManager
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JFXDepthManagerTest {
    private lateinit var node: Node

    @BeforeTest fun start() {
        initToolkit()
        node = Label("Hello world")
    }

    @Test fun depth() {
        node.depth = 1
        assertDepth(node, 1)
    }

    @Test fun wrapDepth() {
        node.wrapDepth(2)
        assertDepth(node.parent, 2)
    }

    @Test fun popDepth() {
        node.popDepth()
        val shadow = node.effect as DropShadow
        assertEquals(BlurType.GAUSSIAN, shadow.blurType)
        assertEquals(Color.rgb(0, 0, 0, 0.26), shadow.color)
        assertEquals(5.0, shadow.radius)
        assertEquals(0.05, shadow.spread)
        assertEquals(0.0, shadow.offsetX)
        assertEquals(1.0, shadow.offsetY)
    }

    private fun assertDepth(node: Node, level: Int) {
        val actualShadow = node.effect as DropShadow
        val managedShadow = JFXDepthManager.getShadowAt(level)
        assertEquals(BlurType.GAUSSIAN, actualShadow.blurType)
        assertEquals(managedShadow.color, actualShadow.color)
        assertEquals(managedShadow.radius, actualShadow.radius)
        assertEquals(managedShadow.spread, actualShadow.spread)
        assertEquals(managedShadow.offsetX, actualShadow.offsetX)
        assertEquals(managedShadow.offsetY, actualShadow.offsetY)
    }
}