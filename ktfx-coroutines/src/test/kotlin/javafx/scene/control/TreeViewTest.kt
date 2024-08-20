package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TreeViewTest : ApplicationTest() {
    private lateinit var tree: TreeView<String>

    override fun start(stage: Stage) {
        stage.testScene<TreeView<*>>()
        tree = TreeView()
        tree.root = TreeItem()
    }

    @Test
    fun onEditStart() {
        interact {
            tree.onEditStart {
                assertEquals(tree, it.source)
                assertEquals(TreeView.editStartEvent<String>(), it.eventType)
                assertEquals(tree.root, it.treeItem)
                assertEquals("", it.oldValue)
                assertEquals("", it.newValue)
            }
            tree.onEditStart.handle(
                TreeView.EditEvent(
                    tree,
                    TreeView.editStartEvent<String>(),
                    tree.root,
                    "",
                    "",
                ),
            )
        }
    }

    @Test
    fun onEditCommit() {
        interact {
            tree.onEditCommit {
                assertEquals(tree, it.source)
                assertEquals(TreeView.editCommitEvent<String>(), it.eventType)
                assertEquals(tree.root, it.treeItem)
                assertEquals("", it.oldValue)
                assertEquals("", it.newValue)
            }
            tree.onEditCommit.handle(
                TreeView.EditEvent(
                    tree,
                    TreeView.editCommitEvent<String>(),
                    tree.root,
                    "",
                    "",
                ),
            )
        }
    }

    @Test
    fun onEditCancel() {
        interact {
            tree.onEditCancel {
                assertEquals(tree, it.source)
                assertEquals(TreeView.editCancelEvent<String>(), it.eventType)
                assertEquals(tree.root, it.treeItem)
                assertEquals("", it.oldValue)
                assertEquals("", it.newValue)
            }
            tree.onEditCancel.handle(
                TreeView.EditEvent(
                    tree,
                    TreeView.editCancelEvent<String>(),
                    tree.root,
                    "",
                    "",
                ),
            )
        }
    }

    @Test
    fun onScrollTo() {
        interact {
            tree.onScrollTo {
                assertEquals(this@TreeViewTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
                assertEquals(0, it.scrollTarget)
            }
            tree.onScrollTo.handle(
                ScrollToEvent(
                    this,
                    FakeEventTarget,
                    ScrollToEvent.scrollToTopIndex(),
                    0,
                ),
            )
        }
    }
}
