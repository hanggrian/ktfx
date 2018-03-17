package ktfx.styles

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Control
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

abstract class NodeTest<T : Node> : ApplicationTest() {

    abstract fun newInstance(): T

    abstract val style: String

    abstract fun assertion()

    protected lateinit var node: T

    override fun start(stage: Stage) {
        node = newInstance()
        stage.run {
            scene = Scene(when (node) {
                is Parent -> node as Parent
                else -> Pane(node)
            })
            show()
        }
    }

    @Test
    @Suppress("EXPERIMENTAL_FEATURE_WARNING")
    fun style() {
        node.style = style
        node.applyCss()
        if (node is Control) (node as Control).layout()
        runBlocking {
            delay(500)
            assertion()
        }
    }
}