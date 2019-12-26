package ktfx.jfoenix.controls

import javafx.scene.Node
import javafx.scene.control.Label
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test

class JFXDepthManagerTest {
    private lateinit var node: Node

    @BeforeTest fun start() {
        initToolkit()
        node = Label("Hello world")
    }

    @Test fun depth() {
        node.depth = 1
    }

    @Test fun popDepth() {
        node.popDepth()
    }
}