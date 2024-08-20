package ktfx.cells

import com.hanggrian.ktfx.test.initToolkit
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ComboBoxTreeTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import ktfx.collections.emptyObservableList
import ktfx.text.buildStringConverter
import ktfx.text.get
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TreeTableCellTest {
    private lateinit var column: TreeTableColumn<String, Int>

    @BeforeTest
    fun start() {
        initToolkit()
        column = TreeTableColumn()
    }

    @Test
    fun checkBoxCellFactory() {
        val column2 = TreeTableColumn<String, Boolean>()
        column2.checkBoxCellFactory()
        assertIs<CheckBoxTreeTableCell<*, *>>(column2.cellFactory.call(column2))

        column.checkBoxCellFactory(true) { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxTreeTableCell<*, *>>(column.cellFactory.call(column))

        column.checkBoxCellFactory { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxTreeTableCell<*, *>>(column.cellFactory.call(column))

        column.checkBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        ) { SimpleBooleanProperty(it == 0) }
        assertIs<CheckBoxTreeTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as CheckBoxTreeTableCell<*, *>).converter["0"],
        )
    }

    @Test
    fun choiceBoxCellFactory() {
        column.choiceBoxCellFactory()
        assertIs<ChoiceBoxTreeTableCell<*, *>>(column.cellFactory.call(column))

        column.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ChoiceBoxTreeTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as ChoiceBoxTreeTableCell<*, *>).converter["0"],
        )

        column.choiceBoxCellFactory(emptyObservableList())
        assertIs<ChoiceBoxTreeTableCell<*, *>>(column.cellFactory.call(column))

        column.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ChoiceBoxTreeTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as ChoiceBoxTreeTableCell<*, *>).converter["0"],
        )
    }

    @Test
    fun comboBoxCellFactory() {
        column.comboBoxCellFactory()
        assertIs<ComboBoxTreeTableCell<*, *>>(column.cellFactory.call(column))

        column.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ComboBoxTreeTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as ComboBoxTreeTableCell<*, *>).converter["0"],
        )

        column.comboBoxCellFactory(emptyObservableList())
        assertIs<ComboBoxTreeTableCell<*, *>>(column.cellFactory.call(column))

        column.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ComboBoxTreeTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as ComboBoxTreeTableCell<*, *>).converter["0"],
        )
    }

    @Test
    fun progressBarCellFactory() {
        val column2 = TreeTableColumn<Int, Double>()
        column2.progressBarCellFactory()
        assertIs<ProgressBarTreeTableCell<*>>(column2.cellFactory.call(column2))
    }

    @Test
    fun textFieldCellFactory() {
        val column2 = TreeTableColumn<Int, String>()
        column2.textFieldCellFactory()
        assertIs<TextFieldTreeTableCell<*, *>>(column2.cellFactory.call(column2))

        column.textFieldCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<TextFieldTreeTableCell<*, *>>(column.cellFactory.call(column))
        assertEquals(
            0,
            (column.cellFactory.call(column) as TextFieldTreeTableCell<*, *>).converter["0"],
        )
    }
}
