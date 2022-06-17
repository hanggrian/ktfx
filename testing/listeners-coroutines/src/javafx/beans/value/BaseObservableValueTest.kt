package com.hendraanggrian.ktfx.test

import javafx.beans.Observable
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

abstract class BaseObservableValueTest {

    abstract fun ObservableValue<String>.callListener(action: (Observable, String, String) -> Unit)

    @Test
    fun listen() {
        val property = SimpleStringProperty()
        property.callListener { observable, oldValue, value ->
            assertTrue(observable is StringProperty)
            assertNull(oldValue)
            assertEquals("Hello world", value)
        }
        property.set("Hello world")
    }
}
