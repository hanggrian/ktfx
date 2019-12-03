package ktfx.test

import com.google.common.truth.Truth

fun assertContains(actual: Iterable<Any>, vararg expected: Any) = Truth.assertThat(actual).containsExactly(*expected)

fun assertEmpty(actual: Iterable<Any>) = Truth.assertThat(actual).isEmpty()

fun assertNotEmpty(actual: Iterable<Any>) = Truth.assertThat(actual).isNotEmpty()

inline fun <reified T> assertInstance(actual: Any) = Truth.assertThat(actual).isInstanceOf(T::class.java)