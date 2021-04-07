package com.hendraanggrian.ktfx.test

import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.stage.Stage

fun Stage.testScene(subject: String): Scene {
    scene = Scene(VBox(
        10.0,
        Label("Currently testing"),
        Label(subject).apply { font = Font.font("System", FontWeight.BLACK, 24.0) }
    ).apply { padding = Insets(20.0) })
    show()
    return scene
}

inline fun <reified T> Stage.testScene() = testScene(T::class.java.simpleName)