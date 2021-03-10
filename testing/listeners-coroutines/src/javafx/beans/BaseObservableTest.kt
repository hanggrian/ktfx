package io.github.hendraanggrian.ktfx.test

import javafx.beans.Observable
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class BaseObservableTest {

    abstract fun Observable.callListener(action: (Observable) -> Unit)

    @Test fun listener() {
        val property = SimpleStringProperty()
        property.callListener {
            assertTrue(it is StringProperty)
            assertEquals("Hello world", it.get())
        }
        property.set("Hello world")
    }
}