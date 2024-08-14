package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.chart.AreaChart
import javafx.scene.chart.NumberAxis
import kotlin.test.assertEquals

class AreaChartTest : LayoutsStyledTest<KtfxPane, AreaChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = areaChart(axis1, axis2) {}

    override fun KtfxPane.child2() = areaChart(axis1, axis2)

    override fun child3() = styledAreaChart(axis1, axis2, styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledAreaChart(axis1, axis2, styleClass = arrayOf("style"))

    override fun AreaChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}
