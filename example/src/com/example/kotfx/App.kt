package com.example.kotfx

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.text.FontWeight.BOLD
import javafx.stage.Stage
import kotfx.bindings.booleanBindingOf
import kotfx.bindings.stringBindingOf
import kotfx.coroutines.onAction
import kotfx.dialogs.errorAlert
import kotfx.dialogs.infoAlert
import kotfx.layout.button
import kotfx.layout.gridPane
import kotfx.layout.label
import kotfx.layout.vbox
import kotfx.minSize
import kotfx.setFont
import kotfx.setPadding

class App : Application() {

    companion object {
        private val OPERATORS = arrayOf("+", "-", "/", "*")

        @JvmStatic fun main(vararg args: String) = launch(App::class.java, *args)
    }

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    override fun start(stage: Stage) {
        stage.scene = Scene(gridPane {
            vbox {
                setPadding(right = 20.0, left = 20.0)
                calculationLabel = label("")
                resultLabel = label {
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
                minSize = 40.0
                onAction {
                    appendText("1")
                }
            } row 1 col 0
            button("2") {
                minSize = 40.0
                onAction {
                    appendText("2")
                }
            } row 1 col 1
            button("3") {
                minSize = 40.0
                onAction {
                    appendText("3")
                }
            } row 1 col 2

            button("4") {
                minSize = 40.0
                onAction {
                    appendText("4")
                }
            } row 2 col 0
            button("5") {
                minSize = 40.0
                onAction {
                    appendText("5")
                }
            } row 2 col 1
            button("6") {
                minSize = 40.0
                onAction {
                    appendText("6")
                }
            } row 2 col 2

            button("7") {
                minSize = 40.0
                onAction {
                    appendText("7")
                }
            } row 3 col 0
            button("8") {
                minSize = 40.0
                onAction {
                    appendText("8")
                }
            } row 3 col 1
            button("9") {
                minSize = 40.0
                onAction {
                    appendText("9")
                }
            } row 3 col 2

            button("0") {
                minSize = 40.0
                onAction {
                    appendText("0")
                }
            } row 4 col 0
            button("00") {
                minSize = 40.0
                onAction {
                    appendText("00")
                }
            } row 4 col 1
            button(".") {
                minSize = 40.0
                onAction {
                    errorAlert("Not yet supported.") {
                        title = ":("
                        dialogPane.expandableContent = kotfx.layout.vbox {
                            label("Suggestion") { setFont("Arial", BOLD, size = 14.0) }
                            label("Use an actual calculator.") marginTop 4
                        }
                    }.show()
                }
            } row 4 col 2

            button("C") {
                setMinSize(80.0, 40.0)
                isCancelButton = true
                onAction {
                    calculationLabel.text = ""
                }
            } row 1 col 3 colSpan 2
            button("*") {
                minSize = 40.0
                onAction {
                    appendText("*")
                }
            } row 2 col 3
            button("/") {
                minSize = 40.0
                onAction {
                    appendText("/")
                }
            } row 2 col 4
            button("+") {
                setMinSize(40.0, 80.0)
                onAction {
                    appendText("+")
                }
            } row 3 col 3 rowSpan 2
            button("-") {
                minSize = 40.0
                onAction {
                    appendText("-")
                }
            } row 3 col 4
            button("=") {
                minSize = 40.0
                isDefaultButton = true
                disableProperty().bind(booleanBindingOf(calculationLabel.textProperty()) { endsWithOperator })
                onAction {
                    infoAlert(resultLabel.text) { headerText = "Result" }.showAndWait()
                }
            } row 4 col 4
        })
        stage.isResizable = false
        stage.show()
    }

    private fun appendText(text: String) {
        if (OPERATORS.contains(text) && endsWithOperator) {
            calculationLabel.text = calculationLabel.text.substring(0, calculationLabel.text.length - 1)
        }
        calculationLabel.text += text
    }

    private val endsWithOperator: Boolean get() = OPERATORS.any { calculationLabel.text.endsWith(it) }
}