package ktfx.styles

open class ControlStyleBuilder : NodeStyleBuilder() {

    /** The class name of the Control's Skin. */
    var skin: String by map
}

inline fun controlStyle(builder: ControlStyleBuilder .() -> Unit): String =
    ControlStyleBuilder().apply(builder).toString()