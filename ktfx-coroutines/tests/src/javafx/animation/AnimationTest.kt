package ktfx.coroutines

import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseAnimationTest

class AnimationTest : BaseAnimationTest() {

    override fun Animation.callOnFinished(action: (ActionEvent) -> Unit) =
        onFinished(Dispatchers.Unconfined) { action(it) }
}