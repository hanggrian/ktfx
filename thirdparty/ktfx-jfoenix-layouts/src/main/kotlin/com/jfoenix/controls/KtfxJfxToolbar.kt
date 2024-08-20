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
public open class KtfxJfxToolbar : JFXToolbar() {
    public class HBoxConstraints
        @PublishedApi
        internal constructor(
            private val nodes: MutableList<Node>,
        ) : NodeContainer {
            override fun <T : Node> addChild(child: T): T = child.also { nodes += it }

            /** Children horizontal grow priority in this layout. */
            public inline var Node.hgrow: Priority?
                @JvmName("getHgrow2")
                get() = HBox.getHgrow(this)

                @JvmName("setHgrow2")
                set(value) = HBox.setHgrow(this, value)

            /** Configure [hgrow] fluidly. */
            public fun <T : Node> T.hgrow(always: Boolean = true): T {
                hgrow = if (always) Priority.ALWAYS else Priority.NEVER
                return this
            }

            /** Children margin in this layout. */
            public inline var Node.margin: Insets?
                @JvmName("getMargin2")
                get() = HBox.getMargin(this)

                @JvmName("setMargin2")
                set(value) = HBox.setMargin(this, value)

            /** Configure [margin] fluidly. */
            public fun <T : Node> T.margin(insets: Insets): T {
                margin = insets
                return this
            }

            /** Clear children constraints. */
            @JvmName("clearConstraints2")
            public inline fun Node.clearConstraints(): Unit = HBox.clearConstraints(this)
        }
}
