package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.chart.PieChart
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class PieChartTest : LayoutsTest<KtfxPane, PieChart>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = pieChart { }
    override fun KtfxPane.child2() = pieChart()
    override fun KtfxPane.child3() = pieChart { }

    override fun PieChart.testDefaultValues() {
        assertThat(data).isEmpty()
    }
}