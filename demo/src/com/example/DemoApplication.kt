package com.example

import javafx.application.Application
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.bindings.booleanBindingOf
import ktfx.bindings.stringBindingOf
import ktfx.coroutines.onAction
import ktfx.dialogs.errorAlert
import ktfx.dialogs.infoAlert
import ktfx.layouts.button
import ktfx.layouts.gridPane
import ktfx.layouts.label
import ktfx.layouts.minSize
import ktfx.layouts.scene
import ktfx.layouts.updatePadding
import ktfx.layouts.vbox

class DemoApplication : Application() {

    companion object {
        private val OPERATORS = arrayOf("+", "-", "/", "*")

        @JvmStatic
        fun main(vararg args: String) = ktfx.launch<DemoApplication>(*args)
    }

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    override fun start(stage: Stage) {
        stage.scene {
            gridPane {
                vbox {
                    constraints row 0 col 0 colSpan 5 hfill true

                    updatePadding(right = 20.0, left = 20.0)
                    calculationLabel = label("")

                    resultLabel = label {
                        textProperty().bind(stringBindingOf(calculationLabel.textProperty()) {
                            if (endsWithOperator) "..." else {
                                val operators = calculationLabel.text
                                    .split("\\d".toRegex())
                                    .asSequence()
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
                }

                button("1") {
                    constraints row 1 col 0
                    minSize = 40.0
                    onAction {
                        appendText("1")
                    }
                }
                button("2") {
                    constraints row 1 col 1
                    minSize = 40.0
                    onAction {
                        appendText("2")
                    }
                }
                button("3") {
                    constraints row 1 col 2
                    minSize = 40.0
                    onAction {
                        appendText("3")
                    }
                }

                button("4") {
                    constraints row 2 col 0
                    minSize = 40.0
                    onAction {
                        appendText("4")
                    }
                }
                button("5") {
                    constraints row 2 col 1
                    minSize = 40.0
                    onAction {
                        appendText("5")
                    }
                }
                button("6") {
                    constraints row 2 col 2
                    minSize = 40.0
                    onAction {
                        appendText("6")
                    }
                }

                button("7") {
                    constraints row 3 col 0
                    minSize = 40.0
                    onAction {
                        appendText("7")
                    }
                }
                button("8") {
                    constraints row 3 col 1
                    minSize = 40.0
                    onAction {
                        appendText("8")
                    }
                }
                button("9") {
                    constraints row 3 col 2
                    minSize = 40.0
                    onAction {
                        appendText("9")
                    }
                }

                button("0") {
                    constraints row 4 col 0
                    minSize = 40.0
                    onAction {
                        appendText("0")
                    }
                }
                button("00") {
                    constraints row 4 col 1
                    minSize = 40.0
                    onAction {
                        appendText("00")
                    }
                }
                button("") {
                    constraints row 4 col 2
                    minSize = 40.0
                    onAction {
                        errorAlert(":(", content = "Not yet supported.")
                    }
                }

                button("C") {
                    constraints row 1 col 3 colSpan 2
                    setMinSize(80.0, 40.0)
                    isCancelButton = true
                    onAction {
                        calculationLabel.text = ""
                    }
                }
                button("*") {
                    constraints row 2 col 3
                    minSize = 40.0
                    onAction {
                        appendText("*")
                    }
                }
                button("/") {
                    constraints row 2 col 4
                    minSize = 40.0
                    onAction {
                        appendText("/")
                    }
                }
                button("+") {
                    constraints row 3 col 3 rowSpan 2
                    setMinSize(40.0, 80.0)
                    onAction {
                        appendText("+")
                    }
                }
                button("-") {
                    constraints row 3 col 4
                    minSize = 40.0
                    onAction {
                        appendText("-")
                    }
                }
                button("=") {
                    constraints row 4 col 4
                    minSize = 40.0
                    isDefaultButton = true
                    disableProperty().bind(booleanBindingOf(calculationLabel.textProperty()) { endsWithOperator })
                    onAction {
                        infoAlert("Result", content = resultLabel.text)
                    }
                }
            }
        }
        stage.isResizable = false
        stage.show()
    }

    private fun appendText(text: String) {
        if (OPERATORS.contains(text) && endsWithOperator) {
            calculationLabel.text = calculationLabel.text.substring(0, calculationLabel.text.length - 1)
        }
        calculationLabel.text += text
    }

    private inline val endsWithOperator: Boolean get() = OPERATORS.any { calculationLabel.text.endsWith(it) }
}