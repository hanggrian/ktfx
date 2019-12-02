package ktfx.test

import com.google.common.truth.Ordered
import com.google.common.truth.Truth

fun assertContains(actual: Iterable<Any>, vararg expected: Any): Ordered = actual().containsExactly(*expected)

fun assertEmpty(actual: Iterable<Any>): Unit = actual().isEmpty()

fun assertNotEmpty(actual: Iterable<Any>): Unit = actual().isNotEmpty()

inline fun <reified T> assertInstance(actual: Any) = Truth.assertThat(actual).isInstanceOf(T::class.java)

private operator fun Iterable<Any>.invoke() = Truth.assertThat(this)