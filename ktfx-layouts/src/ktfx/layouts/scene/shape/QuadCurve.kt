@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.QuadCurve

inline fun quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@LayoutDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }

inline fun Manager<Node>.quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@LayoutDsl QuadCurve).() -> Unit)? = null): QuadCurve = ktfx.layouts.quadCurve(startX, startY, controlX, controlY, endX, endY, init).add()