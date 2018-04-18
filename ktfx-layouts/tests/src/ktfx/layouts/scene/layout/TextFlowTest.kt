package ktfx.layouts.scene.layout

import ktfx.application.initToolkit
import ktfx.layouts.textFlow
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TextFlowTest {

    @Before fun init() = initToolkit()

    @Test fun textFlow() {
        val textFlow = ktfx.layouts.textFlow()
        assertTrue(textFlow.children.isEmpty())
    }

    @Test fun invoke() {
        val textFlow = textFlow {
            "Hello"()
            "World"()
        }
        assertEquals(textFlow.children.size, 2)
    }
}