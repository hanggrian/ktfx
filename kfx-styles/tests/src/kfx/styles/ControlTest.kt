package kfx.styles

import javafx.scene.Scene
import javafx.scene.control.Control
import javafx.stage.Stage
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

abstract class ControlTest<T : Control> : ApplicationTest() {

    abstract fun newInstance(): T

    abstract val style: String

    abstract fun assertion()

    protected lateinit var node: T

    override fun start(stage: Stage) {
        node = newInstance()
        stage.run {
            scene = Scene(node)
            show()
        }
    }

    @Test
    @Suppress("EXPERIMENTAL_FEATURE_WARNING")
    fun style() {
        node.style = style
        node.applyCss()
        node.layout()
        runBlocking {
            delay(500)
            assertion()
        }
    }
}