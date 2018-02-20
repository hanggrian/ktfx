@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.layout

import javafx.scene.paint.Paint
import javafx.scene.shape.Arc
import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE
import javafx.scene.shape.Circle
import javafx.scene.shape.CubicCurve
import javafx.scene.shape.Cylinder
import javafx.scene.shape.Ellipse
import javafx.scene.shape.Line
import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import javafx.scene.shape.Path
import javafx.scene.shape.PathElement
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.shape.QuadCurve
import javafx.scene.shape.Rectangle
import javafx.scene.shape.SVGPath
import javafx.scene.shape.Sphere
import kotfx.annotations.SceneDsl

inline fun arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }
inline fun ChildManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }.add()
inline fun ItemManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }.add()
inline fun ButtonManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }.add()

inline fun box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }
inline fun ChildManager.box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }.add()
inline fun ItemManager.box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }.add()
inline fun ButtonManager.box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }.add()

inline fun circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }
inline fun ChildManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }.add()
inline fun ItemManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }.add()
inline fun ButtonManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }.add()

inline fun cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }.add()
inline fun ItemManager.cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }.add()
inline fun ButtonManager.cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }.add()

inline fun cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }
inline fun ChildManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }.add()
inline fun ItemManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }.add()
inline fun ButtonManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }.add()

inline fun ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }
inline fun ChildManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }.add()
inline fun ItemManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }.add()
inline fun ButtonManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }.add()

inline fun line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }.add()
inline fun ItemManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }.add()
inline fun ButtonManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }.add()

inline fun meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }
inline fun ChildManager.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()
inline fun ItemManager.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()
inline fun ButtonManager.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()

inline fun path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }
inline fun ChildManager.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()
inline fun ItemManager.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()
inline fun ButtonManager.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()

inline fun polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }
inline fun ChildManager.polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }.add()
inline fun ItemManager.polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }.add()
inline fun ButtonManager.polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }.add()

inline fun polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }
inline fun ChildManager.polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }.add()
inline fun ItemManager.polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }.add()
inline fun ButtonManager.polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }.add()

inline fun quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }.add()
inline fun ItemManager.quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }.add()
inline fun ButtonManager.quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }.add()

inline fun rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }
inline fun ChildManager.rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }.add()
inline fun ItemManager.rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }.add()
inline fun ButtonManager.rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }.add()

inline fun sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }
inline fun ChildManager.sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }.add()
inline fun ItemManager.sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }.add()
inline fun ButtonManager.sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }.add()

inline fun svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }
inline fun ChildManager.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()
inline fun ItemManager.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()
inline fun ButtonManager.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()