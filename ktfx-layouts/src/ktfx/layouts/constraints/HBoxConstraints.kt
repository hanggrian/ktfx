@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority

/** [javafx.scene.layout.HBox] constraints. */
interface HBoxConstraints : NodeManager, HGrowConstraints, MarginConstraints {

    override fun Node.reset(): Unit =
        HBox.clearConstraints(this)

    override var Node.hpriority: Priority?
        get() = HBox.getHgrow(this)
        set(value) = HBox.setHgrow(this, value)

    override var Node.margins: Insets?
        get() = HBox.getMargin(this)
        set(value) = HBox.setMargin(this, value)
}
