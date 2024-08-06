package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTreeTableViewTest :
    LayoutsTest<KtfxPane, JFXTreeTableView<JfxTreeTableViewTest.Person>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXTreeTableView<Person> = jfxTreeTableView<Person> { }

    override fun KtfxPane.child2(): JFXTreeTableView<Person> = jfxTreeTableView<Person>()

    override fun KtfxPane.child3(): JFXTreeTableView<Person> = jfxTreeTableView<Person> { }

    override fun JFXTreeTableView<Person>.testDefaultValues() {
        assertNull(root)
    }

    class Person : RecursiveTreeObject<Person>()
}
