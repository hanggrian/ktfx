package ktfx.layouts

import javafx.scene.chart.BubbleChart
import javafx.scene.chart.NumberAxis
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals

class BubbleChartTest : BaseLayoutTest<NodeManager, BubbleChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = bubbleChart(axis1, axis2) { }
    override fun NodeManager.child2() = bubbleChart(axis1, axis2)
    override fun NodeManager.child3() = bubbleChart(axis1, axis2) { }

    override fun BubbleChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertEmpty(data)
    }
}