package ktfx.layouts.internal

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.Priority
import ktfx.internal.KtFXInternals.NO_GETTER
import ktfx.internal.KtFXInternals.noGetter
import kotlin.DeprecationLevel.ERROR

internal interface ConstrainedPane {

    fun Node.clear()
}

internal interface MarginedPane : ConstrainedPane {

    infix fun <N : Node> N.margins(value: Insets?): N = apply { margins = value }

    infix fun <N : Node> N.marginAll(value: Double?) = apply { marginAll = value }

    infix fun <N : Node> N.marginTop(value: Double?): N = apply { marginTop = value }

    infix fun <N : Node> N.marginRight(value: Double?): N = apply { marginRight = value }

    infix fun <N : Node> N.marginBottom(value: Double?): N = apply { marginBottom = value }

    infix fun <N : Node> N.marginLeft(value: Double?): N = apply { marginLeft = value }

    var Node.margins: Insets? // alias for reserved variable `margin`

    var Node.marginAll: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margins = value?.let { Insets(it) }
        }

    var Node.marginTop: Double?
        get() = margins?.top
        set(value) = updateMargin(top = value)

    var Node.marginRight: Double?
        get() = margins?.right
        set(value) = updateMargin(right = value)

    var Node.marginBottom: Double?
        get() = margins?.bottom
        set(value) = updateMargin(bottom = value)

    var Node.marginLeft: Double?
        get() = margins?.left
        set(value) = updateMargin(left = value)

    fun Node.updateMargin(
        top: Double? = marginTop,
        right: Double? = marginRight,
        bottom: Double? = marginBottom,
        left: Double? = marginLeft
    ) {
        margins = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }
}

internal interface AlignedPane : ConstrainedPane {

    infix fun <N : Node> N.pos(value: Pos?): N = apply { pos = value }

    var Node.pos: Pos?
}

internal interface HAlignedPane : ConstrainedPane {

    infix fun <N : Node> N.hpos(value: HPos?): N = apply { hpos = value }

    var Node.hpos: HPos?
}

internal interface VAlignedPane : ConstrainedPane {

    infix fun <N : Node> N.vpos(value: VPos?): N = apply { vpos = value }

    var Node.vpos: VPos?
}

internal interface HGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.hpriority(value: Priority?): N = apply { hpriority = value }

    var Node.hpriority: Priority?
}

internal interface VGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.vpriority(value: Priority?): N = apply { vpriority = value }

    var Node.vpriority: Priority?
}