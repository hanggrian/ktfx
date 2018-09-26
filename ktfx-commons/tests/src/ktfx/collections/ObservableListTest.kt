package ktfx.collections

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ObservableListTest {

    @Test fun emptyObservableList() {
        assertThat(emptyObservableList<Int>()).isEmpty()
    }

    @Test fun observableListOf() {
        assertThat(observableListOf<Int>()).isEmpty()
        assertThat(observableListOf(1)).containsExactly(1).inOrder()
        assertThat(observableListOf(1, 2, 3)).containsExactly(1, 2, 3).inOrder()
    }

    @Test fun mutableObservableListOf() {
        val list1 = mutableObservableListOf<Int>()
        list1 += 1
        list1 += 2
        assertThat(list1).containsExactly(1, 2).inOrder()
        val list2 = mutableObservableListOf(1, 2)
        list2 += 3
        assertThat(list2).containsExactly(1, 2, 3).inOrder()
    }

    @Test fun toObservableList() {
        val list = listOf(1, 2).toObservableList()
        assertThat(list).containsExactly(1, 2).inOrder()
    }

    @Test fun toMutableObservableList() {
        val list = listOf(1, 2).toMutableObservableList()
        list += 3
        assertThat(list).containsExactly(1, 2, 3).inOrder()
    }

    @Test fun toObservableSet() {
        val set = listOf(1, 2, 2).toObservableSet()
        assertThat(set).containsExactly(1, 2).inOrder()
    }

    @Test fun toMutableObservableSet() {
        val set = listOf(1, 2, 2).toMutableObservableSet()
        set += 3
        set += 3
        assertThat(set).containsExactly(1, 2, 3).inOrder()
    }
}