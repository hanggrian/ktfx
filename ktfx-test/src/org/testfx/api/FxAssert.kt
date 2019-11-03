@file:Suppress("PackageDirectoryMismatch")

package ktfx.test

import javafx.scene.Node
import org.hamcrest.Matcher
import org.testfx.api.FxAssert
import org.testfx.service.query.NodeQuery

fun <T> assertThat(
    value: T,
    matcher: Matcher<in T>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(value, matcher, errorMessageMapper)

fun <T : Node> assertThat(
    node: T,
    nodeMatcher: Matcher<T>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(node, nodeMatcher, errorMessageMapper)

fun <T : Node> assertThatIterable(
    nodes: Iterable<T>,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThatIter(nodes, nodesMatcher, errorMessageMapper)

fun <T : Node> assertThat(
    nodeQuery: String,
    nodeMatcher: Matcher<T>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodeMatcher, errorMessageMapper)

fun <T : Node> assertThatIterable(
    nodeQuery: String,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThatIter(nodeQuery, nodesMatcher, errorMessageMapper)

fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    nodeMatcher: Matcher<T>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodeMatcher, errorMessageMapper)

fun <T : Node> assertThatIterable(
    nodeQuery: NodeQuery,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThatIter(nodeQuery, nodesMatcher, errorMessageMapper)

fun <T : Node> assertThat(
    node: T,
    nodePredicate: (T) -> Boolean,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(node, nodePredicate, errorMessageMapper)

fun <T : Node> assertThat(
    nodeQuery: String,
    nodePredicate: (T) -> Boolean,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodePredicate, errorMessageMapper)

fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    nodePredicate: (T) -> Boolean,
    errorMessageMapper: (StringBuilder) -> StringBuilder = { it }
): Unit = FxAssert.verifyThat(nodeQuery, nodePredicate, errorMessageMapper)
