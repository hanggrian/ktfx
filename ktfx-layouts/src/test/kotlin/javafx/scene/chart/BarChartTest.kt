package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import kotlin.test.assertEquals

class BarChartTest : LayoutsStyledTest<KtfxPane, BarChart<String, Number>>() {
    private lateinit var axis1: CategoryAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = CategoryAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = barChart(axis1, axis2) {}

    override fun KtfxPane.child2() = barChart(axis1, axis2)

    override fun child3() = styledBarChart(axis1, axis2)

    override fun KtfxPane.child4() = styledBarChart(axis1, axis2)

    override fun BarChart<String, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
        assertEquals(10.0, categoryGap)
    }
}
