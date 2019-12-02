@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.KeyCode

/** Returns true if this key is delete or backspace. */
inline fun KeyCode.isDelete(): Boolean = this == KeyCode.DELETE || this == KeyCode.BACK_SPACE

/** Returns true if this key is number softkey or numpad 0. */
inline fun KeyCode.is0(): Boolean = this == KeyCode.NUMPAD0 || this == KeyCode.SOFTKEY_0

/** Returns true if this key is number softkey or numpad 1. */
inline fun KeyCode.is1(): Boolean = this == KeyCode.NUMPAD1 || this == KeyCode.SOFTKEY_1

/** Returns true if this key is number softkey or numpad 2. */
inline fun KeyCode.is2(): Boolean = this == KeyCode.NUMPAD2 || this == KeyCode.SOFTKEY_2

/** Returns true if this key is number softkey or numpad 3. */
inline fun KeyCode.is3(): Boolean = this == KeyCode.NUMPAD3 || this == KeyCode.SOFTKEY_3

/** Returns true if this key is number softkey or numpad 4. */
inline fun KeyCode.is4(): Boolean = this == KeyCode.NUMPAD4 || this == KeyCode.SOFTKEY_4

/** Returns true if this key is number softkey or numpad 5. */
inline fun KeyCode.is5(): Boolean = this == KeyCode.NUMPAD5 || this == KeyCode.SOFTKEY_5

/** Returns true if this key is number softkey or numpad 6. */
inline fun KeyCode.is6(): Boolean = this == KeyCode.NUMPAD6 || this == KeyCode.SOFTKEY_6

/** Returns true if this key is number softkey or numpad 7. */
inline fun KeyCode.is7(): Boolean = this == KeyCode.NUMPAD7 || this == KeyCode.SOFTKEY_7

/** Returns true if this key is number softkey or numpad 8. */
inline fun KeyCode.is8(): Boolean = this == KeyCode.NUMPAD8 || this == KeyCode.SOFTKEY_8

/** Returns true if this key is number softkey or numpad 9. */
inline fun KeyCode.is9(): Boolean = this == KeyCode.NUMPAD9 || this == KeyCode.SOFTKEY_9
