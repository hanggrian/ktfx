package ktfx.test

import kotlin.test.Test

/** All observable array tests must follow this convention. */
abstract class ObservableArrayTest {

    @Test abstract fun observableArrayOf()

    @Test abstract fun toObservableArray()
}

/** All observable collection tests must follow this convention. */
abstract class ObservableCollectionTest {

    @Test abstract fun emptyObservableCollection()

    @Test abstract fun observableCollectionOf()

    @Test abstract fun mutableObservableCollectionOf()

    @Test abstract fun toObservableCollection()

    @Test abstract fun toMutableObservableCollection()
}
