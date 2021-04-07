package com.hendraanggrian.ktfx.test

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseListViewTest {
    private lateinit var list: ListView<String>

    abstract fun <E> ListView<E>.callOnEditStart(action: (ListView.EditEvent<E>) -> Unit)
    abstract fun <E> ListView<E>.callOnEditCommit(action: (ListView.EditEvent<E>) -> Unit)
    abstract fun <E> ListView<E>.callOnEditCancel(action: (ListView.EditEvent<E>) -> Unit)
    abstract fun <E> ListView<E>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        list = ListView()
    }

    @Test fun onEditStart() {
        list.callOnEditStart {
            assertEquals(list, it.source)
            assertEquals(ListView.editStartEvent<String>(), it.eventType)
            assertEquals("", it.newValue)
            assertEquals(0, it.index)
        }
        list.onEditStart.handle(ListView.EditEvent(list, ListView.editStartEvent(), "", 0))
    }

    @Test fun onEditCommit() {
        list.callOnEditCommit {
            assertEquals(list, it.source)
            assertEquals(ListView.editCommitEvent<String>(), it.eventType)
            assertEquals("", it.newValue)
            assertEquals(0, it.index)
        }
        list.onEditCommit.handle(ListView.EditEvent(list, ListView.editCommitEvent(), "", 0))
    }

    @Test fun onEditCancel() {
        list.callOnEditCancel {
            assertEquals(list, it.source)
            assertEquals(ListView.editCancelEvent<String>(), it.eventType)
            assertEquals("", it.newValue)
            assertEquals(0, it.index)
        }
        list.onEditCancel.handle(ListView.EditEvent(list, ListView.editCancelEvent(), "", 0))
    }

    @Test fun onScrollTo() {
        list.callOnScrollTo {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(0, it.scrollTarget)
        }
        list.onScrollTo.handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
    }
}