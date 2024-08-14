package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.SegmentedBar

class SegmentedBarTest : LayoutsStyledTest<KtfxPane, SegmentedBar<SegmentedBar.Segment>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = segmentedBar<SegmentedBar.Segment> {}

    override fun KtfxPane.child2() = segmentedBar<SegmentedBar.Segment>()

    override fun child3() = styledSegmentedBar<SegmentedBar.Segment>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() =
        styledSegmentedBar<SegmentedBar.Segment>(styleClass = arrayOf("style"))
}
