package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXScrollPane
import ktfx.layouts.KtfxPane
import kotlin.test.Test

class JfxScrollPaneTest : LayoutsTest<KtfxPane, JFXScrollPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXScrollPane = jfxScrollPane { }
    override fun KtfxPane.child2(): JFXScrollPane = jfxScrollPane()
    override fun KtfxPane.child3(): JFXScrollPane = jfxScrollPane { }

    @Test
    fun barAndHeader() {
        val top1: JFXButton
        val mid1: JFXButton
        val mid2: JFXButton
        val bottom1: JFXButton
        val bottom2: JFXButton
        val bottom3: JFXButton
        val main1: JFXButton
        val condensed1: JFXButton
        val condensed2: JFXButton
        jfxScrollPane {
            topBar {
                top1 = jfxButton()
            }
            midBar {
                mid1 = jfxButton()
                mid2 = jfxButton()
            }
            bottomBar {
                bottom1 = jfxButton()
                bottom2 = jfxButton()
                bottom3 = jfxButton()
            }
            mainHeader {
                main1 = jfxButton()
            }
            condensedHeader {
                condensed1 = jfxButton()
                condensed2 = jfxButton()
            }
            assertThat(topBar.children).containsExactly(top1).inOrder()
            assertThat(midBar.children).containsExactly(mid1, mid2).inOrder()
            assertThat(bottomBar.children).containsExactly(bottom1, bottom2, bottom3).inOrder()
            assertThat(mainHeader.children).containsExactly(main1).inOrder()
            assertThat(condensedHeader.children).containsExactly(condensed1, condensed2).inOrder()
        }
    }
}
