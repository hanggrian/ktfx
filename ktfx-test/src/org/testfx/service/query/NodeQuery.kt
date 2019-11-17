@file:Suppress("NOTHING_TO_INLINE")

package ktfx.test

import java.util.Optional
import javafx.scene.Node
import kotlin.reflect.KClass
import org.hamcrest.Matcher
import org.testfx.service.query.NodeQuery

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

/** Sifts through stored nodes and keeps only those `Node`s that match the given matcher. */
inline infix fun <T> NodeQuery.lookup(matcher: Matcher<T>): NodeQuery =
    lookup(matcher)

/** Sifts through stored nodes and keeps only those `Node`s that pass the given {@code predicate}. */
inline infix fun <T : Node> NodeQuery.lookup(noinline predicate: (T) -> Boolean): NodeQuery =
    lookup(predicate)

/** Sifts through stored nodes and keeps only those `Node`s that match the given matcher. */
inline infix fun <T> NodeQuery.match(matcher: Matcher<T>): NodeQuery =
    match(matcher)

/** Sifts through stored nodes and keeps only those `Node`s that pass the given predicate. */
inline infix fun <T : Node> NodeQuery.match(noinline predicate: (T) -> Boolean): NodeQuery =
    match(predicate)

/** Keeps the nth `Node` in stored nodes and removes all others. */
inline infix fun NodeQuery.nth(index: Int): NodeQuery =
    nth(index)

inline fun <T : Node> NodeQuery.queryAs(type: KClass<T>): T =
    queryAs(type.java)

/** Alias of [queryAs] with reified type. */
inline fun <reified T : Node> NodeQuery.queryAs(): T =
    queryAs(T::class)

inline fun <T : Node> NodeQuery.tryQueryAs(type: KClass<T>): Optional<T> =
    tryQueryAs(type.java)

/** Alias of [queryAs] with reified type. */
inline fun <reified T : Node> NodeQuery.tryQueryAs(): Optional<T> =
    tryQueryAs(T::class)

inline fun <T : Node> NodeQuery.queryAllAs(type: KClass<T>): Set<T> =
    queryAllAs(type.java)

/** Alias of [queryAs] with reified type. */
inline fun <reified T : Node> NodeQuery.queryAllAs(): Set<T> =
    queryAllAs(T::class)
