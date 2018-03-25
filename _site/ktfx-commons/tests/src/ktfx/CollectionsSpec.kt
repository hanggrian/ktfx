package ktfx

import ktfx.collections.toMutableObservableList
import ktfx.collections.toObservableList
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object CollectionsSpec : Spek({

    given("an empty iterable") {
        val iterable = listOf<Int>()
        it("should be unmodifiable list") {
            val list = iterable.toObservableList()
            assertEquals(list.size, 0)
        }
        it("should be modifiable list") {
            val list = iterable.toMutableObservableList()
            list += 1
            list += 2
            list += 3
            assertEquals(list.size, 3)
        }
    }
})