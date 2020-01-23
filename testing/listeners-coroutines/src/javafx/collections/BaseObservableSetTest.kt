package ktfx.test

import javafx.collections.FXCollections
import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class BaseObservableSetTest {

    abstract fun <E> ObservableSet<E>.callListener(action: (SetChangeListener.Change<out E>) -> Unit)

    @Test fun listener() {
        val set = FXCollections.observableSet<String>()
        set.callListener {
            assertTrue(it.wasAdded())
            assertEquals("Hello world", it.elementAdded)
        }
        set.add("Hello world")
    }
}