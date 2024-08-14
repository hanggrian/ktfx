package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.chart.PieChart

class PieChartTest : LayoutsStyledTest<KtfxPane, PieChart>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = pieChart {}

    override fun KtfxPane.child2() = pieChart()

    override fun child3() = styledPieChart(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledPieChart(styleClass = arrayOf("style"))

    override fun PieChart.testDefaultValues() {
        assertThat(data).isEmpty()
    }
}
