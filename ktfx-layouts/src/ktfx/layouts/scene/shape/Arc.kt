@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Arc

/** Creates a [Arc]. */
fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: ((@LayoutMarker Arc).() -> Unit)? = null
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).also { init?.invoke(it) }

/** Creates a [Arc] and add it to this manager. */
inline fun NodeInvokable.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    noinline init: ((@LayoutMarker Arc).() -> Unit)? = null
): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init)()