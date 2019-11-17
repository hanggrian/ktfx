@file:Suppress("NOTHING_TO_INLINE")

package ktfx.test

import javafx.scene.Node
import org.hamcrest.Matcher
import org.testfx.api.FxAssert
import org.testfx.service.query.NodeQuery

/** Verify that [value] matches [matcher], displaying [errorMessageMapper] when assertion fails. */
fun <T> assertThat(
    value: T,
    matcher: Matcher<in T>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(value, matcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T> assertThat(
    value: T,
    matcher: Matcher<in T>,
    errorMessage: String
): Unit = assertThat(value, matcher, { append(errorMessage) })

/** Verify that [node] matches [nodeMatcher], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThat(
    node: T,
    nodeMatcher: Matcher<in T>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(node, nodeMatcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThat(
    node: T,
    nodeMatcher: Matcher<in T>,
    errorMessage: String
): Unit = assertThat(node, nodeMatcher, { append(errorMessage) })

/** Verify that [nodes] matches [nodesMatcher], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThatNodes(
    nodes: Iterable<T>,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThatIter(nodes, nodesMatcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThatNodes(
    nodes: Iterable<T>,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessage: String
): Unit = assertThatNodes(nodes, nodesMatcher, { append(errorMessage) })

/** Verify that [nodeQuery] matches [nodeMatcher], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThat(
    nodeQuery: String,
    nodeMatcher: Matcher<T>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(nodeQuery, nodeMatcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThat(
    nodeQuery: String,
    nodeMatcher: Matcher<T>,
    errorMessage: String
): Unit = assertThat(nodeQuery, nodeMatcher, { append(errorMessage) })

/** Verify that [nodeQuery] matches [nodesMatcher], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThatNodes(
    nodeQuery: String,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThatIter(nodeQuery, nodesMatcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThatNodes(
    nodeQuery: String,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessage: String
): Unit = assertThatNodes(nodeQuery, nodesMatcher, { append(errorMessage) })

/** Verify that [nodeQuery] matches [nodeMatcher], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    nodeMatcher: Matcher<T>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(nodeQuery, nodeMatcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    nodeMatcher: Matcher<T>,
    errorMessage: String
): Unit = assertThat(nodeQuery, nodeMatcher, { append(errorMessage) })

/** Verify that [nodeQuery] matches [nodesMatcher], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThatNodes(
    nodeQuery: NodeQuery,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThatIter(nodeQuery, nodesMatcher, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThatNodes(
    nodeQuery: NodeQuery,
    nodesMatcher: Matcher<Iterable<T>>,
    errorMessage: String
): Unit = assertThatNodes(nodeQuery, nodesMatcher, { append(errorMessage) })

/** Verify that [node] matches [nodePredicate], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThat(
    node: T,
    nodePredicate: (T) -> Boolean,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(node, nodePredicate, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThat(
    node: T,
    noinline nodePredicate: (T) -> Boolean,
    errorMessage: String
): Unit = assertThat(node, nodePredicate, { append(errorMessage) })

/** Verify that [nodeQuery] matches [nodePredicate], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThat(
    nodeQuery: String,
    nodePredicate: (T) -> Boolean,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(nodeQuery, nodePredicate, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThat(
    nodeQuery: String,
    noinline nodePredicate: (T) -> Boolean,
    errorMessage: String
): Unit = assertThat(nodeQuery, nodePredicate, { append(errorMessage) })

/** Verify that [nodeQuery] matches [nodePredicate], displaying [errorMessageMapper] when assertion fails. */
fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    nodePredicate: (T) -> Boolean,
    errorMessageMapper: StringBuilder.() -> StringBuilder = { this }
): Unit = FxAssert.verifyThat(nodeQuery, nodePredicate, errorMessageMapper)

/** Convenient method to supply simple [errorMessage] string. */
inline fun <T : Node> assertThat(
    nodeQuery: NodeQuery,
    noinline nodePredicate: (T) -> Boolean,
    errorMessage: String
): Unit = assertThat(nodeQuery, nodePredicate, { append(errorMessage) })
