package ktfx.layouts

import javafx.scene.chart.NumberAxis
import javafx.scene.chart.ScatterChart
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals

class ScatterChartTest : LayoutTest<NodeManager, ScatterChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = scatterChart(axis1, axis2) { }
    override fun NodeManager.child2() = scatterChart(axis1, axis2)
    override fun NodeManager.child3() = scatterChart(axis1, axis2) { }

    override fun ScatterChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
    }
}