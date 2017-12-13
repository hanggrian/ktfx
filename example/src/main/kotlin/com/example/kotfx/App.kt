package com.example.kotfx

import javafx.application.Application
import javafx.scene.control.Label
import javafx.scene.text.TextAlignment.RIGHT
import javafx.stage.Stage
import kotfx.bindings.stringBindingOf
import kotfx.controls.button
import kotfx.controls.label
import kotfx.dialogs.dialog
import kotfx.dialogs.leftButton
import kotfx.dialogs.rightButton
import kotfx.layouts.gridPane
import kotfx.layouts.vbox
import kotfx.properties.bind
import kotfx.toScene

class App : Application() {

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    private val operators = arrayOf("+", "-", "/", "*")

    companion object {
        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    override fun start(primaryStage: Stage) {
        primaryStage.scene = gridPane {
            vbox {
                paddingLeft(20)
                paddingRight(20)
                calculationLabel = label("")
                resultLabel = label("") {
                    textAlign(RIGHT)
                    textProperty() bind stringBindingOf(calculationLabel.textProperty()) {
                        calculationLabel.text.split(*operators)
                        "2"
                    }
                }
            } row 0 col 0 colSpan 5 fillWidth true

            button("1") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "1"
                }
            } row 1 col 0
            button("2") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "2"
                }
            } row 1 col 1
            button("3") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "3"
                }
            } row 1 col 2

            button("4") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "4"
                }
            } row 2 col 0
            button("5") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "5"
                }
            } row 2 col 1
            button("6") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "6"
                }
            } row 2 col 2

            button("7") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "7"
                }
            } row 3 col 0
            button("8") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "8"
                }
            } row 3 col 1
            button("9") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "9"
                }
            } row 3 col 2

            button("0") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "0"
                }
            } row 4 col 0
            button("00") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "00"
                }
            } row 4 col 1
            button(".") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "."
                }
            } row 4 col 2

            button("C") {
                forceSize(80, 40)
                cancel(true)
                setOnAction {
                    calculationLabel.text = ""
                }
            } row 1 col 3 colSpan 2
            button("*") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "*"
                }
            } row 2 col 3
            button("/") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "/"
                }
            } row 2 col 4
            button("+") {
                forceSize(40, 80)
                setOnAction {
                    setOnAction {
                        calculationLabel.text += "+"
                    }
                }

            } row 3 col 3 rowSpan 2
            button("-") {
                forceSize(40)
                setOnAction {
                    calculationLabel.text += "-"
                }
            } row 3 col 4
            button("=") {
                forceSize(40)
                default(true)
                setOnAction {

                }
            } row 4 col 4
        }.toScene()
        primaryStage.show()
    }
}