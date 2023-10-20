@file:JvmName("ControlsfxBordersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.controls

import javafx.scene.Node
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import org.controlsfx.tools.Borders
import kotlin.DeprecationLevel.ERROR

/** Wraps this [Node] with borders using Kotlin DSL, returning the wrapped node. */
fun Node.wrapBorders(builderAction: BordersBuilder.() -> Unit): Node =
    BordersBuilder(this).apply(builderAction).build()

/** Add a new [Borders.EmptyBorders] to node using DSL. */
inline fun Node.wrapEmptyBorder(
    noinline builderAction: BordersBuilder.EmptyBuilder.() -> Unit,
): Node = wrapBorders { empty(builderAction) }

/** Add a new [Borders.EtchedBorders] to node using DSL. */
inline fun Node.wrapEtchedBorder(
    noinline builderAction: BordersBuilder.EtchedBuilder.() -> Unit,
): Node = wrapBorders { etched(builderAction) }

/** Add a new [Borders.LineBorders] to node using DSL. */
inline fun Node.wrapLineBorder(
    noinline builderAction: BordersBuilder.LineBuilder.() -> Unit,
): Node = wrapBorders { line(builderAction) }

/**
 * Supporting class to use [Borders] with DSL.
 *
 * @see Node.wrapBorders
 */
class BordersBuilder internal constructor(node: Node) {
    private val nativeBorders: Borders = Borders.wrap(node)

    /** Opens up DSL to create empty border. */
    fun empty(builderAction: EmptyBuilder.() -> Unit): Unit =
        EmptyBuilder(nativeBorders.emptyBorder()).apply(builderAction).build()

    /** Opens up DSL to create etched border. */
    fun etched(builderAction: EtchedBuilder.() -> Unit): Unit =
        EtchedBuilder(nativeBorders.etchedBorder()).apply(builderAction).build()

    /** Opens up DSL to create line border. */
    fun line(builderAction: LineBuilder.() -> Unit): Unit =
        LineBuilder(nativeBorders.lineBorder()).apply(builderAction).build()

    /** Allows for developers to develop custom [Borders.Border] implementations. */
    fun addBorder(border: Borders.Border) {
        nativeBorders.addBorder(border)
    }

    internal fun build(): Node = nativeBorders.build()

    /** Supporting class to add empty border with DSL. */
    class EmptyBuilder internal constructor(private val nativeBorders: Borders.EmptyBorders) {
        /** Specifies that the wrapped Node should have the given padding around all four sides of itself. */
        var padding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                nativeBorders.padding(value)
            }

        /** Specifies that the wrapped Node should be wrapped with the given padding for each of its four sides */
        fun padding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.padding(top, right, bottom, left)
        }

        var topPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(value, 0.0, 0.0, 0.0)

        var rightPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(0.0, value, 0.0, 0.0)

        var bottomPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(0.0, 0.0, value, 0.0)

        var leftPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(0.0, 0.0, 0.0, value)

        internal fun build() {
            nativeBorders.build()
        }
    }

    abstract class NonEmptyBordersBuilder internal constructor() {
        /** If desired, this specifies the title text to show in this border. */
        abstract var title: String

        /** Specifies the outer padding of the four lines of this border. */
        abstract var outerPadding: Double

        /** Specifies that the line wrapping the node should have outer padding as specified. */
        abstract fun outerPadding(top: Double, right: Double, bottom: Double, left: Double)

        var outerTopPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(value, 0.0, 0.0, 0.0)

        var outerRightPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(0.0, value, 0.0, 0.0)

        var outerBottomPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(0.0, 0.0, value, 0.0)

        var outerLeftPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(0.0, 0.0, 0.0, value)

        /** Specifies the inner padding of the four lines of this border. */
        abstract var innerPadding: Double

        /** Specifies that the line wrapping the node should have inner padding as specified. */
        abstract fun innerPadding(top: Double, right: Double, bottom: Double, left: Double)

        var innerTopPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(value, 0.0, 0.0, 0.0)

        var innerRightPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(0.0, value, 0.0, 0.0)

        var innerBottomPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(0.0, 0.0, value, 0.0)

        var innerLeftPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(0.0, 0.0, 0.0, value)

        /** Specifies the radius of the four corners of the line of this border. */
        abstract var radius: Double

        /** Specifies that the line wrapping the node should have corner radii as specified. */
        abstract fun radius(top: Double, right: Double, bottom: Double, left: Double)
    }

    /** Supporting class to add etched border with DSL. */
    class EtchedBuilder internal constructor(private val nativeBorders: Borders.EtchedBorders) :
        NonEmptyBordersBuilder() {
            /** Specifies the highlight colour to use in the etched border. */
            var highlight: Color
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.highlight(value)
                }

            /** Specifies the shadow colour to use in the etched border. */
            var shadow: Color
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.shadow(value)
                }

            /** Specifies the order in which the highlight and shadow colours are placed. */
            fun raised() {
                nativeBorders.raised()
            }

            override var title: String
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.title(value)
                }

            override var outerPadding: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.outerPadding(value)
                }

            override fun outerPadding(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.outerPadding(top, right, bottom, left)
            }

            override var innerPadding: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.innerPadding(value)
                }

            override fun innerPadding(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.innerPadding(top, right, bottom, left)
            }

            override var radius: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.radius(value)
                }

            override fun radius(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.radius(top, right, bottom, left)
            }

            internal fun build() {
                nativeBorders.build()
            }
        }

    /** Supporting class to add line border with DSL. */
    class LineBuilder internal constructor(private val nativeBorders: Borders.LineBorders) :
        NonEmptyBordersBuilder() {
            /** Specifies the colour to use for all four sides of this border. */
            var color: Color
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.color(value)
                }

            /** Specifies that the wrapped Node should be wrapped with the given colours for each of its four sides. */
            fun color(top: Color, right: Color, bottom: Color, left: Color) {
                nativeBorders.color(top, right, bottom, left)
            }

            /** Specifies which {@link BorderStrokeStyle} to use for this line border. */
            var strokeStyle: BorderStrokeStyle
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.strokeStyle(value)
                }

            override var outerPadding: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.outerPadding(value)
                }

            override fun outerPadding(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.outerPadding(top, right, bottom, left)
            }

            override var innerPadding: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.innerPadding(value)
                }

            override fun innerPadding(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.innerPadding(top, right, bottom, left)
            }

            /** Specifies the thickness of the line to use on all four sides of this border. */
            var thickness: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.thickness(value)
                }

            /** Specifies that the wrapped Node should be wrapped with the given line thickness for each of its four sides. */
            fun thickness(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.thickness(top, right, bottom, left)
            }

            override var radius: Double
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.radius(value)
                }

            override fun radius(top: Double, right: Double, bottom: Double, left: Double) {
                nativeBorders.radius(top, right, bottom, left)
            }

            override var title: String
                @Deprecated(NO_GETTER, level = ERROR)
                get() = noGetter()
                set(value) {
                    nativeBorders.title(value)
                }

            internal fun build() {
                nativeBorders.build()
            }
        }
}
