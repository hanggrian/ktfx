package com.example.kotfx

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.stage.Stage
import kotfx.layouts.anchorPane
import kotfx.layouts.controls.button
import kotfx.layouts.vBox

class App : Application() {

    companion object {
        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(anchorPane {
            vBox {
                padding = Insets(20.0)
                button("you") {
                    onAction {
                    }
                }
                button("motherfucker") {
                    onAction {
                    }
                } topMargin 20.0
            }
        })
        primaryStage.show()
    }
}