package com.example.kotfx

import javafx.application.Application
import javafx.scene.control.Label
import javafx.stage.Stage
import kotfx.controls.button
import kotfx.controls.label
import kotfx.dialogs.infoAlert
import kotfx.layouts.gridPane
import kotfx.properties.asMutableProperty
import kotfx.properties.bind
import kotfx.toScene

class App : Application() {

    private val valueProperty = 0L.asMutableProperty()
    private var heldValue: Long? = null

    companion object {
        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.scene = gridPane {
            label("") {
                forceHeight(40)
                paddingLeft(20)
                paddingRight(20)
                textProperty() bind valueProperty.asString()

            } row 0 col 0 colSpan 5 fillWidth true

            button("1") {
                forceSize(40)
                setOnAction {
                    text("1")
                }
            } row 1 col 0
            button("2") {
                forceSize(40)
                setOnAction {
                    text("2")
                }
            } row 1 col 1
            button("3") {
                forceSize(40)
                setOnAction {
                    text("3")
                }
            } row 1 col 2

            button("4") {
                forceSize(40)
                setOnAction {
                    text("4")
                }
            } row 2 col 0
            button("5") {
                forceSize(40)
                setOnAction {
                    text("5")
                }
            } row 2 col 1
            button("6") {
                forceSize(40)
                setOnAction {
                    text("6")
                }
            } row 2 col 2

            button("7") {
                forceSize(40)
                setOnAction {
                    text("7")
                }
            } row 3 col 0
            button("8") {
                forceSize(40)
                setOnAction {
                    text("8")
                }
            } row 3 col 1
            button("9") {
                forceSize(40)
                setOnAction {
                    text("9")
                }
            } row 3 col 2

            button("0") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}0".toLong())
                }
            } row 4 col 0
            button("00") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}00".toLong())
                }
            } row 4 col 1
            button(".") {
                forceSize(40)
                setOnAction {
                    infoAlert("Not yet supported.") {
                        title(":(")
                        expandableContent(Label("But a real calculator instead."))
                        expand(true)
                    }.showAndWait()
                }
            } row 4 col 2

            button("C") {
                forceSize(80, 40)
                isCancelButton = true
                setOnAction {
                    valueProperty.set(0)
                    heldValue = null
                }
            } row 1 col 3 colSpan 2
            button("*") {
                forceSize(40)
            } row 2 col 3
            button("/") {
                forceSize(40)
            } row 2 col 4
            button("+") {
                forceSize(40, 80)
                setOnAction {
                    when (heldValue) {
                        null -> {
                            heldValue = valueProperty.get()
                            valueProperty.set(0)
                        }
                        else -> {
                            valueProperty.set(valueProperty.get() + heldValue!!)
                            heldValue = null
                        }
                    }
                }

            } row 3 col 3 rowSpan 2
            button("-") {
                forceSize(40)
            } row 3 col 4
            button("=") {
                forceSize(40)
                isDefaultButton = true
            } row 4 col 4
        }.toScene()
        primaryStage.show()
    }

    fun text(text: String) = valueProperty.set((if (heldValue == null) "${valueProperty.get()}$text" else text).toLong())
}