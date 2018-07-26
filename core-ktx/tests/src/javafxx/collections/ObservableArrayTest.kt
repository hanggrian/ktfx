package javafxx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ObservableArrayTest {

    private val array = arrayOf(1, 2, 2, 3)

    @Test fun toObservableList() {
        val list = array.toObservableList()
        assertThat(list).containsExactly(1, 2, 2, 3).inOrder()
    }

    @Test fun toMutableObservableList() {
        val list = array.toMutableObservableList()
        list += 4
        assertThat(list).containsExactly(1, 2, 2, 3, 4).inOrder()
    }

    @Test fun toObservableSet() {
        val set = array.toObservableSet()
        assertThat(set).containsExactly(1, 2, 3).inOrder()
    }

    @Test fun toMutableObservableSet() {
        val set = array.toMutableObservableSet()
        set += 3
        set += 4
        assertThat(set).containsExactly(1, 2, 3, 4).inOrder()
    }
}