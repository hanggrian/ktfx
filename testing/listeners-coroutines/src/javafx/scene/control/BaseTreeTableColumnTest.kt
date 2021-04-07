package com.hendraanggrian.ktfx.test

import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTablePosition
import javafx.scene.control.TreeTableView
import javafx.util.Duration
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTreeTableColumnTest {
    private lateinit var table: TreeTableView<Duration>
    private lateinit var column: TreeTableColumn<Duration, Long>
    private lateinit var position: TreeTablePosition<Duration, Long>

    abstract fun <S, T> TreeTableColumn<S, T>.callOnEditStart(action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit)
    abstract fun <S, T> TreeTableColumn<S, T>.callOnEditCommit(action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit)
    abstract fun <S, T> TreeTableColumn<S, T>.callOnEditCancel(action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        table = TreeTableView()
        table.columns += TreeTableColumn<Duration, Long>().also { column = it }
        position = TreeTablePosition(table, 0, column)
    }

    @Test fun onEditStart() {
        column.callOnEditStart {
            assertEquals(table, it.source)
            assertEquals(position, it.treeTablePosition)
            assertEquals(TreeTableColumn.editStartEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditStart.handle(
            TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editStartEvent(), 0)
        )
    }

    @Test fun onEditCommit() {
        column.callOnEditCommit {
            assertEquals(table, it.source)
            assertEquals(position, it.treeTablePosition)
            assertEquals(TreeTableColumn.editCommitEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditCommit.handle(
            TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editCommitEvent(), 0)
        )
    }

    @Test fun onEditCancel() {
        column.callOnEditCancel {
            assertEquals(table, it.source)
            assertEquals(position, it.treeTablePosition)
            assertEquals(TreeTableColumn.editCancelEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditCancel.handle(
            TreeTableColumn.CellEditEvent(table, position, TreeTableColumn.editCancelEvent(), 0)
        )
    }
}