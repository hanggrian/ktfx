package ktfx.layouts

import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals

class BarChartTest : BaseLayoutTest<NodeManager, BarChart<String, Number>>() {
    private lateinit var axis1: CategoryAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = CategoryAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = barChart(axis1, axis2) { }
    override fun NodeManager.child2() = barChart(axis1, axis2)
    override fun NodeManager.child3() = barChart(axis1, axis2) { }

    override fun BarChart<String, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
        assertEquals(10.0, categoryGap)
    }
}