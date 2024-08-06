package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.SegmentedBar

class SegmentedBarTest : LayoutsTest<KtfxPane, SegmentedBar<SegmentedBar.Segment>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): SegmentedBar<SegmentedBar.Segment> = segmentedBar { }

    override fun KtfxPane.child2(): SegmentedBar<SegmentedBar.Segment> = segmentedBar()

    override fun KtfxPane.child3(): SegmentedBar<SegmentedBar.Segment> = segmentedBar { }
}
