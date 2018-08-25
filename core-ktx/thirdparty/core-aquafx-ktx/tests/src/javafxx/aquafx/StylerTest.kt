package javafxx.aquafx

import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Control
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import javafxx.test.AppTest

abstract class StylerTest<T : Control> : AppTest() {

    abstract fun creator(): T

    lateinit var control: T

    final override fun start(stage: Stage) {
        control = creator()
        stage.scene = Scene(BorderPane(control).apply { padding = Insets(16.0) })
        stage.show()
    }
}