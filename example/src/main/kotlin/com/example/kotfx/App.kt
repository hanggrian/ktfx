package com.example.kotfx

import javafx.application.Application
import javafx.stage.Stage
import kotfx.dialogs.infoAlert
import kotfx.layouts.controls.button
import kotfx.layouts.controls.label
import kotfx.layouts.gridPane
import kotfx.properties.asMutableProperty
import kotfx.properties.bind
import kotfx.toScene

class App : Application() {

    private val valueProperty = 0L.asMutableProperty()

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
                    valueProperty.set("${valueProperty.get()}1".toLong())
                }
            } row 1 col 0
            button("2") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}2".toLong())
                }
            } row 1 col 1
            button("3") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}3".toLong())
                }
            } row 1 col 2

            button("4") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}4".toLong())
                }
            } row 2 col 0
            button("5") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}5".toLong())
                }
            } row 2 col 1
            button("6") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}6".toLong())
                }
            } row 2 col 2

            button("7") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}7".toLong())
                }
            } row 3 col 0
            button("8") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}8".toLong())
                }
            } row 3 col 1
            button("9") {
                forceSize(40)
                setOnAction {
                    valueProperty.set("${valueProperty.get()}9".toLong())
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
                    infoAlert(":(") {
                        contentText = "Not yet supported"
                    }.showAndWait()
                }
            } row 4 col 2

            button("C") {
                forceSize(80, 40)
                isCancelButton = true
                setOnAction {
                    valueProperty.set(0)
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
}