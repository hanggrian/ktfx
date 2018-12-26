package ktfx.demo

import javafx.application.Application
import javafx.scene.control.Label
import javafx.stage.Stage
import ktfx.bindings.buildBooleanBinding
import ktfx.bindings.buildStringBinding
import ktfx.controls.updatePadding
import ktfx.coroutines.onAction
import ktfx.dialogs.errorAlert
import ktfx.dialogs.infoAlert
import ktfx.launch
import ktfx.layouts.button
import ktfx.layouts.gridPane
import ktfx.layouts.label
import ktfx.layouts.scene
import ktfx.layouts.vbox

class App : Application() {

    companion object {
        private val OPERATORS = arrayOf("+", "-", "/", "*")

        @JvmStatic fun main(vararg args: String) = launch<App>(*args)
    }

    private lateinit var calculationLabel: Label
    private lateinit var resultLabel: Label

    override fun start(stage: Stage) {
        stage.scene = scene {
            gridPane {
                vbox {
                    updatePadding(right = 20.0, left = 20.0)
                    calculationLabel = label("")
                    resultLabel = label {
                        textProperty().bind(buildStringBinding(calculationLabel.textProperty()) {
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
                } row 0 col 0 colSpans 5 hfill true

                button("1") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("1")
                    }
                } row 1 col 0
                button("2") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("2")
                    }
                } row 1 col 1
                button("3") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("3")
                    }
                } row 1 col 2

                button("4") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("4")
                    }
                } row 2 col 0
                button("5") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("5")
                    }
                } row 2 col 1
                button("6") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("6")
                    }
                } row 2 col 2

                button("7") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("7")
                    }
                } row 3 col 0
                button("8") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("8")
                    }
                } row 3 col 1
                button("9") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("9")
                    }
                } row 3 col 2

                button("0") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("0")
                    }
                } row 4 col 0
                button("00") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("00")
                    }
                } row 4 col 1
                button("") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        errorAlert(":(", content = "Not yet supported.")
                    }
                } row 4 col 2

                button("C") {
                    setMinSize(80.0, 40.0)
                    isCancelButton = true
                    onAction {
                        calculationLabel.text = ""
                    }
                } row 1 col 3 colSpans 2
                button("*") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("*")
                    }
                } row 2 col 3
                button("/") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("/")
                    }
                } row 2 col 4
                button("+") {
                    setMinSize(40.0, 80.0)
                    onAction {
                        appendText("+")
                    }
                } row 3 col 3 rowSpans 2
                button("-") {
                    setMinSize(40.0, 40.0)
                    onAction {
                        appendText("-")
                    }
                } row 3 col 4
                button("=") {
                    setMinSize(40.0, 40.0)
                    isDefaultButton = true
                    disableProperty().bind(buildBooleanBinding(calculationLabel.textProperty()) { endsWithOperator })
                    onAction {
                        infoAlert("Result", content = resultLabel.text)
                    }
                } row 4 col 4
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