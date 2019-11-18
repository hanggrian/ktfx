package ktfx.layouts

import javafx.scene.Node

/** Marks a layout manager with constrained children. */
interface Constraintable {

    val Node.constraints: Constraints
        get() = Constraints(this)

    /** Clear children constraints in this container. */
    fun Constraints.clear()
}
