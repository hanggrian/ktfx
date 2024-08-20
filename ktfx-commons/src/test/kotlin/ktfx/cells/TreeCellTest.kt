package ktfx.cells

import com.hanggrian.ktfx.test.initToolkit
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ComboBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell
import ktfx.collections.emptyObservableList
import ktfx.text.buildStringConverter
import ktfx.text.get
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TreeCellTest {
    private lateinit var tree: TreeView<Int>

    @BeforeTest
    fun start() {
        initToolkit()
        tree = TreeView()
    }

    @Test
    fun checkBoxCellFactory() {
        tree.checkBoxCellFactory()
        assertIs<CheckBoxTreeCell<*>>(tree.cellFactory.call(tree))

        tree.checkBoxCellFactory { SimpleBooleanProperty(it.value == 0) }
        assertIs<CheckBoxTreeCell<*>>(tree.cellFactory.call(tree))

        tree.checkBoxCellFactory(
            buildStringConverter {
                fromString { TreeItem(it.toInt()) }
            },
        ) { SimpleBooleanProperty(it.value == 0) }
        assertIs<CheckBoxTreeCell<*>>(tree.cellFactory.call(tree))
        assertEquals(0, (tree.cellFactory.call(tree) as CheckBoxTreeCell<*>).converter["0"].value)
    }

    @Test
    fun choiceBoxCellFactory() {
        tree.choiceBoxCellFactory()
        assertIs<ChoiceBoxTreeCell<*>>(tree.cellFactory.call(tree))

        tree.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ChoiceBoxTreeCell<*>>(tree.cellFactory.call(tree))
        assertEquals(0, (tree.cellFactory.call(tree) as ChoiceBoxTreeCell<*>).converter["0"])

        tree.choiceBoxCellFactory(emptyObservableList())
        assertIs<ChoiceBoxTreeCell<*>>(tree.cellFactory.call(tree))

        tree.choiceBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ChoiceBoxTreeCell<*>>(tree.cellFactory.call(tree))
        assertEquals(0, (tree.cellFactory.call(tree) as ChoiceBoxTreeCell<*>).converter["0"])
    }

    @Test
    fun comboBoxCellFactory() {
        tree.comboBoxCellFactory()
        assertIs<ComboBoxTreeCell<*>>(tree.cellFactory.call(tree))

        tree.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<ComboBoxTreeCell<*>>(tree.cellFactory.call(tree))
        assertEquals(0, (tree.cellFactory.call(tree) as ComboBoxTreeCell<*>).converter["0"])

        tree.comboBoxCellFactory(emptyObservableList())
        assertIs<ComboBoxTreeCell<*>>(tree.cellFactory.call(tree))

        tree.comboBoxCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
            emptyObservableList(),
        )
        assertIs<ComboBoxTreeCell<*>>(tree.cellFactory.call(tree))
        assertEquals(0, (tree.cellFactory.call(tree) as ComboBoxTreeCell<*>).converter["0"])
    }

    @Test
    fun textFieldCellFactory() {
        val view2 = TreeView<String>()
        view2.textFieldCellFactory()
        assertIs<TextFieldTreeCell<*>>(view2.cellFactory.call(view2))

        tree.textFieldCellFactory(
            buildStringConverter {
                fromString { it.toInt() }
            },
        )
        assertIs<TextFieldTreeCell<*>>(tree.cellFactory.call(tree))
        assertEquals(0, (tree.cellFactory.call(tree) as TextFieldTreeCell<*>).converter["0"])
    }
}
