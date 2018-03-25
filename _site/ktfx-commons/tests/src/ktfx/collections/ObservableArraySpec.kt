package ktfx.collections

import com.google.common.truth.Truth.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
object ObservableArraySpec : Spek({

    given("an array") {
        val array = arrayOf(1, 2, 2, 3)
        it("toObservableList") {
            val list = array.toObservableList()
            assertThat(list).containsExactly(1, 2, 2, 3).inOrder()
        }
        it("toMutableObservableList") {
            val list = array.toMutableObservableList()
            list += 4
            assertThat(list).containsExactly(1, 2, 2, 3, 4).inOrder()
        }
        it("toObservableSet") {
            val set = array.toObservableSet()
            assertThat(set).containsExactly(1, 2, 3).inOrder()
        }
        it("toMutableObservableSet") {
            val set = array.toMutableObservableSet()
            set += 3
            set += 4
            assertThat(set).containsExactly(1, 2, 3, 4).inOrder()
        }
    }
})