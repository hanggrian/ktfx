package ktfx.styles

interface NumberAxisStyleBuilder {

    /** The value between each major tick mark in data units. */
    var tickUnit: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _NumberAxisStyleBuilder(
    prettyPrint: Boolean
) : _ValueAxisStyleBuilder(prettyPrint), NumberAxisStyleBuilder {
    override var tickUnit: Number by map
}

inline fun numberAxisStyle(
    prettyPrint: Boolean = false,
    builder: NumberAxisStyleBuilder.() -> Unit
): String = _NumberAxisStyleBuilder(prettyPrint).apply(builder).toString()