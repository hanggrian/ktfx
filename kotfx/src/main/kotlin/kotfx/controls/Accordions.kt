@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Accordion

class _Accordion : Accordion(), _Control<Accordion> {
    override val control: Accordion get() = this
}