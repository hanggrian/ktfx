package ktfx.controlsfx

import javafx.scene.Node
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import ktfx.internal.KtfxInternals
import org.controlsfx.tools.Borders

class BordersBuilder internal constructor(node: Node) {
    private val nativeBorders: Borders = Borders.wrap(node)

    /** Opens up DSL to create empty border. */
    fun emptyBorder(builder: EmptyBordersBuilder.() -> Unit): Unit =
        EmptyBordersBuilder(nativeBorders.emptyBorder()).apply(builder).build()

    /** Opens up DSL to create etched border. */
    fun etchedBorder(builder: EtchedBordersBuilder.() -> Unit): Unit =
        EtchedBordersBuilder(nativeBorders.etchedBorder()).apply(builder).build()

    /** Opens up DSL to create line border. */
    fun lineBorder(builder: LineBordersBuilder.() -> Unit): Unit =
        LineBordersBuilder(nativeBorders.lineBorder()).apply(builder).build()

    /** Allows for developers to develop custom [Borders.Border] implementations. */
    fun addBorder(border: Borders.Border) {
        nativeBorders.addBorder(border)
    }

    internal fun build(): Node = nativeBorders.build()

    class EmptyBordersBuilder internal constructor(private val nativeBorders: Borders.EmptyBorders) {
        /** Specifies that the wrapped Node should have the given padding around all four sides of itself. */
        var padding: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.padding(value)
            }

        /** Specifies that the wrapped Node should be wrapped with the given padding for each of its four sides */
        fun padding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.padding(top, right, bottom, left)
        }

        inline var paddingTop: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = padding(value, 0.0, 0.0, 0.0)

        inline var paddingRight: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = padding(0.0, value, 0.0, 0.0)

        inline var paddingBottom: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = padding(0.0, 0.0, value, 0.0)

        inline var paddingLeft: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = padding(0.0, 0.0, 0.0, value)

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

        inline var outerPaddingTop: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = outerPadding(value, 0.0, 0.0, 0.0)

        inline var outerPaddingRight: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = outerPadding(0.0, value, 0.0, 0.0)

        inline var outerPaddingBottom: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = outerPadding(0.0, 0.0, value, 0.0)

        inline var outerPaddingLeft: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = outerPadding(0.0, 0.0, 0.0, value)

        /** Specifies the inner padding of the four lines of this border. */
        abstract var innerPadding: Double

        /** Specifies that the line wrapping the node should have inner padding as specified. */
        abstract fun innerPadding(top: Double, right: Double, bottom: Double, left: Double)

        inline var innerPaddingTop: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = innerPadding(value, 0.0, 0.0, 0.0)

        inline var innerPaddingRight: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = innerPadding(0.0, value, 0.0, 0.0)

        inline var innerPaddingBottom: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = innerPadding(0.0, 0.0, value, 0.0)

        inline var innerPaddingLeft: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) = innerPadding(0.0, 0.0, 0.0, value)

        /** Specifies the radius of the four corners of the line of this border. */
        abstract var radius: Double

        /** Specifies that the line wrapping the node should have corner radii as specified. */
        abstract fun radius(top: Double, right: Double, bottom: Double, left: Double)
    }

    class EtchedBordersBuilder internal constructor(private val nativeBorders: Borders.EtchedBorders) :
        NonEmptyBordersBuilder() {
        /** Specifies the highlight colour to use in the etched border. */
        var highlight: Color
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.highlight(value)
            }

        /** Specifies the shadow colour to use in the etched border. */
        var shadow: Color
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.shadow(value)
            }

        /** Specifies the order in which the highlight and shadow colours are placed. */
        fun raised() {
            nativeBorders.raised()
        }

        override var title: String
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.title(value)
            }

        override var outerPadding: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.outerPadding(value)
            }

        override fun outerPadding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.outerPadding(top, right, bottom, left)
        }

        override var innerPadding: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.innerPadding(value)
            }

        override fun innerPadding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.innerPadding(top, right, bottom, left)
        }

        override var radius: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
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

    class LineBordersBuilder internal constructor(private val nativeBorders: Borders.LineBorders) :
        NonEmptyBordersBuilder() {
        /** Specifies the colour to use for all four sides of this border. */
        var color: Color
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.color(value)
            }

        /** Specifies that the wrapped Node should be wrapped with the given colours for each of its four sides. */
        fun color(top: Color, right: Color, bottom: Color, left: Color) {
            nativeBorders.color(top, right, bottom, left)
        }

        /** Specifies which {@link BorderStrokeStyle} to use for this line border. */
        var strokeStyle: BorderStrokeStyle
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.strokeStyle(value)
            }

        override var outerPadding: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.outerPadding(value)
            }

        override fun outerPadding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.outerPadding(top, right, bottom, left)
        }

        override var innerPadding: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.innerPadding(value)
            }

        override fun innerPadding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.innerPadding(top, right, bottom, left)
        }

        /** Specifies the thickness of the line to use on all four sides of this border. */
        var thickness: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.thickness(value)
            }

        /** Specifies that the wrapped Node should be wrapped with the given line thickness for each of its four sides. */
        fun thickness(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.thickness(top, right, bottom, left)
        }

        override var radius: Double
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.radius(value)
            }

        override fun radius(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.radius(top, right, bottom, left)
        }

        override var title: String
            @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
            set(value) {
                nativeBorders.title(value)
            }

        internal fun build() {
            nativeBorders.build()
        }
    }
}

/** Wraps this [Node] with borders using Kotlin DSL, returning the wrapped node. */
fun Node.wrapBorders(builder: BordersBuilder.() -> Unit): Node = BordersBuilder(this).apply(builder).build()
