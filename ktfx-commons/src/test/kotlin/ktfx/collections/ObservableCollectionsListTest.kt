package ktfx.collections

import com.hendraanggrian.ktfx.test.BaseCollectionsTest
import javafx.collections.ObservableList

class ObservableCollectionsListTest : BaseCollectionsTest<ObservableList<String>>() {
    override fun empty(): ObservableList<String> = emptyObservableList()
    override fun of(): ObservableList<String> = observableListOf()
    override fun of(value: String): ObservableList<String> = observableListOf(value)
    override fun of(vararg values: String): ObservableList<String> = observableListOf(*values)
    override fun mutableOf(): ObservableList<String> = mutableObservableListOf()
    override fun mutableOf(vararg values: String): ObservableList<String> =
        mutableObservableListOf(*values)

    override fun Array<String>.to(): ObservableList<String> = toObservableList()
    override fun List<String>.to(): ObservableList<String> = toObservableList()
    override fun Sequence<String>.to(): ObservableList<String> = toObservableList()
    override fun Array<String>.toMutable(): ObservableList<String> = toMutableObservableList()
    override fun List<String>.toMutable(): ObservableList<String> = toMutableObservableList()
    override fun Sequence<String>.toMutable(): ObservableList<String> = toMutableObservableList()
}
