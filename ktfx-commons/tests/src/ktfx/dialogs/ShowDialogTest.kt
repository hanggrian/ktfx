package ktfx.dialogs

import javafx.stage.Stage
import ktfx.test.AppTest
import kotlin.test.Test

abstract class ShowDialogTest : AppTest() {

    final override fun start(stage: Stage) = show()

    abstract fun show()

    /** Because dialogs are all shown in [start], bulk assertions in single function to avoid re-showing. */
    @Test abstract fun test()
}