package com.example

import javafx.application.Application
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.bindings.asBoolean
import ktfx.bindings.asString
import ktfx.controls.minSize
import ktfx.controls.padding
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
                    padding(horizontal = 20)
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
                }.grid(0, 0, colSpan = 5).fillWidth()

                button("1") {
                    minSize = 40 to 40
                    onAction { appendText("1") }
                }.grid(1, 0)
                button("2") {
                    minSize = 40 to 40
                    onAction { appendText("2") }
                }.grid(1, 1)
                button("3") {
                    minSize = 40 to 40
                    onAction { appendText("3") }
                }.grid(1, 2)

                button("4") {
                    minSize = 40 to 40
                    onAction { appendText("4") }
                }.grid(2, 0)
                button("5") {
                    minSize = 40 to 40
                    onAction { appendText("5") }
                }.grid(2, 1)
                button("6") {
                    minSize = 40 to 40
                    onAction { appendText("6") }
                }.grid(2, 2)

                button("7") {
                    minSize = 40 to 40
                    onAction { appendText("7") }
                }.grid(3, 0)
                button("8") {
                    minSize = 40 to 40
                    onAction { appendText("8") }
                }.grid(3, 1)
                button("9") {
                    minSize = 40 to 40
                    onAction { appendText("9") }
                }.grid(3, 2)

                button("0") {
                    minSize = 40 to 40
                    onAction { appendText("0") }
                }.grid(4, 0)
                button("00") {
                    minSize = 40 to 40
                    onAction { appendText("00") }
                }.grid(4, 1)
                button(".") {
                    minSize = 40 to 40
                    onAction { errorAlert(":(", content = "Not yet supported.") }
                }.grid(4, 2)

                button("C") {
                    setMinSize(80.0, 40.0)
                    isCancelButton = true
                    onAction { calculationLabel.text = "" }
                }.grid(1, 3, colSpan = 2)
                button("*") {
                    minSize = 40 to 40
                    onAction { appendText("*") }
                }.grid(2, 3)
                button("/") {
                    minSize = 40 to 40
                    onAction { appendText("/") }
                }.grid(2, 4)
                button("+") {
                    minSize = 40 to 80
                    onAction { appendText("+") }
                }.grid(3, 3, rowSpan = 2)
                button("-") {
                    minSize = 40 to 40
                    onAction { appendText("-") }
                }.grid(3, 4)
                button("=") {
                    minSize = 40 to 40
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
            calculationLabel.text = calculationLabel.text.substring(0, calculationLabel.text.length - 1)
        }
        calculationLabel.text += text
    }

    private fun endsWithOperator(text: String?): Boolean = OPERATORS.any { text!!.endsWith(it) }
}