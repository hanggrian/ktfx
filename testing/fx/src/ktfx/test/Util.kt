package ktfx.test

import com.sun.javafx.application.PlatformImpl
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage

fun initToolkit() = PlatformImpl.startup { }

fun Stage.testScene(subject: String): Scene {
    scene = Scene(Label("Testing $subject...").apply { padding = Insets(20.0) })
    show()
    return scene
}

inline fun <reified T> Stage.testScene() = testScene(T::class.java.simpleName)