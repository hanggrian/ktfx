package ktfx.styles

import ktfx.styles.internal._ControlStyleBuilder

interface ControlStyleBuilder {

    /** The class name of the Control's Skin. */
    var skin: String
}

inline fun controlStyle(
    prettyPrint: Boolean = false,
    builder: ControlStyleBuilder .() -> Unit
): String = _ControlStyleBuilder(prettyPrint).apply(builder).toString()