package ktfx.test

import com.google.common.truth.Truth

fun assertContains(actual: Iterable<*>, vararg expected: Any) = Truth.assertThat(actual).containsExactly(*expected)

fun assertEmpty(actual: Iterable<*>) = Truth.assertThat(actual).isEmpty()

fun assertEmpty(actual: Array<*>) = Truth.assertThat(actual).isEmpty()

fun assertNotEmpty(actual: Iterable<*>) = Truth.assertThat(actual).isNotEmpty()

fun assertNotEmpty(actual: Array<*>) = Truth.assertThat(actual).isNotEmpty()

inline fun <reified T> assertInstance(actual: Any) = Truth.assertThat(actual).isInstanceOf(T::class.java)