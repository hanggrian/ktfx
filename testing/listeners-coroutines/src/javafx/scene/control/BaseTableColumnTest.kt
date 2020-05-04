package com.hendraanggrian.ktfx.test

import javafx.scene.control.TableColumn
import javafx.scene.control.TablePosition
import javafx.scene.control.TableView
import javafx.util.Duration
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTableColumnTest {
    private lateinit var table: TableView<Duration>
    private lateinit var column: TableColumn<Duration, Long>
    private lateinit var position: TablePosition<Duration, Long>

    abstract fun <S, T> TableColumn<S, T>.callOnEditStart(action: (TableColumn.CellEditEvent<S, T>) -> Unit)
    abstract fun <S, T> TableColumn<S, T>.callOnEditCommit(action: (TableColumn.CellEditEvent<S, T>) -> Unit)
    abstract fun <S, T> TableColumn<S, T>.callOnEditCancel(action: (TableColumn.CellEditEvent<S, T>) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        table = TableView()
        table.columns += TableColumn<Duration, Long>().also { column = it }
        position = TablePosition(table, 0, column)
    }

    @Test fun onEditStart() {
        column.callOnEditStart {
            assertEquals(table, it.source)
            assertEquals(position, it.tablePosition)
            assertEquals(TableColumn.editStartEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditStart.handle(
            TableColumn.CellEditEvent(table, position, TableColumn.editStartEvent(), 0)
        )
    }

    @Test fun onEditCommit() {
        column.callOnEditCommit {
            assertEquals(table, it.source)
            assertEquals(position, it.tablePosition)
            assertEquals(TableColumn.editCommitEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditCommit.handle(
            TableColumn.CellEditEvent(table, position, TableColumn.editCommitEvent(), 0)
        )
    }

    @Test fun onEditCancel() {
        column.callOnEditCancel {
            assertEquals(table, it.source)
            assertEquals(position, it.tablePosition)
            assertEquals(TableColumn.editCancelEvent<Duration, Long>(), it.eventType)
            assertEquals(0, it.newValue)
        }
        column.onEditCancel.handle(
            TableColumn.CellEditEvent(table, position, TableColumn.editCancelEvent(), 0)
        )
    }
}