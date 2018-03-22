package ktfx.styles

import javafx.geometry.Insets
import javafx.scene.paint.Color

class RegionStyleBuilder : NodeStyleBuilder() {

    /** A series of paint values separated by commas.. */
    var backgroundColor: Color by map

    /**
     * A series of size values or sets of four size values, separated by commas.
     * A single size value means all insets are the same.
     * Otherwise, the four values for each inset are given in the order top, right, bottom, left.
     * Each comma-separated value or set of values in the series applies to the corresponding background color.
     */
    var backgroundInsets: Insets by map

    /**
     * A series of radius values or sets of four radius values, separated by commas.
     * A single radius value means the radius of all four corners is the same.
     * Otherwise, the four values in the set determine the radii of the top-left, top-right, bottom-right, and
     * bottom-left corners, in that order.
     * Each comma-separated value or set of values in the series applies to the corresponding background color.
     */
    var backgroundRadius: Insets by map

    /** A series of image URIs separated by commas. */
    var backgroundImage: Urls by map

    /**
     * A series of <bg-position> values separated by commas.
     * Each bg-position item in the series applies to the corresponding image in the background-image series.
     */
    @Incubating
    var backgroundPosition: String by map

    /**
     * A series of <repeat-style> values separated by commas.
     * Each repeat-style item in the series applies to the corresponding image in the background-image series.
     */
    @Incubating
    var backgroundRepeat: String by map

    /**
     * A series of <bg-size> values separated by commas.
     * Each bg-size item in the series applies to the corresponding image in the background-image series.
     */
    @Incubating
    var backgroundSize: String by map

    /**
     * A series of paint values or sets of four paint values, separated by commas.
     * For each item in the series, if a single paint value is specified, then that paint is used as the border for all
     * sides of the region; and if a set of four paints is specified, they are used for the top, right, bottom, and left
     * borders of the region, in that order.
     * If the border is not rectangular, only the first paint value in the set is used.
     */
    var borderColor: Color by map

    /**
     * A series of inset or sets of four inset values, separated by commas.
     * For each item in the series, a single inset value means that all insets are the same; and if a set of four inset
     * values is specified, they are used for the top, right, bottom, and left edges of the region, in that order.
     * Each item in the series of insets applies to the corresponding item in the series of border colors.
     */
    var borderInsets: Insets by map

    /**
     * A series of radius or sets of four radius values, separated by commas.
     * For each item in the series, a single radius value means that all corner radii are the same; and if a set of four
     * radius values is specified, they are used as the radii of the top-left, top-right, bottom-right, and bottom-left
     * corners, in that order.
     * Each item in the series of radii applies to the corresponding item in the series of border colors.
     */
    @Incubating
    var borderRadius: String by map

    /**
     * A series of border style values, separated by commas.
     * Each item in the series applies to the corresponding item in the series of border colors.
     *
     * The segments dash-style defines a sequence representing the lengths of the dash segments.
     * Alternate entries in the sequence represent the lengths of the opaque and transparent segments of the dashes.
     * This corresponds to the strokeDashArray variable of Shape.
     *
     * The optional phase parameter defines the point in the dashing pattern that will correspond to the beginning of
     * the stroke.
     * This corresponds to the strokeDashOffset variable of Shape.
     */
    @Incubating
    var borderStyle: String by map

    /**
     * A series of width or sets of four width values, separated by commas.
     * For each item in the series, a single width value means that all border widths are the same; and if a set of four
     * width values is specified, they are used for the top, right, bottom, and left border widths, in that order.
     * If the border is not rectangular, only the first width value is used.
     * Each item in the series of widths applies to the corresponding item in the series of border colors.
     */
    var borderWidth: Number by map

    /** A series of image URIs, separated by commas. */
    var borderImageSource: Urls by map

    /**
     * A series of repeat-style values, separated by commas.
     * Each item in the series applies to the corresponding image in the series of border images.
     */
    @Incubating
    var borderImageRepeat: String by map

    /**
     * A series of image slice values or sets of four values, separated by commas.
     * Each item in the series applies to the corresponding image in the series of border images.
     * For each item in the series, if four values are given, they specify the size of the top, right, bottom, and left
     * slices. This effectively divides the image into nine regions: an upper left corner, a top edge, an upper right
     * corner, a right edge, a lower right corner, a bottom edge, a lower left corner, a left edge and a middle.
     * If one value is specified, this value is used for the slice values for all four edges.
     * If 'fill' is present, the middle slice is preserved, otherwise it is discarded.
     * Percentage values may be used here, in which case the values are considered proportional to the source image.
     */
    @Incubating
    var borderImageSlice: String by map

    /**
     * A series of width or sets of four width values, separated by commas.
     * For each item in the series, a single width value means that all border widths are the same; and if a set of four
     * width values is specified, they are used for the top, right, bottom, and left border widths, in that order.
     * If the border is not rectangular, only the first width value is used. Each item in the series of widths applies
     * to the corresponding item in the series of border images.
     * Percentage values may be used here, in which case the values are considered proportional to the border image area.
     */
    var borderImageWidth: Number by map

    /**
     * A sets of four padding values, separated by commas.
     * For each item in the series, a single padding value means that all padding are the same; and if a set of four
     * padding values is specified, they are used for the top, right, bottom, and left edges of the region, in that
     * order.
     */
    var padding: Insets by map

    /**
     * If true means the shape centered within the region's width and height, otherwise the shape is positioned at its
     * source position.
     * Has no effect if a shape string is not specified.
     */
    var positionShape: Boolean by map

    /**
     * If true means the shape is scaled to fit the size of the region, otherwise the shape is at its source size, and
     * its position depends on the value of the position-shape property.
     * Has no effect if a shape string is not specified.
     */
    var scaleShape: Boolean by map

    /**
     * An SVG path string.
     * By specifying a shape here the region takes on that shape instead of a rectangle or rounded rectangle.
     * The syntax of this path string is specified in [3].
     */
    var shape: String by map

    /**
     * Defines whether this region rounds position/spacing and ceils size values to pixel boundaries when laying out its
     * children.
     */
    var snapToPixel: Boolean by map

    /**
     * This property is set by specifying -fx-background-color, optionally -fx-background-insets, and optionally
     * -fx-background-radius.
     * In order to set the background fill to null, specify the style "-fx-background-color: null;".
     * There is no shorthand notation for -fx-background-fills at this time.
     */
    @Incubating
    var backgroundFills: String by map

    /**
     * This property is set by specifying -fx-background-image, optionally -fx-background-position, optionally
     * -fx-background-repeat, and optionally -fx-background-size.
     * There is no shorthand notation for -fx-background-images at this time.
     */
    @Incubating
    var backgroundImages: String by map

    /**
     * This property is set by specifying -fx-border-color with the optional -fx-border-insets, -fx-border-radius,
     * -fx-border-style and -fx-border-width.
     * There is no shorthand notation for -fx-stroke-borders at this time.
     */
    @Incubating
    var strokeBorders: String by map

    /**
     * This property set by specifying -fx-border-image-source with the optional -fx-border-image-insets,
     * -fx-border-image-repeat, -fx-border-image-slice and -fx-border-image-width.
     * There is no shorthand notation for -fx-image-borders at this time.
     */
    @Incubating
    var imageBorders: String by map
}

inline fun regionStyle(builder: RegionStyleBuilder.() -> Unit): String =
    RegionStyleBuilder().apply(builder).toString()