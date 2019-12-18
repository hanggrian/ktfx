package ktfx.layouts

import javafx.scene.chart.NumberAxis
import javafx.scene.chart.StackedAreaChart
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals

class StackedAreaChartTest : BaseLayoutTest<NodeManager, StackedAreaChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = stackedAreaChart(axis1, axis2) { }
    override fun NodeManager.child2() = stackedAreaChart(axis1, axis2)
    override fun NodeManager.child3() = stackedAreaChart(axis1, axis2) { }

    override fun StackedAreaChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
    }
}