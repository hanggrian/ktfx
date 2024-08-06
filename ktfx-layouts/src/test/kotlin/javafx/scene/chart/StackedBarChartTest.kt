package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.StackedBarChart
import kotlin.test.assertEquals

class StackedBarChartTest : LayoutsTest<KtfxPane, StackedBarChart<String, Number>>() {
    private lateinit var axis1: CategoryAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = CategoryAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): StackedBarChart<String, Number> = stackedBarChart(axis1, axis2) { }

    override fun KtfxPane.child2(): StackedBarChart<String, Number> = stackedBarChart(axis1, axis2)

    override fun KtfxPane.child3(): StackedBarChart<String, Number> =
        stackedBarChart(axis1, axis2) { }

    override fun StackedBarChart<String, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}
