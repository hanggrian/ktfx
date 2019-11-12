package ktfx.layouts

import javafx.scene.Node

/** Marks a layout manager with constrained children. */
interface Constraints {

    /** Clear children constraints in this container. */
    fun Node.removeConstraints()
}
