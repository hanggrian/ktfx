package ktfx.test

import com.google.common.truth.Ordered
import com.google.common.truth.Truth

fun assertContains(actual: Iterable<Any>, vararg expected: Any): Ordered = actual().containsExactly(*expected)

fun assertEmpty(actual: Iterable<Any>) = actual().isEmpty()

fun assertNotEmpty(actual: Iterable<Any>) = actual().isNotEmpty()

private operator fun Iterable<Any>.invoke() = Truth.assertThat(this)