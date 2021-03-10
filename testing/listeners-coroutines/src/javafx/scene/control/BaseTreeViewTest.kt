package io.github.hendraanggrian.ktfx.test

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTreeViewTest {
    private lateinit var tree: TreeView<String>

    abstract fun <E> TreeView<E>.callOnEditStart(action: (TreeView.EditEvent<E>) -> Unit)
    abstract fun <E> TreeView<E>.callOnEditCommit(action: (TreeView.EditEvent<E>) -> Unit)
    abstract fun <E> TreeView<E>.callOnEditCancel(action: (TreeView.EditEvent<E>) -> Unit)
    abstract fun <E> TreeView<E>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        tree = TreeView()
        tree.root = TreeItem()
    }

    @Test fun onEditStart() {
        tree.callOnEditStart {
            assertEquals(tree, it.source)
            assertEquals(TreeView.editStartEvent<String>(), it.eventType)
            assertEquals(tree.root, it.treeItem)
            assertEquals("", it.oldValue)
            assertEquals("", it.newValue)
        }
        tree.onEditStart.handle(TreeView.EditEvent(tree, TreeView.editStartEvent<String>(), tree.root, "", ""))
    }

    @Test fun onEditCommit() {
        tree.callOnEditCommit {
            assertEquals(tree, it.source)
            assertEquals(TreeView.editCommitEvent<String>(), it.eventType)
            assertEquals(tree.root, it.treeItem)
            assertEquals("", it.oldValue)
            assertEquals("", it.newValue)
        }
        tree.onEditCommit.handle(TreeView.EditEvent(tree, TreeView.editCommitEvent<String>(), tree.root, "", ""))
    }

    @Test fun onEditCancel() {
        tree.callOnEditCancel {
            assertEquals(tree, it.source)
            assertEquals(TreeView.editCancelEvent<String>(), it.eventType)
            assertEquals(tree.root, it.treeItem)
            assertEquals("", it.oldValue)
            assertEquals("", it.newValue)
        }
        tree.onEditCancel.handle(TreeView.EditEvent(tree, TreeView.editCancelEvent<String>(), tree.root, "", ""))
    }

    @Test fun onScrollTo() {
        tree.callOnScrollTo {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(0, it.scrollTarget)
        }
        tree.onScrollTo.handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
    }
}