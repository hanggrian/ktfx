package ktfx.inputs

import javafx.event.EventType
import javafx.scene.Scene
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.stage.Stage
import ktfx.test.AppTest
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * @see [JavaFxRobotAdapter](https://github.com/TestFX/TestFX/blob/master/subprojects/testfx-core/src/main/java/org/testfx/service/adapter/impl/JavafxRobotAdapter.java).
 */
class MouseEventTest : AppTest() {
    private lateinit var scene: Scene

    private val isShiftDown = false
    private val isControlDown = false
    private val isAltDown = false
    private val isMetaDown = false

    private var lastButtonPressed: MouseButton? = null
    private var isButton1Pressed = false
    private var isButton2Pressed = false
    private var isButton3Pressed = false
    private var sceneMouseX = 0.0
    private var sceneMouseY = 0.0
    private var screenMouseX = 0.0
    private var screenMouseY = 0.0

    override fun start(stage: Stage) {
        scene = Scene(Pane())
        stage.scene = scene
    }

    @Test fun isLeftClick() = assertTrue(
        createMouseEvent(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.PRIMARY, 1).isLeftClick()
    )

    @Test fun isRightClick() = assertTrue(
        createMouseEvent(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.SECONDARY, 1).isRightClick()
    )

    @Test fun isMiddleClick() = assertTrue(
        createMouseEvent(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.MIDDLE, 1).isMiddleClick()
    )

    @Test fun isDoubleClick() = assertTrue(
        createMouseEvent(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.PRIMARY, 2).isDoubleClick()
    )

    private fun createMouseEvent(
        eventType: EventType<MouseEvent?>,
        x: Double,
        y: Double,
        mouseButton: MouseButton,
        clickCount: Int
    ): MouseEvent {
        screenMouseX = scene.window.x + scene.x + x
        screenMouseY = scene.window.y + scene.y + y
        sceneMouseX = x
        sceneMouseY = y
        var button = mouseButton
        var type: EventType<MouseEvent?> = eventType
        if (type === MouseEvent.MOUSE_PRESSED || type === MouseEvent.MOUSE_RELEASED) {
            val pressed = type === MouseEvent.MOUSE_PRESSED
            when (button) {
                MouseButton.PRIMARY -> isButton1Pressed = pressed
                MouseButton.MIDDLE -> isButton2Pressed = pressed
                MouseButton.SECONDARY -> isButton3Pressed = pressed
            }
            if (pressed) {
                lastButtonPressed = button
            } else {
                if (!(isButton1Pressed || isButton2Pressed || isButton3Pressed)) {
                    lastButtonPressed = MouseButton.NONE
                }
            }
        } else if (type === MouseEvent.MOUSE_MOVED) {
            val someButtonPressed = isButton1Pressed || isButton2Pressed || isButton3Pressed
            if (someButtonPressed) {
                type = MouseEvent.MOUSE_DRAGGED
                button = MouseButton.NONE
            }
        }
        return MouseEvent(
            type,
            sceneMouseX,
            sceneMouseY,
            screenMouseX,
            screenMouseY,
            button,
            clickCount,
            isShiftDown,
            isControlDown,
            isAltDown,
            isMetaDown,
            isButton1Pressed,
            isButton2Pressed,
            isButton3Pressed,
            false,
            button == MouseButton.SECONDARY,
            false,
            null
        )
    }
}