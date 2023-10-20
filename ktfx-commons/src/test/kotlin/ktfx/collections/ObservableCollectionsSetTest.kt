package ktfx.collections

import com.hendraanggrian.ktfx.test.CollectionTest
import javafx.collections.ObservableSet

class ObservableCollectionsSetTest : CollectionTest<ObservableSet<String>>() {
    override fun empty(): ObservableSet<String> = emptyObservableSet()

    override fun of(): ObservableSet<String> = observableSetOf()

    override fun of(value: String): ObservableSet<String> = observableSetOf(value)

    override fun of(vararg values: String): ObservableSet<String> = observableSetOf(*values)

    override fun mutableOf(): ObservableSet<String> = mutableObservableSetOf()

    override fun mutableOf(vararg values: String): ObservableSet<String> =
        mutableObservableSetOf(*values)

    override fun Array<String>.to(): ObservableSet<String> = toObservableSet()

    override fun List<String>.to(): ObservableSet<String> = toObservableSet()

    override fun Sequence<String>.to(): ObservableSet<String> = toObservableSet()

    override fun Array<String>.toMutable(): ObservableSet<String> = toMutableObservableSet()

    override fun List<String>.toMutable(): ObservableSet<String> = toMutableObservableSet()

    override fun Sequence<String>.toMutable(): ObservableSet<String> = toMutableObservableSet()
}
