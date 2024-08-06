package ktfx

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.initToolkit
import javafx.application.ConditionalFeature
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PlatformTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun isFxThread2() {
        assertFalse(isFxThread())
        ktfx.runLater { assertTrue(isFxThread()) }
        runBlocking(Dispatchers.JavaFx) { assertTrue(isFxThread()) }
        runBlocking(Dispatchers.IO) { assertFalse(isFxThread()) }
    }

    @Test
    fun runLater() {
        // without receiver
        val values = mutableListOf<Int>()
        ktfx.runLater {
            assertTrue(isFxThread())
            values += 1
            assertThat(values).containsExactly(2, 1).inOrder()
        }
        values += 2

        // with receiver
        val list2 = mutableListOf<Int>()
        list2.runLater {
            assertTrue(isFxThread())
            values += 1
            assertThat(list2).containsExactly(2, 1).inOrder()
        }
        list2 += 2
    }

    @Test
    fun withLater() {
        val values = mutableListOf<Int>()
        withLater(values) {
            assertTrue(isFxThread())
            this += 1
            assertThat(values).containsExactly(2, 1).inOrder()
        }
        values += 2
    }

    @Test
    fun applyLater() {
        val values = mutableListOf<Int>()
        values.applyLater {
            assertTrue(isFxThread())
            this += 1
            assertThat(values).containsExactly(2, 1).inOrder()
        }
        values += 2
    }

    @Test
    fun alsoLater() {
        val values = mutableListOf<Int>()
        values.alsoLater {
            assertTrue(isFxThread())
            it += 1
            assertThat(values).containsExactly(2, 1).inOrder()
        }
        values += 2
    }

    @Test
    fun letLater() {
        val values = mutableListOf<Int>()
        values.letLater {
            assertTrue(isFxThread())
            it += 1
            assertThat(values).containsExactly(2, 1).inOrder()
        }
        values += 2
    }

    @Test
    fun repeatLater() {
        var i = 0
        repeatLater(10) {
            assertTrue(isFxThread())
            assertEquals(++i, it)
        }
    }

    @Test
    fun isSupported() = assertTrue(ConditionalFeature.CONTROLS.isSupported())
}
