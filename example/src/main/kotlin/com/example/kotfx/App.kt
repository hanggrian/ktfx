package com.example.kotfx

import javafx.application.Application
import javafx.stage.Stage
import kotfx.layouts.controls.button
import kotfx.layouts.controls.label
import kotfx.layouts.gridPane
import kotfx.layouts.toScene

class App : Application() {

    companion object {
        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.scene = gridPane {
            padding(20)

            label("Animations") row 0 col 0
            label("Interpolators, Timelines, and Transitions.") row 1 col 0
            button("Try") row 0 col 1 rowSpan 2

            label("Bindings") row 2 col 0
            label("True power of JavaFX.") row 3 col 0
            button("Try") row 2 col 1 rowSpan 2
        }.toScene()
        primaryStage.show()
    }
}