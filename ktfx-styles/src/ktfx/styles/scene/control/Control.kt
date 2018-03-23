package ktfx.styles

open class ControlStyleBuilder(prettyPrint: Boolean) : NodeStyleBuilder(prettyPrint) {

    /** The class name of the Control's Skin. */
    var skin: String by map
}

inline fun controlStyle(
    prettyPrint: Boolean = false,
    builder: ControlStyleBuilder .() -> Unit
): String = ControlStyleBuilder(prettyPrint).apply(builder).toString()