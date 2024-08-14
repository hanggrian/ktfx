@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@PublishedApi
internal class NodeContainerImpl : NodeContainer {
    val children: MutableList<Node> = mutableListOf()

    override fun <T : Node> addChild(child: T): T = child.also { children += it }
}

/**
 * Configure [JFXScrollPane] top bar.
 *
 * @param configuration the configuration block.
 */
public inline fun JFXScrollPane.topBar(
    configuration: (@KtfxLayoutDslMarker NodeContainer).() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    topBar.children.addAll(NodeContainerImpl().apply(configuration).children)
}

/**
 * Configure [JFXScrollPane] mid bar.
 *
 * @param configuration the configuration block.
 */
public inline fun JFXScrollPane.midBar(
    configuration: (@KtfxLayoutDslMarker NodeContainer).() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    midBar.children.addAll(NodeContainerImpl().apply(configuration).children)
}

/**
 * Configure [JFXScrollPane] bottom bar.
 *
 * @param configuration the configuration block.
 */
public inline fun JFXScrollPane.bottomBar(
    configuration: (@KtfxLayoutDslMarker NodeContainer).() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    bottomBar.children.addAll(NodeContainerImpl().apply(configuration).children)
}

/**
 * Configure [JFXScrollPane] main header.
 *
 * @param configuration the configuration block.
 */
public inline fun JFXScrollPane.mainHeader(
    configuration: (@KtfxLayoutDslMarker NodeContainer).() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    mainHeader.children.addAll(NodeContainerImpl().apply(configuration).children)
}

/**
 * Configure [JFXScrollPane] condensed header.
 *
 *  @param configuration the configuration block.
 */
public inline fun JFXScrollPane.condensedHeader(
    configuration: (@KtfxLayoutDslMarker NodeContainer).() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    condensedHeader.children.addAll(NodeContainerImpl().apply(configuration).children)
}
