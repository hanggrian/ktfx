package com.example.kotfx

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import kotfx.layouts.nodes.button
import kotfx.layouts.vBox

class App : Application() {

    companion object {
        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(vBox {
            button("you") {
                onAction {
                    println("fuck you 1")
                }
            }
            button("motherfucker") {
                onAction {
                    println("fuck you 2")
                }
            }
        })
        primaryStage.show()
    }
}