package ktfx.cells

import com.hanggrian.ktfx.test.initToolkit
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell
import ktfx.collections.emptyObservableList
import ktfx.text.buildStringConverter
import ktfx.text.get
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ListCellTest {
    private lateinit var view: ListView<Int>

    @BeforeTest
    fun start() {
        initToolkit()
        view = ListView()
    }

    @Test
    fun checkBoxCellFactory() {
        view.checkBoxCellFactory { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxListCell<*>>(view.cellFactory.call(view))

        view.checkBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        ) { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxListCell<*>>(view.cellFactory.call(view))
        assertEquals(0, (view.cellFactory.call(view) as CheckBoxListCell<*>).converter["0"])
    }

    @Test
    fun choiceBoxCellFactory() {
        view.choiceBoxCellFactory()
        assertIs<ChoiceBoxListCell<*>>(view.cellFactory.call(view))

        view.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ChoiceBoxListCell<*>>(view.cellFactory.call(view))
        assertEquals(0, (view.cellFactory.call(view) as ChoiceBoxListCell<*>).converter["0"])

        view.choiceBoxCellFactory(emptyObservableList())
        assertIs<ChoiceBoxListCell<*>>(view.cellFactory.call(view))

        view.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ChoiceBoxListCell<*>>(view.cellFactory.call(view))
        assertEquals(0, (view.cellFactory.call(view) as ChoiceBoxListCell<*>).converter["0"])
    }

    @Test
    fun comboBoxCellFactory() {
        view.comboBoxCellFactory()
        assertIs<ComboBoxListCell<*>>(view.cellFactory.call(view))

        view.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ComboBoxListCell<*>>(view.cellFactory.call(view))
        assertEquals(0, (view.cellFactory.call(view) as ComboBoxListCell<*>).converter["0"])

        view.comboBoxCellFactory(emptyObservableList())
        assertIs<ComboBoxListCell<*>>(view.cellFactory.call(view))

        view.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ComboBoxListCell<*>>(view.cellFactory.call(view))
        assertEquals(0, (view.cellFactory.call(view) as ComboBoxListCell<*>).converter["0"])
    }

    @Test
    fun textFieldCellFactory() {
        val view2 = ListView<String>()
        view2.textFieldCellFactory()
        assertIs<TextFieldListCell<*>>(view2.cellFactory.call(view2))

        view.textFieldCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<TextFieldListCell<*>>(view.cellFactory.call(view))
        assertEquals(0, (view.cellFactory.call(view) as TextFieldListCell<*>).converter["0"])
    }
}
