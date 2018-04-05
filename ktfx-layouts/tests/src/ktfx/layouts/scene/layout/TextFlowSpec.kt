package ktfx.layouts.scene.layout

import ktfx.layouts.textFlow
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(JUnitPlatform::class)
object TextFlowSpec : Spek({

    given("TextFlow") {
        it("textFlow") {
            val textFlow = textFlow()
            assertTrue(textFlow.children.isEmpty())
        }
        it("invoke") {
            val textFlow = textFlow {
                "Hello"()
                "World"()
            }
            assertEquals(textFlow.children.size, 2)
        }
    }
})