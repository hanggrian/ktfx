package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.TableView
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import ktfx.collections.observableListOf
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TableConstraintsTest {
    private lateinit var view1: TableView<Int>
    private lateinit var view2: TreeTableView<Int>

    @BeforeTest
    fun start() {
        initToolkit()
        view1 = TableView(observableListOf(1, 2))
        view2 = TreeTableView(TreeItem(1))
    }

    @Test
    fun constrained() {
        view1.constrained()
        assertEquals(
            TableView.CONSTRAINED_RESIZE_POLICY,
            view1.columnResizePolicy,
        )

        view2.constrained()
        assertEquals(
            TreeTableView.CONSTRAINED_RESIZE_POLICY,
            view2.columnResizePolicy,
        )
    }

    @Test
    fun unconstrained() {
        view1.unconstrained()
        assertEquals(TableView.UNCONSTRAINED_RESIZE_POLICY, view1.columnResizePolicy)

        view2.unconstrained()
        assertEquals(TreeTableView.UNCONSTRAINED_RESIZE_POLICY, view2.columnResizePolicy)
    }
}
