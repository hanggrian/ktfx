package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.chart.PieChart

class PieChartTest : LayoutsTest<KtfxPane, PieChart>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): PieChart = pieChart { }

    override fun KtfxPane.child2(): PieChart = pieChart()

    override fun KtfxPane.child3(): PieChart = pieChart { }

    override fun PieChart.testDefaultValues() {
        assertThat(data).isEmpty()
    }
}
