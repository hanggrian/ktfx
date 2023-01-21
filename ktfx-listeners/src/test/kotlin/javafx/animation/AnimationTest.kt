package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseAnimationTest
import javafx.animation.Animation
import javafx.event.ActionEvent

class AnimationTest : BaseAnimationTest() {
    override fun Animation.callOnFinished(action: (ActionEvent) -> Unit) = onFinished(action)
}
