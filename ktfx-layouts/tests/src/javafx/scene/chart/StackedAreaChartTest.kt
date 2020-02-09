package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.StackedAreaChart
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class StackedAreaChartTest : LayoutsTest<KtfxPane, StackedAreaChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = stackedAreaChart(axis1, axis2) { }
    override fun KtfxPane.child2() = stackedAreaChart(axis1, axis2)
    override fun KtfxPane.child3() = stackedAreaChart(axis1, axis2) { }

    override fun StackedAreaChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}