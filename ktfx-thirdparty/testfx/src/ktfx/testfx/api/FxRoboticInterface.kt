@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.testfx

import javafx.geometry.Bounds
import javafx.geometry.HorizontalDirection
import javafx.geometry.Point2D
import javafx.geometry.Pos
import javafx.geometry.VerticalDirection
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.MouseButton
import javafx.stage.Window
import org.hamcrest.Matcher
import org.testfx.api.FxRobotContext
import org.testfx.api.FxRobotException
import org.testfx.api.FxRobotInterface
import org.testfx.robot.ClickRobot
import org.testfx.robot.DragRobot
import org.testfx.robot.KeyboardRobot
import org.testfx.robot.MoveRobot
import org.testfx.robot.ScrollRobot
import org.testfx.robot.SleepRobot
import org.testfx.robot.TypeRobot
import org.testfx.robot.WriteRobot
import org.testfx.service.finder.NodeFinder
import org.testfx.service.finder.WindowFinder
import org.testfx.service.locator.PointLocator
import org.testfx.service.query.BoundsQuery
import org.testfx.service.query.NodeQuery
import org.testfx.service.query.PointQuery
import org.testfx.util.BoundsQueryUtils
import org.testfx.util.WaitForAsyncUtils
import java.util.regex.Pattern

/** Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(window: Window): FxRobotInterface =
    targetWindow(window)

/** Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(noinline predicate: (Window) -> Boolean): FxRobotInterface =
    targetWindow(predicate)

/** Convenience method: Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(windowIndex: Int): FxRobotInterface =
    targetWindow(windowIndex)

/** Convenience method: Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(stageTitleRegex: String): FxRobotInterface =
    targetWindow(stageTitleRegex)

/** Convenience method: Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(stageTitlePattern: Pattern): FxRobotInterface =
    targetWindow(stageTitlePattern)

/** Convenience method: Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(scene: Scene): FxRobotInterface =
    targetWindow(scene)

/** Convenience method: Calls [WindowFinder.targetWindow] and returns itself for method chaining. */
inline infix fun FxRobotInterface.targetWindow(node: Node): FxRobotInterface =
    targetWindow(node)

/** Calls [NodeFinder.from] and returns itself for method chaining. */
inline infix fun FxRobotInterface.from(parentNode: Node): NodeQuery =
    from(parentNode)

/** Calls [NodeFinder.from] and returns itself for method chaining. */
inline infix fun FxRobotInterface.from(parentNodes: Collection<Node>): NodeQuery =
    from(parentNodes)

/** Convenience method: Calls [NodeFinder.lookup] and returns itself for method chaining. */
inline infix fun FxRobotInterface.lookup(query: String): NodeQuery =
    lookup(query)

/** Convenience method: Calls [NodeFinder.lookup] and returns itself for method chaining. */
inline infix fun <T : Node> FxRobotInterface.lookup(matcher: Matcher<T>): NodeQuery =
    lookup(matcher)

/** Convenience method: Calls [NodeFinder.lookup] and returns itself for method chaining. */
inline infix fun <T : Node> FxRobotInterface.lookup(noinline predicate: (T) -> Boolean): NodeQuery =
    lookup(predicate)

/** Convenience method: Calls [NodeFinder.from] and returns itself for method chaining. */
inline infix fun FxRobotInterface.from(nodeQuery: NodeQuery): NodeQuery =
    from(nodeQuery)

/** Calls [BoundsQueryUtils.bounds]. */
inline infix fun FxRobotInterface.bounds(point: Point2D): BoundsQuery =
    bounds(point)

/** Creates a [BoundsQuery] that returns the given bounds. */
inline infix fun FxRobotInterface.bounds(bounds: Bounds): BoundsQuery =
    bounds(bounds)

/** Calls [BoundsQueryUtils.boundsOnScreen]. */
inline infix fun FxRobotInterface.bounds(node: Node): BoundsQuery =
    bounds(node)

/** Calls [BoundsQueryUtils.boundsOnScreen] with given scene's bounds. */
inline infix fun FxRobotInterface.bounds(scene: Scene): BoundsQuery =
    bounds(scene)

/** Calls [BoundsQueryUtils.boundsOnScreen] with the given window's bounds. */
inline infix fun FxRobotInterface.bounds(window: Window): BoundsQuery =
    bounds(window)

/** NOT YET IMPLEMENTED */
inline infix fun FxRobotInterface.bounds(query: String): BoundsQuery =
    bounds(query)

/** NOT YET IMPLEMENTED */
inline infix fun <T : Node> FxRobotInterface.bounds(matcher: Matcher<T>): BoundsQuery =
    bounds(matcher)

/** NOT YET IMPLEMENTED */
inline infix fun <T : Node> FxRobotInterface.bounds(noinline predicate: (T) -> Boolean): BoundsQuery =
    bounds(predicate)

/**
 * Stores the given position as the position to be used in all `point()`-related methods
 * such as `point(Node)` and `point(Point2D)`, and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.targetPos(pointPosition: Pos): FxRobotInterface =
    targetPos(pointPosition)

/**
 * Calls [PointLocator.point] and sets the [PointQuery]'s
 * [PointQuery.getPosition] to [FxRobotContext.getPointPosition].
 */
inline infix fun FxRobotInterface.point(point: Point2D): PointQuery =
    point(point)

/**
 * Calls [PointLocator.point] and sets the [PointQuery]'s
 * [PointQuery.getPosition] to [FxRobotContext.getPointPosition].
 */
inline infix fun FxRobotInterface.point(bounds: Bounds): PointQuery =
    point(bounds)

/**
 * Calls [PointLocator.point] and sets the [PointQuery]'s
 * [PointQuery.getPosition] to [FxRobotContext.getPointPosition].
 */
inline infix fun FxRobotInterface.point(node: Node): PointQuery =
    point(node)

/**
 * Calls [PointLocator.point] and sets the [PointQuery]'s
 * [PointQuery.getPosition] to [FxRobotContext.getPointPosition].
 */
inline infix fun FxRobotInterface.point(scene: Scene): PointQuery =
    point(scene)

/**
 * Calls [PointLocator.point] and sets the [PointQuery]'s
 * [PointQuery.getPosition] to [FxRobotContext.getPointPosition].
 */
inline infix fun FxRobotInterface.point(window: Window): PointQuery =
    point(window)

/**
 * Convenience method: Tries to find a given node via [FxRobotInterface.lookup] before calling
 * [FxRobotInterface.point], throwing a [FxRobotException] if no node is found.
 */
inline infix fun FxRobotInterface.point(query: String): PointQuery =
    point(query)

/**
 * Convenience method: Tries to find a given node via [FxRobotInterface.lookup] before calling
 * [FxRobotInterface.point], throwing a [FxRobotException] if no node is found.
 */
inline infix fun <T : Node> FxRobotInterface.point(matcher: Matcher<T>): PointQuery =
    point(matcher)

/**
 * Convenience method: Tries to find a given node via [FxRobotInterface.lookup] before calling
 * [FxRobotInterface.point], throwing a [FxRobotException] if no node is found.
 */
inline infix fun <T : Node> FxRobotInterface.point(noinline predicate: (T) -> Boolean): PointQuery =
    point(predicate)

/** Calls a callable on the FX application thread and waits for it and consecutive events to execute. */
inline infix fun <T> FxRobotInterface.interact(noinline block: () -> T): FxRobotInterface =
    interact(block)

/** Calls a callable on the FX application thread and waits for it to execute. */
inline infix fun <T> FxRobotInterface.interactNoWait(noinline block: () -> T): FxRobotInterface =
    interactNoWait(block)

/** Calls [WaitForAsyncUtils.waitForFxEvents] and returns itself for method chaining. */
inline infix fun FxRobotInterface.interrupt(attemptsCount: Int): FxRobotInterface =
    interrupt(attemptsCount)

/** Calls [SleepRobot.sleep] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.sleep(milliseconds: Long): FxRobotInterface =
    sleep(milliseconds)

/** Calls [ClickRobot.clickOn] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.clickOn(button: MouseButton): FxRobotInterface =
    clickOn(button)

/** Calls [ClickRobot.doubleClickOn] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.doubleClickOn(button: MouseButton): FxRobotInterface =
    doubleClickOn(button)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(pointQuery: PointQuery): FxRobotInterface =
    rightClickOn(pointQuery)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(point: Point2D): FxRobotInterface =
    rightClickOn(point)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(bounds: Bounds): FxRobotInterface =
    rightClickOn(bounds)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(node: Node): FxRobotInterface =
    rightClickOn(node)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(scene: Scene): FxRobotInterface =
    rightClickOn(scene)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(window: Window): FxRobotInterface =
    rightClickOn(window)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.rightClickOn(query: String): FxRobotInterface =
    rightClickOn(query)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun <T : Node> FxRobotInterface.rightClickOn(matcher: Matcher<T>): FxRobotInterface =
    rightClickOn(matcher)

/**
 * Convenience method: Moves mouse directly to the point returned from [PointQuery.query], clicks
 * the [MouseButton.SECONDARY] button and returns itself for method chaining.
 */
inline infix fun <T : Node> FxRobotInterface.rightClickOn(noinline predicate: (T) -> Boolean): FxRobotInterface =
    rightClickOn(predicate)

/** Calls [DragRobot.drag] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.drag(button: MouseButton): FxRobotInterface =
    drag(button)

/** Calls [DragRobot.dropTo] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.dropTo(pointQuery: PointQuery): FxRobotInterface =
    dropTo(pointQuery)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.dropTo(point: Point2D): FxRobotInterface =
    dropTo(point)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.dropTo(bounds: Bounds): FxRobotInterface =
    dropTo(bounds)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.dropTo(node: Node): FxRobotInterface =
    dropTo(node)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.dropTo(scene: Scene): FxRobotInterface =
    dropTo(scene)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.dropTo(window: Window): FxRobotInterface =
    dropTo(window)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun FxRobotInterface.dropTo(query: String): FxRobotInterface =
    dropTo(query)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun <T : Node> FxRobotInterface.dropTo(matcher: Matcher<T>): FxRobotInterface =
    dropTo(matcher)

/**
 * Convenience method: Moves mouse to the point returned from [FxRobotInterface.point], releases the buttons
 * that were pressed in [FxRobotInterface.drag]- or [FxRobotInterface.press]-related methods,
 * and returns itself for method chaining.
 */
inline infix fun <T : Node> FxRobotInterface.dropTo(noinline predicate: (T) -> Boolean): FxRobotInterface =
    dropTo(predicate)

/** Calls [KeyboardRobot.press] and returns itself for method chaining. */
inline infix fun FxRobotInterface.press(key: KeyCode): FxRobotInterface =
    press(key)

/** Calls [KeyboardRobot.press] and returns itself for method chaining. */
inline infix fun FxRobotInterface.release(key: KeyCode): FxRobotInterface =
    release(key)

/** Presses and holds mouse buttons. */
inline infix fun FxRobotInterface.press(button: MouseButton): FxRobotInterface =
    press(button)

/** Releases pressed mouse buttons. */
inline infix fun FxRobotInterface.release(button: MouseButton): FxRobotInterface =
    release(button)

/** Calls [MoveRobot.moveTo] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.moveTo(pointQuery: PointQuery): FxRobotInterface =
    moveTo(pointQuery)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun FxRobotInterface.moveTo(point: Point2D): FxRobotInterface =
    moveTo(point)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun FxRobotInterface.moveTo(bounds: Bounds): FxRobotInterface =
    moveTo(bounds)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun FxRobotInterface.moveTo(node: Node): FxRobotInterface =
    moveTo(node)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun FxRobotInterface.moveTo(scene: Scene): FxRobotInterface =
    moveTo(scene)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun FxRobotInterface.moveTo(window: Window): FxRobotInterface =
    moveTo(window)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun FxRobotInterface.moveTo(query: String): FxRobotInterface =
    moveTo(query)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun <T : Node> FxRobotInterface.moveTo(matcher: Matcher<T>): FxRobotInterface =
    moveTo(matcher)

/**
 * Convenience method: Moves mouse directly to the point returned from [FxRobotInterface.point] and returns itself
 * for method chaining.
 */
inline infix fun <T : Node> FxRobotInterface.moveTo(noinline predicate: (T) -> Boolean): FxRobotInterface =
    moveTo(predicate)

/** Calls [ScrollRobot.scroll] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.scroll(amount: Int): FxRobotInterface =
    scroll(amount)

/** Calls [ScrollRobot.scroll] with arguments `1` and `direction` and returns itself for more method chaining. */
inline infix fun FxRobotInterface.scroll(direction: VerticalDirection): FxRobotInterface =
    scroll(direction)

/** Calls [ScrollRobot.scroll] with arguments `1` and `direction` and returns itself for more method chaining. */
inline infix fun FxRobotInterface.scroll(direction: HorizontalDirection): FxRobotInterface =
    scroll(direction)

/** Calls [TypeRobot.push] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.push(key: KeyCode): FxRobotInterface =
    push(key)

/** Calls [TypeRobot.push] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.push(combination: KeyCodeCombination): FxRobotInterface =
    push(combination)

/** Calls [TypeRobot.type] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.type(key: KeyCode): FxRobotInterface =
    type(key)

/** Convenience method: Calls [TypeRobot.type] with [KeyCode.BACK_SPACE] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.eraseText(characters: Int): FxRobotInterface =
    eraseText(characters)

/** Calls [WriteRobot.write] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.write(character: Char): FxRobotInterface =
    write(character)

/** Calls [WriteRobot.write] and returns itself for more method chaining. */
inline infix fun FxRobotInterface.write(text: String): FxRobotInterface =
    write(text)