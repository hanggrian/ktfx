package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXTreeTableViewTest : LayoutsTest<KtfxPane, JFXTreeTableView<JFXTreeTableViewTest.Person>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTreeTableView<Person> { }
    override fun KtfxPane.child2() = jfxTreeTableView<Person>()
    override fun KtfxPane.child3() = jfxTreeTableView<Person> { }

    override fun JFXTreeTableView<Person>.testDefaultValues() {
        assertNull(root)
    }

    class Person : RecursiveTreeObject<Person>()
}
