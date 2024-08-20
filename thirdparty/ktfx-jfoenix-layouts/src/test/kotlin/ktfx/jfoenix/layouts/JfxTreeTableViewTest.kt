package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxTreeTableViewTest :
    LayoutsStyledTest<KtfxPane, JFXTreeTableView<JfxTreeTableViewTest.Person>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTreeTableView<Person> {}

    override fun KtfxPane.child2() = jfxTreeTableView<Person>()

    override fun child3() = styledJfxTreeTableView<Person>()

    override fun KtfxPane.child4() = styledJfxTreeTableView<Person>()

    override fun JFXTreeTableView<Person>.testDefaultValues() {
        assertNull(root)
    }

    class Person : RecursiveTreeObject<Person>()
}
