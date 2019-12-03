package ktfx.dialogs

import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test

abstract class ShowDialogTest : ApplicationTest() {

    final override fun start(stage: Stage) = show()

    abstract fun show()

    /** Because dialogs are all shown in [start], bulk assertions in single function to avoid re-showing. */
    @Test abstract fun test()
}