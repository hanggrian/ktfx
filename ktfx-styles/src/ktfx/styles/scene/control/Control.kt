package ktfx.styles

interface ControlStyleBuilder {

    /** The class name of the Control's Skin. */
    var skin: String
}

@Suppress("ClassName")
open class _ControlStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), ControlStyleBuilder {
    override var skin: String by map
}

inline fun controlStyle(
    prettyPrint: Boolean = false,
    builder: ControlStyleBuilder .() -> Unit
): String = _ControlStyleBuilder(prettyPrint).apply(builder).toString()