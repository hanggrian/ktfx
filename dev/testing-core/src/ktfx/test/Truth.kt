package ktfx.test

import com.google.common.truth.Ordered
import com.google.common.truth.Truth

fun <T> assertContains(actual: Iterable<T>, vararg expected: T): Ordered =
    Truth.assertThat(actual).containsExactly(*expected)