@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.testfx

import javafx.scene.Node
import org.hamcrest.Matcher
import org.testfx.service.query.NodeQuery
import java.util.Optional

/** Stores all given `parentNode` within this NodeQuery. */
inline infix fun NodeQuery.from(parentNode: Node): NodeQuery =
    from(parentNode)

/** Stores all given `parentNodes` within this NodeQuery. */
inline infix fun NodeQuery.from(parentNodes: Collection<Node>): NodeQuery =
    from(parentNodes)

/**
 * Sifts through stored nodes by their id ("#id"), their class (".class"), or the text it has ("text"),
 * depending on the query used, and keeps only those {@code Node}s that meet the query.
 */
inline infix fun NodeQuery.lookup(query: String): NodeQuery =
    lookup(query)

/** Sifts through stored nodes and keeps only those {@code Node}s that match the given matcher. */
inline infix fun <T> NodeQuery.lookup(matcher: Matcher<T>): NodeQuery =
    lookup(matcher)

/** Sifts through stored nodes and keeps only those {@code Node}s that pass the given {@code predicate}. */
inline infix fun <T : Node> NodeQuery.lookup(noinline predicate: (T) -> Boolean): NodeQuery =
    lookup(predicate)

/** Sifts through stored nodes and keeps only those {@code Node}s that match the given matcher. */
inline infix fun <T> NodeQuery.match(matcher: Matcher<T>): NodeQuery =
    match(matcher)

/** Sifts through stored nodes and keeps only those {@code Node}s that pass the given predicate. */
inline infix fun <T : Node> NodeQuery.match(noinline predicate: (T) -> Boolean): NodeQuery =
    match(predicate)

/** Keeps the nth {@code Node} in stored nodes and removes all others. */
inline infix fun NodeQuery.nth(index: Int): NodeQuery =
    nth(index)

inline fun <reified T : Node> NodeQuery.queryAs(): T = queryAs(T::class.java)

inline fun <reified T : Node> NodeQuery.tryQueryAs(): Optional<T> = tryQueryAs(T::class.java)

inline fun <reified T : Node> NodeQuery.queryAllAs(): Set<T> = queryAllAs(T::class.java)