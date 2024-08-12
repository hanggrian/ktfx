package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ListView
import ktfx.collections.observableListOf
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SelectionsTest {
    private lateinit var box: ChoiceBox<Int>
    private lateinit var view: ListView<Int>

    @BeforeTest
    fun start() {
        initToolkit()
        box = ChoiceBox(observableListOf(1, 2))
        view = ListView(observableListOf(1, 2))
    }

    @Test
    fun isSelected() {
        assertFalse(box.selectionModel.isSelected())
        box.selectionModel.select(0)
        assertTrue(box.selectionModel.isSelected())

        assertFalse(view.selectionModel.isSelected())
        view.selectionModel.select(0)
        assertTrue(view.selectionModel.isSelected())
    }

    @Test
    fun isNotSelected() {
        assertTrue(box.selectionModel.isNotSelected())
        box.selectionModel.select(0)
        assertFalse(box.selectionModel.isNotSelected())

        assertTrue(view.selectionModel.isNotSelected())
        view.selectionModel.select(0)
        assertFalse(view.selectionModel.isNotSelected())
    }

    @Test
    fun selectedBinding() {
        val binding1 = box.selectionModel.selectedBinding
        assertFalse(binding1.value)
        box.selectionModel.select(0)
        assertTrue(binding1.value)

        val binding2 = view.selectionModel.selectedBinding
        assertFalse(binding2.value)
        view.selectionModel.select(0)
        assertTrue(binding2.value)
    }

    @Test
    fun notSelectedBinding() {
        val binding1 = box.selectionModel.notSelectedBinding
        assertTrue(binding1.value)
        box.selectionModel.select(0)
        assertFalse(binding1.value)

        val binding2 = view.selectionModel.notSelectedBinding
        assertTrue(binding2.value)
        view.selectionModel.select(0)
        assertFalse(binding2.value)
    }
}
