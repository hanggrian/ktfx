package ktfx.layouts.scene.chart

import javafx.scene.chart.PieChart
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.pieChart
import ktfx.test.assertEmpty

class PieChartTest : LayoutTest<NodeManager, PieChart>(KtfxPane()) {

    override fun create() = pieChart { }
    override fun NodeManager.add() = pieChart()
    override fun NodeManager.addWithBuilder() = pieChart { }

    override fun PieChart.testDefaultValues() {
        assertEmpty(data)
    }
}