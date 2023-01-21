package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseAnimationTest
import javafx.animation.Animation
import javafx.event.ActionEvent
import kotlinx.coroutines.Dispatchers

class AnimationTest : BaseAnimationTest() {
    override fun Animation.callOnFinished(action: (ActionEvent) -> Unit) =
        onFinished(Dispatchers.Unconfined) { action(it) }
}
