package ktfx.styles

interface TitledPaneStyleBuilder {

    var animated: Boolean

    var collapsible: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _TitledPaneStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint),
    TitledPaneStyleBuilder {
    override var animated: Boolean by map
    override var collapsible: Boolean by map
}

inline fun titledPaneStyle(
    prettyPrint: Boolean = false,
    builder: TitledPaneStyleBuilder .() -> Unit
): String = _TitledPaneStyleBuilder(prettyPrint).apply(builder).toString()