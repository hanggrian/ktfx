@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.testfx

import javafx.scene.Node
import org.hamcrest.Matcher
import org.testfx.api.FxAssert
import org.testfx.service.query.NodeQuery

inline fun <T> assertThat(
    value: T,
    matcher: Matcher<in T>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(value, matcher, errorMessageMapper)

inline fun <T : Node> assertThat(
    node: T,
    nodeMatcher: Matcher<T>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(node, nodeMatcher, errorMessageMapper)

inline fun <T : Node> assertThatIterable(
    nodes: Iterable<T>,
    nodesMatcher: Matcher<Iterable<T>>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThatIter(nodes, nodesMatcher, errorMessageMapper)

inline fun <T : Node> assertThat(
    nodeQuery: String,
    nodeMatcher: Matcher<T>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodeMatcher, errorMessageMapper)

inline fun <T : Node> assertThatIterable(
    nodeQuery: String,
    nodesMatcher: Matcher<Iterable<T>>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThatIter(nodeQuery, nodesMatcher, errorMessageMapper)

inline fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    nodeMatcher: Matcher<T>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodeMatcher, errorMessageMapper)

inline fun <T : Node> assertThatIterable(
    nodeQuery: NodeQuery,
    nodesMatcher: Matcher<Iterable<T>>,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThatIter(nodeQuery, nodesMatcher, errorMessageMapper)

inline fun <T : Node> assertThat(
    node: T,
    noinline nodePredicate: (T) -> Boolean,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(node, nodePredicate, errorMessageMapper)

inline fun <T : Node> assertThat(
    nodeQuery: String,
    noinline nodePredicate: (T) -> Boolean,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodePredicate, errorMessageMapper)

inline fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    noinline nodePredicate: (T) -> Boolean,
    noinline errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodePredicate, errorMessageMapper)
