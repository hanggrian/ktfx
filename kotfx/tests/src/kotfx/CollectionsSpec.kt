package kotfx

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class CollectionsSpec : Spek({

    given("an empty iterable") {
        val iterable = listOf<String>()

        val mutableList = iterable.toObservableList()
        it("should be unmodifiable list") {
            assertEquals(mutableList.size, 0)
        }

        val list = iterable.toMutableObservableList()
        it("should be modifiable list") {
            assertEquals(list.size, 0)
        }
    }
})