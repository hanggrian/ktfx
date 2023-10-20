@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import ktfx.layouts.NodeContainer

/** [JFXToolbar] with dynamic-layout dsl support. Invoking dsl will add its children. */
open class KtfxJfxToolbar : JFXToolbar() {
    class HBoxConstraints
        @PublishedApi
        internal constructor(private val list: MutableList<Node>) :
        NodeContainer {
            override fun <T : Node> addChild(child: T): T = child.also { list += it }

            /** Children horizontal grow priority in this layout. */
            inline var Node.hgrow: Priority?
                @JvmName("getHgrow2")
                get() = HBox.getHgrow(this)

                @JvmName("setHgrow2")
                set(value) = HBox.setHgrow(this, value)

            /** Configure [hgrow] fluidly. */
            fun <T : Node> T.hgrow(always: Boolean = true): T {
                hgrow = if (always) Priority.ALWAYS else Priority.NEVER
                return this
            }

            /** Children margin in this layout. */
            inline var Node.margin: Insets?
                @JvmName("getMargin2")
                get() = getMargin(this)

                @JvmName("setMargin2")
                set(value) = setMargin(this, value)

            /** Configure [margin] fluidly. */
            fun <T : Node> T.margin(insets: Insets): T {
                margin = insets
                return this
            }

            /** Clear children constraints. */
            @JvmName("clearConstraints2")
            inline fun Node.clearConstraints(): Unit = HBox.clearConstraints(this)
        }
}
