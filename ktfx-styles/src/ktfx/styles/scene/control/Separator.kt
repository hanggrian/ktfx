package ktfx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.VPos

interface SeparatorStyleBuilder {

    var orientation: Orientation

    var halignment: HPos

    var valignment: VPos
}

@PublishedApi
@Suppress("ClassName")
internal class _SeparatorStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint), SeparatorStyleBuilder {
    override var orientation: Orientation by map
    override var halignment: HPos by map
    override var valignment: VPos by map
}

inline fun separatorStyle(
    prettyPrint: Boolean = false,
    builder: SeparatorStyleBuilder .() -> Unit
): String = _SeparatorStyleBuilder(prettyPrint).apply(builder).toString()