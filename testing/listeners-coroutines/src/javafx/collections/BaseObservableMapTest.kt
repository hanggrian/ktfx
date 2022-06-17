package com.hendraanggrian.ktfx.test

import javafx.collections.FXCollections
import javafx.collections.MapChangeListener
import javafx.collections.ObservableMap
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class BaseObservableMapTest {

    abstract fun <K, V> ObservableMap<K, V>.callListener(action: (MapChangeListener.Change<out K, out V>) -> Unit)

    @Test
    fun listener() {
        val map = FXCollections.observableHashMap<Int, String>()
        map.callListener<Int, String> {
            assertTrue(it.wasAdded())
            assertEquals(1, it.key)
            assertEquals("Hello world", it.valueAdded)
        }
        map[1] = "Hello world"
    }
}
