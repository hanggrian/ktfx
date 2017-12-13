package com.example.kotfx

import javafx.application.Application
import javafx.scene.control.Label
import javafx.scene.text.FontWeight.BOLD
import javafx.stage.Stage
import kotfx.bindings.booleanBindingOf
import kotfx.bindings.stringBindingOf
import kotfx.controls.button
import kotfx.controls.label
import kotfx.dialogs.errorAlert
import kotfx.dialogs.infoAlertWait
import kotfx.layouts.gridPaneOf
import kotfx.layouts.vbox
import kotfx.layouts.vboxOf
import kotfx.properties.bind
import kotfx.toScene

class App : Application() {

    companion object {
        private val OPERATORS = arrayOf("+", "-", "/", "*")

        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    override fun start(primaryStage: Stage) {
        primaryStage.scene = gridPaneOf {
            vbox {
                paddingLeft(20)
                paddingRight(20)
                calculationLabel = label("")
                resultLabel = label("") {
                    textProperty() bind stringBindingOf(calculationLabel.textProperty()) {
                        if (endsWithOperator) "..." else {
                            val operators = calculationLabel.text.split("\\d".toRegex()).filter { it.isNotEmpty() }.toMutableList()
                            val values = calculationLabel.text.split("[+\\-/*]".toRegex()).toMutableList()
                            var heldValue: Double? = null
                            while (!values.isEmpty() && !operators.isEmpty()) {
                                val value = values[0].toDouble()
                                if (heldValue != null) {
                                    heldValue = when (operators[0]) {
                                        "+" -> heldValue + value
                                        "-" -> heldValue - value
                                        "/" -> heldValue / value
                                        else -> heldValue * value
                                    }
                                    operators.removeAt(0)
                                } else {
                                    heldValue = value
                                }
                                values.removeAt(0)
                            }
                            heldValue?.toString() ?: "0"
                        }
                    }
                }
            } row 0 col 0 colSpan 5 fillWidth true

            button("1") {
                forceSize(40)
                setOnAction {
                    appendText("1")
                }
            } row 1 col 0
            button("2") {
                forceSize(40)
                setOnAction {
                    appendText("2")
                }
            } row 1 col 1
            button("3") {
                forceSize(40)
                setOnAction {
                    appendText("3")
                }
            } row 1 col 2

            button("4") {
                forceSize(40)
                setOnAction {
                    appendText("4")
                }
            } row 2 col 0
            button("5") {
                forceSize(40)
                setOnAction {
                    appendText("5")
                }
            } row 2 col 1
            button("6") {
                forceSize(40)
                setOnAction {
                    appendText("6")
                }
            } row 2 col 2

            button("7") {
                forceSize(40)
                setOnAction {
                    appendText("7")
                }
            } row 3 col 0
            button("8") {
                forceSize(40)
                setOnAction {
                    appendText("8")
                }
            } row 3 col 1
            button("9") {
                forceSize(40)
                setOnAction {
                    appendText("9")
                }
            } row 3 col 2

            button("0") {
                forceSize(40)
                setOnAction {
                    appendText("0")
                }
            } row 4 col 0
            button("00") {
                forceSize(40)
                setOnAction {
                    appendText("00")
                }
            } row 4 col 1
            button(".") {
                forceSize(40)
                setOnAction {
                    errorAlert("Not yet supported.") {
                        title(":(")
                        expandableContent(vboxOf {
                            label("Suggestion") { font("Arial", BOLD, null) }
                            label("Use an actual calculator.") marginTop 4
                        })
                    }
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
                    appendText("*")
                }
            } row 2 col 3
            button("/") {
                forceSize(40)
                setOnAction {
                    appendText("/")
                }
            } row 2 col 4
            button("+") {
                forceSize(40, 80)
                setOnAction {
                    appendText("+")
                }

            } row 3 col 3 rowSpan 2
            button("-") {
                forceSize(40)
                setOnAction {
                    appendText("-")
                }
            } row 3 col 4
            button("=") {
                forceSize(40)
                default(true)
                disableProperty() bind booleanBindingOf(calculationLabel.textProperty()) { endsWithOperator }
                setOnAction {
                    infoAlertWait(resultLabel.text) {
                        header("Result")
                    }
                }
            } row 4 col 4
        }.toScene()
        primaryStage.show()
    }

    fun appendText(text: String) {
        if (OPERATORS.contains(text) && endsWithOperator) {
            calculationLabel.text = calculationLabel.text.substring(0, calculationLabel.text.length - 1)
        }
        calculationLabel.text += text
    }

    val endsWithOperator: Boolean get() = OPERATORS.any { calculationLabel.text.endsWith(it) }
}