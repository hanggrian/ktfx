@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.HBoxConstraintable
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXToolbar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXToolbar : JFXToolbar() {

    fun leftItems(init: HBoxConstraintable.() -> Unit): Unit =
        HBoxConstraintableImpl(leftItems).init()

    fun rightItems(init: HBoxConstraintable.() -> Unit): Unit =
        HBoxConstraintableImpl(rightItems).init()

    private class HBoxConstraintableImpl(list: MutableList<Node>) : HBoxConstraintable, MutableList<Node> by list {
        override fun <T : Node> addNode(node: T): T = node.also { this += it }
    }
}

/** Create a [JFXToolbar] with initialization block. */
inline fun jfxToolbar(
    init: KtfxJFXToolbar.() -> Unit
): JFXToolbar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXToolbar().apply(init)
}

/** Add a [JFXToolbar] to this manager. */
fun NodeManager.jfxToolbar(): JFXToolbar =
    addNode(KtfxJFXToolbar())

/** Add a [JFXToolbar] with initialization block to this manager. */
inline fun NodeManager.jfxToolbar(
    init: KtfxJFXToolbar.() -> Unit
): JFXToolbar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXToolbar(), init)
}
