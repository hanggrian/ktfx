package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TreeViewTest {
    private lateinit var tree: TreeView<String>

    @BeforeTest
    fun start() {
        initToolkit()
        tree = TreeView()
        tree.root = TreeItem()
    }

    @Test
    fun onEditStart() {
        tree.onEditStart(Dispatchers.Unconfined) {
            assertEquals(tree, it.source)
            assertEquals(TreeView.editStartEvent<String>(), it.eventType)
            assertEquals(tree.root, it.treeItem)
            assertEquals("", it.oldValue)
            assertEquals("", it.newValue)
        }
        tree.onEditStart
            .handle(TreeView.EditEvent(tree, TreeView.editStartEvent<String>(), tree.root, "", ""))
    }

    @Test
    fun onEditCommit() {
        tree.onEditCommit(Dispatchers.Unconfined) {
            assertEquals(tree, it.source)
            assertEquals(TreeView.editCommitEvent<String>(), it.eventType)
            assertEquals(tree.root, it.treeItem)
            assertEquals("", it.oldValue)
            assertEquals("", it.newValue)
        }
        tree.onEditCommit
            .handle(TreeView.EditEvent(tree, TreeView.editCommitEvent<String>(), tree.root, "", ""))
    }

    @Test
    fun onEditCancel() {
        tree.onEditCancel(Dispatchers.Unconfined) {
            assertEquals(tree, it.source)
            assertEquals(TreeView.editCancelEvent<String>(), it.eventType)
            assertEquals(tree.root, it.treeItem)
            assertEquals("", it.oldValue)
            assertEquals("", it.newValue)
        }
        tree.onEditCancel
            .handle(TreeView.EditEvent(tree, TreeView.editCancelEvent<String>(), tree.root, "", ""))
    }

    @Test
    fun onScrollTo() {
        tree.onScrollTo(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(0, it.scrollTarget)
        }
        tree.onScrollTo
            .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
    }
}
