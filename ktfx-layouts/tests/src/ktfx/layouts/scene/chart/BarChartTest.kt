package ktfx.layouts.scene.chart

import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.barChart
import ktfx.test.assertEmpty
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class BarChartTest : LayoutTest<NodeManager, BarChart<String, Number>>() {
    private lateinit var axis1: CategoryAxis
    private lateinit var axis2: NumberAxis

    @BeforeTest fun createAxises() {
        axis1 = CategoryAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun createManager() = KtfxPane()
    override fun create() = barChart(axis1, axis2) { }
    override fun NodeManager.add() = barChart(axis1, axis2)
    override fun NodeManager.addWithBuilder() = barChart(axis1, axis2) { }

    override fun BarChart<String, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
        assertEquals(10.0, categoryGap)
    }
}