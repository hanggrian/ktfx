package ktfx.styles

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import ktfx.application.later
import ktfx.test.AppTest
import org.junit.Test

abstract class NodeTest<T : Node> : AppTest() {

    abstract fun newInstance(): T

    abstract val style: String

    abstract fun T.assertion()

    private lateinit var node: T

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
        runBlocking {
            delay(1000)
            later { node.assertion() }
        }
    }
}