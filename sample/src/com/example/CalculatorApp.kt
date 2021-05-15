package com.example

import javafx.application.Application
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.bindings.asBoolean
import ktfx.bindings.asString
import ktfx.controls.insetsOf
import ktfx.coroutines.onAction
import ktfx.dialogs.errorAlert
import ktfx.dialogs.infoAlert
import ktfx.launchApplication
import ktfx.layouts.button
import ktfx.layouts.gridPane
import ktfx.layouts.label
import ktfx.layouts.scene
import ktfx.layouts.vbox

class CalculatorApp : Application() {
    companion object {
        private val OPERATORS = arrayOf("+", "-", "/", "*")

        @JvmStatic fun main(vararg args: String) = launchApplication<CalculatorApp>(*args)
    }

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    override fun start(stage: Stage) {
        stage.scene {
            gridPane {
                vbox {
                    padding = insetsOf(horizontal = 20)
                    calculationLabel = label("")

                    resultLabel = label {
                        textProperty().bind(calculationLabel.textProperty().asString {
                            if (endsWithOperator(calculationLabel.text)) "..." else {
                                val operators = calculationLabel.text
                                    .split("\\d".toRegex())
                                    .filter { it.isNotEmpty() }
                                    .toMutableList()
                                val values = calculationLabel.text
                                    .split("[+\\-/*]".toRegex())
                                    .toMutableList()
                                var total: Double? = null
                                while (values.isNotEmpty() && operators.isNotEmpty()) {
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
                }.grid(0, 0 to 5).fillWidth()

                button("1") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("1") }
                }.grid(1, 0)
                button("2") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("2") }
                }.grid(1, 1)
                button("3") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("3") }
                }.grid(1, 2)

                button("4") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("4") }
                }.grid(2, 0)
                button("5") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("5") }
                }.grid(2, 1)
                button("6") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("6") }
                }.grid(2, 2)

                button("7") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("7") }
                }.grid(3, 0)
                button("8") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("8") }
                }.grid(3, 1)
                button("9") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("9") }
                }.grid(3, 2)

                button("0") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("0") }
                }.grid(4, 0)
                button("00") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("00") }
                }.grid(4, 1)
                button(".") {
                    setMinSize(40.0, 40.0)
                    onAction { errorAlert(":(", content = "Not yet supported.") }
                }.grid(4, 2)

                button("C") {
                    setMinSize(80.0, 40.0)
                    isCancelButton = true
                    onAction { calculationLabel.text = "" }
                }.grid(1, 3 to 2)
                button("*") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("*") }
                }.grid(2, 3)
                button("/") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("/") }
                }.grid(2, 4)
                button("+") {
                    setMinSize(40.0, 80.0)
                    onAction { appendText("+") }
                }.grid(3 to 2, 3)
                button("-") {
                    setMinSize(40.0, 40.0)
                    onAction { appendText("-") }
                }.grid(3, 4)
                button("=") {
                    setMinSize(40.0, 40.0)
                    isDefaultButton = true
                    disableProperty().bind(calculationLabel.textProperty().asBoolean(::endsWithOperator))
                    onAction { infoAlert("Result", content = resultLabel.text) }
                }.grid(4, 4)
            }
        }
        stage.isResizable = false
        stage.show()
    }

    private fun appendText(text: String) {
        if (text in OPERATORS && endsWithOperator(text)) {
            calculationLabel.text = calculationLabel.text.substring(0, calculationLabel.text.length)
        }
        calculationLabel.text += text
    }

    private fun endsWithOperator(text: String?): Boolean = OPERATORS.any { text!!.endsWith(it) }
}