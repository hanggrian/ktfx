package ktfx.layouts

import javafx.scene.chart.PieChart
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty

class PieChartTest : LayoutTest<NodeManager, PieChart>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = pieChart { }
    override fun NodeManager.child2() = pieChart()
    override fun NodeManager.child3() = pieChart { }

    override fun PieChart.testDefaultValues() {
        assertEmpty(data)
    }
}