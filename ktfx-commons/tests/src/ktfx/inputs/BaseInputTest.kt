package ktfx.inputs

import javafx.event.EventType
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.input.ScrollEvent
import javafx.stage.Stage
import ktfx.controls.paddingAll
import org.testfx.framework.junit.ApplicationTest

/**
 * Application test which can create fake key, mouse and scroll events.
 *
 * @see org.testfx.service.adapter.impl.JavafxRobotAdapter
 */
open class BaseInputTest : ApplicationTest() {
    lateinit var scene: Scene

    var isShiftDown = false
    var isControlDown = false
    var isAltDown = false
    var isMetaDown = false

    var lastButtonPressed: MouseButton? = null
    var isButton1Pressed = false
    var isButton2Pressed = false
    var isButton3Pressed = false
    var sceneMouseX = 0.0
    var sceneMouseY = 0.0
    var screenMouseX = 0.0
    var screenMouseY = 0.0

    override fun start(stage: Stage) {
        scene = Scene(Label("Testing inputs...").apply { paddingAll = 20.0 })
        stage.scene = scene
        stage.show()
    }

    fun keyEventOf(eventType: EventType<KeyEvent>, code: KeyCode, character: String = ""): KeyEvent {
        val pressed = eventType == KeyEvent.KEY_PRESSED
        if (code == KeyCode.SHIFT) {
            isShiftDown = pressed
        }
        if (code == KeyCode.CONTROL) {
            isControlDown = pressed
        }
        if (code == KeyCode.ALT) {
            isAltDown = pressed
        }
        if (code == KeyCode.META) {
            isMetaDown = pressed
        }
        val typed = eventType == KeyEvent.KEY_TYPED
        val keyChar = if (typed) character else KeyEvent.CHAR_UNDEFINED
        val keyText = if (typed) "" else code.getName()
        return KeyEvent(
            eventType,
            keyChar,
            keyText,
            code,
            isShiftDown,
            isControlDown,
            isAltDown,
            isMetaDown
        )
    }

    @Suppress("NON_EXHAUSTIVE_WHEN")
    fun mouseEventOf(
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
        var type = eventType
        if (type == MouseEvent.MOUSE_PRESSED || type == MouseEvent.MOUSE_RELEASED) {
            val pressed = type == MouseEvent.MOUSE_PRESSED
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
        } else if (type == MouseEvent.MOUSE_MOVED) {
            val someButtonPressed = isButton1Pressed || isButton2Pressed || isButton3Pressed
            if (someButtonPressed) {
                type = MouseEvent.MOUSE_DRAGGED
                button = MouseButton.NONE
            }
        }
        return MouseEvent(
            type, sceneMouseX, sceneMouseY, screenMouseX, screenMouseY,
            button, clickCount, isShiftDown, isControlDown, isAltDown, isMetaDown,
            isButton1Pressed, isButton2Pressed, isButton3Pressed, false, button == MouseButton.SECONDARY, false, null
        )
    }

    fun scrollEventOf(wheelAmount: Int): ScrollEvent {
        screenMouseX = scene.window.x + scene.x + sceneMouseX
        screenMouseY = scene.window.y + scene.y + sceneMouseY
        return ScrollEvent(
            ScrollEvent.SCROLL, sceneMouseX, sceneMouseY, screenMouseX, screenMouseY,
            isShiftDown, isControlDown, isAltDown, isMetaDown, false, false, 0.0,
            wheelAmount * 40.0, 0.0, 0.0, ScrollEvent.HorizontalTextScrollUnits.NONE, 0.0,
            ScrollEvent.VerticalTextScrollUnits.NONE, 0.0, 0, null
        )
    }
}
