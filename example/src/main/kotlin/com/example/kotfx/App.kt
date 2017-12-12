package com.example.kotfx

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.stage.Stage
import kotfx.dialogs.infoAlert
import kotfx.layouts.anchorPane
import kotfx.layouts.controls.button
import kotfx.layouts.controls.label
import kotfx.layouts.controls.textField
import kotfx.layouts.vBox

class App : Application() {

    companion object {
        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(anchorPane {
            vBox {
                padding = Insets(20.0)
                label("Try me, bitch.")
                val field = textField()
                button("Try") {
                    setOnAction {
                        infoAlert(field.text).show()
                    }
                }
            }
        })
        primaryStage.show()
    }
}