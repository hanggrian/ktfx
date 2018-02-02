package com.example.kotfx

import javafx.application.Application
import javafx.scene.control.Label
import javafx.scene.text.Font.font
import javafx.scene.text.FontWeight.BOLD
import javafx.stage.Stage
import kotfx.bindings.booleanBindingOf
import kotfx.bindings.stringBindingOf
import kotfx.dialogs.errorAlert
import kotfx.dialogs.infoAlert
import kotfx.minSize
import kotfx.padding
import kotfx.scene.*

class App : Application() {

    companion object {
        private val OPERATORS = arrayOf("+", "-", "/", "*")

        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    override fun start(stage: Stage) {
        stage.scene = gridPane {
            vbox {
                padding(right = 20, left = 20)
                calculationLabel = label("")
                resultLabel = label("") {
                    textProperty().bind(stringBindingOf(calculationLabel.textProperty()) {
                        if (endsWithOperator) "..." else {
                            val operators = calculationLabel.text.split("\\d".toRegex()).filter { it.isNotEmpty() }.toMutableList()
                            val values = calculationLabel.text.split("[+\\-/*]".toRegex()).toMutableList()
                            var total: Double? = null
                            while (!values.isEmpty() && !operators.isEmpty()) {
                                val value = values[0].toDouble()
                                if (total != null) {
                                    total = when (operators[0]) {
                                        "+" -> total + value
                                        "-" -> total - value
                                        "/" -> total / value
                                        else -> total * value
                                    }
                                    operators.removeAt(0)
                                } else {
                                    total = value
                                }
                                values.removeAt(0)
                            }
                            total?.toString() ?: "0"
                        }
                    })
                }
            } row 0 col 0 colSpan 5 hfill true

            button("1") {
                minSize(40)
                setOnAction {
                    appendText("1")
                }
            } row 1 col 0
            button("2") {
                minSize(40)
                setOnAction {
                    appendText("2")
                }
            } row 1 col 1
            button("3") {
                minSize(40)
                setOnAction {
                    appendText("3")
                }
            } row 1 col 2

            button("4") {
                minSize(40)
                setOnAction {
                    appendText("4")
                }
            } row 2 col 0
            button("5") {
                minSize(40)
                setOnAction {
                    appendText("5")
                }
            } row 2 col 1
            button("6") {
                minSize(40)
                setOnAction {
                    appendText("6")
                }
            } row 2 col 2

            button("7") {
                minSize(40)
                setOnAction {
                    appendText("7")
                }
            } row 3 col 0
            button("8") {
                minSize(40)
                setOnAction {
                    appendText("8")
                }
            } row 3 col 1
            button("9") {
                minSize(40)
                setOnAction {
                    appendText("9")
                }
            } row 3 col 2

            button("0") {
                minSize(40)
                setOnAction {
                    appendText("0")
                }
            } row 4 col 0
            button("00") {
                minSize(40)
                setOnAction {
                    appendText("00")
                }
            } row 4 col 1
            button(".") {
                minSize(40)
                setOnAction {
                    errorAlert("Not yet supported.") {
                        title = ":("
                        dialogPane.expandableContent = kotfx.scene.vbox {
                            label("Suggestion") { font = font("Arial", BOLD, 14.0) }
                            label("Use an actual calculator.") marginTop 4
                        }
                    }.show()
                }
            } row 4 col 2

            button("C") {
                minSize(80, 40)
                isCancelButton = true
                setOnAction {
                    calculationLabel.text = ""
                }
            } row 1 col 3 colSpan 2
            button("*") {
                minSize(40)
                setOnAction {
                    appendText("*")
                }
            } row 2 col 3
            button("/") {
                minSize(40.0)
                setOnAction {
                    appendText("/")
                }
            } row 2 col 4
            button("+") {
                minSize(40, 80)
                setOnAction {
                    appendText("+")
                }
            } row 3 col 3 rowSpan 2
            button("-") {
                minSize(40)
                setOnAction {
                    appendText("-")
                }
            } row 3 col 4
            button("=") {
                minSize(40)
                isDefaultButton = true
                disableProperty().bind(booleanBindingOf(calculationLabel.textProperty()) { endsWithOperator })
                setOnAction {
                    infoAlert(resultLabel.text) { headerText = "Result" }.showAndWait()
                }
            } row 4 col 4
        }.toScene()
        stage.show()
    }

    fun appendText(text: String) {
        if (OPERATORS.contains(text) && endsWithOperator) {
            calculationLabel.text = calculationLabel.text.substring(0, calculationLabel.text.length - 1)
        }
        calculationLabel.text += text
    }

    val endsWithOperator: Boolean get() = OPERATORS.any { calculationLabel.text.endsWith(it) }
}