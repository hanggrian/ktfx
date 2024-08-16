@file:OptIn(ExperimentalContracts::class)

package ktfx.windows

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Get window as [Stage]. */
public inline val Scene.stage: Stage get() = window as Stage

/** Removes old icons and set a new one to this stage. */
public inline var Stage.icon: Image
    get() = icons.first()
    set(value) {
        icons.setAll(value)
    }

/** Sets minimum width and height of this [Stage]. */
public var Stage.minSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        minWidth = value.first.toDouble()
        minHeight = value.second.toDouble()
    }

/** Sets width and height of this [Stage]. */
public var Stage.size2: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        width = value.first.toDouble()
        height = value.second.toDouble()
    }

/** Sets maximum width and height of this [Stage]. */
public var Stage.maxSize: Pair<Number, Number>
    @Deprecated(NO_GETTER, level = ERROR)
    get() = noGetter()
    set(value) {
        maxWidth = value.first.toDouble()
        maxHeight = value.second.toDouble()
    }

/**
 * Creates a stage with options.
 *
 * @param style the style of the stage.
 * @param configuration custom stage action.
 */
public inline fun stage(
    style: StageStyle = StageStyle.DECORATED,
    configuration: Stage.() -> Unit,
): Stage {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Stage(style).apply(configuration)
}
