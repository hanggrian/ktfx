package ktfx

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.initToolkit
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
        val list = mutableListOf<Int>()
        ktfx.runLater {
            assertTrue(isFxThread())
            list += 1
            assertThat(list).containsExactly(2, 1).inOrder()
        }
        list += 2

        // with receiver
        val list2 = mutableListOf<Int>()
        list2.runLater {
            assertTrue(isFxThread())
            list += 1
            assertThat(list2).containsExactly(2, 1).inOrder()
        }
        list2 += 2
    }

    @Test
    fun withLater() {
        val list = mutableListOf<Int>()
        withLater(list) {
            assertTrue(isFxThread())
            this += 1
            assertThat(list).containsExactly(2, 1).inOrder()
        }
        list += 2
    }

    @Test
    fun applyLater() {
        val list = mutableListOf<Int>()
        list.applyLater {
            assertTrue(isFxThread())
            this += 1
            assertThat(list).containsExactly(2, 1).inOrder()
        }
        list += 2
    }

    @Test
    fun alsoLater() {
        val list = mutableListOf<Int>()
        list.alsoLater {
            assertTrue(isFxThread())
            it += 1
            assertThat(list).containsExactly(2, 1).inOrder()
        }
        list += 2
    }

    @Test
    fun letLater() {
        val list = mutableListOf<Int>()
        list.letLater {
            assertTrue(isFxThread())
            it += 1
            assertThat(list).containsExactly(2, 1).inOrder()
        }
        list += 2
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
