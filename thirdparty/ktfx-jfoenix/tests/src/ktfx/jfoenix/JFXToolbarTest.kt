package ktfx.jfoenix

import com.google.common.truth.Truth
import ktfx.test.ToolkitLayoutTest

class JFXToolbarTest : ToolkitLayoutTest() {

    override fun newInstance() {
        val left1 = jfxButton()
        val right1 = jfxButton()
        val right2 = jfxButton()
        val toolbar = jfxToolbar {
            leftItems {
                left1()
            }
            rightItems {
                right1()
                right2()
            }
        }
        Truth.assertThat(toolbar.leftItems).containsExactly(left1).inOrder()
        Truth.assertThat(toolbar.rightItems).containsExactly(right1, right2).inOrder()
    }

    override fun withManager() {
    }
}