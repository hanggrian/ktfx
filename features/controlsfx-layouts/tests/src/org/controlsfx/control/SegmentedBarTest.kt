package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.SegmentedBar

class SegmentedBarTest : LayoutsTest<KtfxPane, SegmentedBar<SegmentedBar.Segment>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = segmentedBar<SegmentedBar.Segment> { }
    override fun KtfxPane.child2() = segmentedBar<SegmentedBar.Segment>()
    override fun KtfxPane.child3() = segmentedBar<SegmentedBar.Segment> { }
}