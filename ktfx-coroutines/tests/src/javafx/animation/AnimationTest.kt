package ktfx.coroutines

import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseAnimationTest

class AnimationTest : BaseAnimationTest() {

    override fun Animation.callOnFinished(action: (ActionEvent) -> Unit) =
        onFinished(Dispatchers.Unconfined) { action(it) }
}