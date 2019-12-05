package ktfx.layouts.scene.chart

import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.StackedBarChart
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.stackedBarChart
import ktfx.test.assertEmpty
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class StackedBarChartTest : LayoutTest<NodeManager, StackedBarChart<String, Number>>(KtfxPane()) {
    private lateinit var axis1: CategoryAxis
    private lateinit var axis2: NumberAxis

    @BeforeTest fun createAxises() {
        axis1 = CategoryAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun create() = stackedBarChart(axis1, axis2) { }
    override fun NodeManager.add() = stackedBarChart(axis1, axis2)
    override fun NodeManager.addWithBuilder() = stackedBarChart(axis1, axis2) { }

    override fun StackedBarChart<String, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
    }
}