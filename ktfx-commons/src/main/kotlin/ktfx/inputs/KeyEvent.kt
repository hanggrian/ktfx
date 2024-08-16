package ktfx.inputs

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent

/** Returns true if this key is delete or backspace. */
public fun KeyEvent.isDelete(): Boolean = code == KeyCode.DELETE || code == KeyCode.BACK_SPACE

/** Returns true if this key is number softkey or numpad 0. */
public fun KeyEvent.is0(): Boolean = code == KeyCode.NUMPAD0 || code == KeyCode.SOFTKEY_0

/** Returns true if this key is number softkey or numpad 1. */
public fun KeyEvent.is1(): Boolean = code == KeyCode.NUMPAD1 || code == KeyCode.SOFTKEY_1

/** Returns true if this key is number softkey or numpad 2. */
public fun KeyEvent.is2(): Boolean = code == KeyCode.NUMPAD2 || code == KeyCode.SOFTKEY_2

/** Returns true if this key is number softkey or numpad 3. */
public fun KeyEvent.is3(): Boolean = code == KeyCode.NUMPAD3 || code == KeyCode.SOFTKEY_3

/** Returns true if this key is number softkey or numpad 4. */
public fun KeyEvent.is4(): Boolean = code == KeyCode.NUMPAD4 || code == KeyCode.SOFTKEY_4

/** Returns true if this key is number softkey or numpad 5. */
public fun KeyEvent.is5(): Boolean = code == KeyCode.NUMPAD5 || code == KeyCode.SOFTKEY_5

/** Returns true if this key is number softkey or numpad 6. */
public fun KeyEvent.is6(): Boolean = code == KeyCode.NUMPAD6 || code == KeyCode.SOFTKEY_6

/** Returns true if this key is number softkey or numpad 7. */
public fun KeyEvent.is7(): Boolean = code == KeyCode.NUMPAD7 || code == KeyCode.SOFTKEY_7

/** Returns true if this key is number softkey or numpad 8. */
public fun KeyEvent.is8(): Boolean = code == KeyCode.NUMPAD8 || code == KeyCode.SOFTKEY_8

/** Returns true if this key is number softkey or numpad 9. */
public fun KeyEvent.is9(): Boolean = code == KeyCode.NUMPAD9 || code == KeyCode.SOFTKEY_9
