@file:Suppress("NOTHING_TO_INLINE")

package ktfx.test

import com.google.common.truth.Ordered
import com.google.common.truth.Truth

fun assertContains(actual: Iterable<Any>, vararg expected: Any): Ordered =
    actual().containsExactly(*expected)

fun assertEmpty(actual: Iterable<Any>) =
    actual().isEmpty()

fun assertNotEmpty(actual: Iterable<Any>) =
    actual().isNotEmpty()

private inline operator fun Iterable<Any>.invoke() =
    Truth.assertThat(this)