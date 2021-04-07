package com.hendraanggrian.ktfx.test

import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class BaseObservableListTest {

    abstract fun <E> ObservableList<E>.callListener(action: (ListChangeListener.Change<out E>) -> Unit)

    @Test fun listener() {
        val list = FXCollections.observableArrayList<String>()
        list.callListener<String> {
            it.next()
            assertEquals(0, it.from)
            assertEquals(1, it.to)
            assertTrue(it.wasAdded())
            assertEquals("Hello world", it.addedSubList.single())
        }
        list.add("Hello world")
    }
}