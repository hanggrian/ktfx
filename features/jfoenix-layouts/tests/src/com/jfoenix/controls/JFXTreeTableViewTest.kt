package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXTreeTableViewTest : LayoutsTest<NodeManager, JFXTreeTableView<JFXTreeTableViewTest.Person>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTreeTableView<Person> { }
    override fun NodeManager.child2() = jfxTreeTableView<Person>()
    override fun NodeManager.child3() = jfxTreeTableView<Person> { }

    override fun JFXTreeTableView<Person>.testDefaultValues() {
        assertNull(root)
    }

    class Person : RecursiveTreeObject<Person>()
}