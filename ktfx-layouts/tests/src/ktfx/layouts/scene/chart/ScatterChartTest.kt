package ktfx.layouts.scene.chart

import javafx.scene.chart.NumberAxis
import javafx.scene.chart.ScatterChart
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.scatterChart
import ktfx.test.assertEmpty
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class ScatterChartTest : LayoutTest<NodeManager, ScatterChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    @BeforeTest fun createAxises() {
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun createManager() = KtfxPane()
    override fun create() = scatterChart(axis1, axis2) { }
    override fun NodeManager.add() = scatterChart(axis1, axis2)
    override fun NodeManager.addWithBuilder() = scatterChart(axis1, axis2) { }

    override fun ScatterChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
    }
}