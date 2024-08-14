@file:JvmName("ControlsfxBordersKt")

package ktfx.controlsfx.controls

import javafx.scene.Node
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter
import org.controlsfx.tools.Borders
import kotlin.DeprecationLevel.ERROR

/** Wraps this [Node] with borders using Kotlin DSL, returning the wrapped node. */
public inline fun Node.wrapBorders(builderAction: BordersBuilder.() -> Unit): Node =
    BordersBuilder(this).apply(builderAction).build()

/** Add a new [Borders.EmptyBorders] to node using DSL. */
public fun Node.wrapEmptyBorder(builderAction: BordersBuilder.EmptyBuilder.() -> Unit): Node =
    wrapBorders { empty(builderAction) }

/** Add a new [Borders.EtchedBorders] to node using DSL. */
public fun Node.wrapEtchedBorder(builderAction: BordersBuilder.EtchedBuilder.() -> Unit): Node =
    wrapBorders { etched(builderAction) }

/** Add a new [Borders.LineBorders] to node using DSL. */
public fun Node.wrapLineBorder(builderAction: BordersBuilder.LineBuilder.() -> Unit): Node =
    wrapBorders { line(builderAction) }

/**
 * Supporting class to use [Borders] with DSL.
 *
 * @see Node.wrapBorders
 */
public class BordersBuilder(node: Node) {
    private val nativeBorders: Borders = Borders.wrap(node)

    /** Opens up DSL to create empty border. */
    public fun empty(builderAction: EmptyBuilder.() -> Unit): Unit =
        EmptyBuilder(nativeBorders.emptyBorder()).apply(builderAction).build()

    /** Opens up DSL to create etched border. */
    public fun etched(builderAction: EtchedBuilder.() -> Unit): Unit =
        EtchedBuilder(nativeBorders.etchedBorder()).apply(builderAction).build()

    /** Opens up DSL to create line border. */
    public fun line(builderAction: LineBuilder.() -> Unit): Unit =
        LineBuilder(nativeBorders.lineBorder()).apply(builderAction).build()

    /** Allows for developers to develop custom [Borders.Border] implementations. */
    public fun addBorder(border: Borders.Border) {
        nativeBorders.addBorder(border)
    }

    public fun build(): Node = nativeBorders.build()

    /** Supporting class to add empty border with DSL. */
    public class EmptyBuilder(private val nativeBorders: Borders.EmptyBorders) {
        /**
         * Specifies that the wrapped Node should have the given padding around all four sides of
         * itself.
         */
        public var padding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                nativeBorders.padding(value)
            }

        /**
         * Specifies that the wrapped Node should be wrapped with the given padding for each of its
         * four sides.
         */
        public fun padding(top: Double, right: Double, bottom: Double, left: Double) {
            nativeBorders.padding(top, right, bottom, left)
        }

        public var topPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(value, 0.0, 0.0, 0.0)

        public var rightPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(0.0, value, 0.0, 0.0)

        public var bottomPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(0.0, 0.0, value, 0.0)

        public var leftPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = padding(0.0, 0.0, 0.0, value)

        internal fun build() {
            nativeBorders.build()
        }
    }

    public abstract class NonEmptyBordersBuilder {
        /** If desired, this specifies the title text to show in this border. */
        public abstract var title: String

        /** Specifies the outer padding of the four lines of this border. */
        public abstract var outerPadding: Double

        /** Specifies the inner padding of the four lines of this border. */
        public abstract var innerPadding: Double

        /** Specifies the radius of the four corners of the line of this border. */
        public abstract var radius: Double

        /** Specifies that the line wrapping the node should have outer padding as specified. */
        public abstract fun outerPadding(top: Double, right: Double, bottom: Double, left: Double)

        /** Specifies that the line wrapping the node should have inner padding as specified. */
        public abstract fun innerPadding(top: Double, right: Double, bottom: Double, left: Double)

        public var outerTopPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(value, 0.0, 0.0, 0.0)

        public var outerRightPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(0.0, value, 0.0, 0.0)

        public var outerBottomPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(0.0, 0.0, value, 0.0)

        public var outerLeftPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = outerPadding(0.0, 0.0, 0.0, value)

        public var innerTopPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(value, 0.0, 0.0, 0.0)

        public var innerRightPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(0.0, value, 0.0, 0.0)

        public var innerBottomPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(0.0, 0.0, value, 0.0)

        public var innerLeftPadding: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            inline set(value) = innerPadding(0.0, 0.0, 0.0, value)

        /** Specifies that the line wrapping the node should have corner radii as specified. */
        public abstract fun radius(top: Double, right: Double, bottom: Double, left: Double)
    }

    /** Supporting class to add etched border with DSL. */
    public class EtchedBuilder(private val nativeBorders: Borders.EtchedBorders) :
        NonEmptyBordersBuilder() {
        /** Specifies the highlight colour to use in the etched border. */
        public var highlight: Color
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                nativeBorders.highlight(value)
            }

        /** Specifies the shadow colour to use in the etched border. */
        public var shadow: Color
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                nativeBorders.shadow(value)
            }

        /** Specifies the order in which the highlight and shadow colours are placed. */
        public fun raised() {
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
    public class LineBuilder(private val nativeBorders: Borders.LineBorders) :
        NonEmptyBordersBuilder() {
        /** Specifies the colour to use for all four sides of this border. */
        public var color: Color
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                nativeBorders.color(value)
            }

        /**
         * Specifies that the wrapped Node should be wrapped with the given colours for each of
         * its four sides.
         */
        public fun color(top: Color, right: Color, bottom: Color, left: Color) {
            nativeBorders.color(top, right, bottom, left)
        }

        /** Specifies which {@link BorderStrokeStyle} to use for this line border. */
        public var strokeStyle: BorderStrokeStyle
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
        public var thickness: Double
            @Deprecated(NO_GETTER, level = ERROR)
            get() = noGetter()
            set(value) {
                nativeBorders.thickness(value)
            }

        /**
         * Specifies that the wrapped Node should be wrapped with the given line thickness for
         * each of its four sides.
         */
        public fun thickness(top: Double, right: Double, bottom: Double, left: Double) {
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
