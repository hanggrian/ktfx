package kotfx

import kotfx.properties.toProperty
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@RunWith(JUnitPlatform::class)
object PropertiesSpec : Spek({

    given("2 properties") {
        val textProperty = "".toProperty()
        val intProperty1 = 0.toProperty()
        val intProperty2 = 10.toProperty()


        it("has binded value") {
            textProperty.bind(intProperty1.asString())
            textProperty.bind(intProperty2.asString())

            assertTrue(textProperty.isBound)
            assertFalse(intProperty1.isBound)
            assertEquals(textProperty.get(), "10")

            intProperty2.set(5)
            assertEquals(textProperty.get(), "5")
        }
    }
})