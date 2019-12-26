package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.StackedBarChart
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class StackedBarChartTest : LayoutTest<NodeManager, StackedBarChart<String, Number>>() {
    private lateinit var axis1: CategoryAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = CategoryAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = stackedBarChart(axis1, axis2) { }
    override fun NodeManager.child2() = stackedBarChart(axis1, axis2)
    override fun NodeManager.child3() = stackedBarChart(axis1, axis2) { }

    override fun StackedBarChart<String, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}