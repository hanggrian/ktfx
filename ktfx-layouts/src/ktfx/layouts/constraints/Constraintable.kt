package ktfx.layouts

import javafx.scene.Node

/** Marks a layout manager with constrained children. */
interface Constraintable {

    /** Returns children constraints. */
    val Node.constraints: Constraints
        get() = Constraints(this)

    /** Clear children constraints. */
    fun Constraints.clear()
}
