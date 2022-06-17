package ktfx.listeners

import javafx.animation.Animation
import javafx.event.ActionEvent
import com.hendraanggrian.ktfx.test.BaseAnimationTest

class AnimationTest : BaseAnimationTest() {

    override fun Animation.callOnFinished(action: (ActionEvent) -> Unit) = onFinished(action)
}
