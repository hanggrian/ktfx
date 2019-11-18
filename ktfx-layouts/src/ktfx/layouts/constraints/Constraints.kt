package ktfx.layouts

import javafx.scene.Node

/**
 * Children layout configuration within a constraintable parent.
 * Since it contains no logic, subtype of this class should also provide related constraining implementation.
 *
 * @param node constrained children.
 */
class Constraints internal constructor(internal val node: Node)
