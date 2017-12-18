@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.image.Image
import javafx.stage.Stage

inline var Stage.icon: Image?
    get() = icons[0]
    set(value) {
        if (!icons.isEmpty()) icons.clear()
        value?.let { icons.add(it) }
    }