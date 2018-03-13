package kfx.listeners

import javafx.scene.Scene
import javafx.scene.control.ChoiceBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kfx.collections.observableListOf
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class StringConverterTest : ApplicationTest() {

    private lateinit var primitiveBox: ChoiceBox<Int>
    private lateinit var customBox: ChoiceBox<Person>

    override fun start(stage: Stage) {
        primitiveBox = ChoiceBox(observableListOf(123))
        customBox = ChoiceBox(observableListOf(Person("Hendra")))
        stage.run {
            scene = Scene(VBox(primitiveBox, customBox))
            show()
        }
    }

    @Test fun primitive() {
        primitiveBox.converter {
            fromString { it.toInt() }
        }
        primitiveBox
    }
}