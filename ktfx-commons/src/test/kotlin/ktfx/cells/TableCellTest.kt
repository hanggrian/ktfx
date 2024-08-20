package ktfx.cells

import com.hanggrian.ktfx.test.initToolkit
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell
import ktfx.collections.emptyObservableList
import ktfx.text.buildStringConverter
import ktfx.text.get
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TableCellTest {
    private lateinit var column: TableColumn<String, Int>

    @BeforeTest
    fun start() {
        initToolkit()
        column = TableColumn()
    }

    @Test
    fun checkBoxCellFactory() {
        val column2 = TableColumn<String, Boolean>()
        column2.checkBoxCellFactory()
        assertIs<CheckBoxTableCell<*, *>>(column2.cellFactory.call(column2))

        column.checkBoxCellFactory(true) { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxTableCell<*, *>>(column.cellFactory.call(column))

        column.checkBoxCellFactory { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxTableCell<*, *>>(column.cellFactory.call(column))

        column.checkBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        ) { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(0, (column.cellFactory.call(column) as CheckBoxTableCell<*, *>).converter["0"])
    }

    @Test
    fun choiceBoxCellFactory() {
        column.choiceBoxCellFactory()
        assertIs<ChoiceBoxTableCell<*, *>>(column.cellFactory.call(column))

        column.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ChoiceBoxTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as ChoiceBoxTableCell<*, *>).converter["0"],
        )

        column.choiceBoxCellFactory(emptyObservableList())
        assertIs<ChoiceBoxTableCell<*, *>>(column.cellFactory.call(column))

        column.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ChoiceBoxTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as ChoiceBoxTableCell<*, *>).converter["0"],
        )
    }

    @Test
    fun comboBoxCellFactory() {
        column.comboBoxCellFactory()
        assertIs<ComboBoxTableCell<*, *>>(column.cellFactory.call(column))

        column.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ComboBoxTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(0, (column.cellFactory.call(column) as ComboBoxTableCell<*, *>).converter["0"])

        column.comboBoxCellFactory(emptyObservableList())
        assertIs<ComboBoxTableCell<*, *>>(column.cellFactory.call(column))

        column.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ComboBoxTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(0, (column.cellFactory.call(column) as ComboBoxTableCell<*, *>).converter["0"])
    }

    @Test
    fun progressBarCellFactory() {
        val column2 = TableColumn<Int, Double>()
        column2.progressBarCellFactory()
        assertIs<ProgressBarTableCell<*>>(column2.cellFactory.call(column2))
    }

    @Test
    fun textFieldCellFactory() {
        val column2 = TableColumn<Int, String>()
        column2.textFieldCellFactory()
        assertIs<TextFieldTableCell<*, *>>(column2.cellFactory.call(column2))

        column.textFieldCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<TextFieldTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as TextFieldTableCell<*, *>).converter["0"],
        )
    }
}
