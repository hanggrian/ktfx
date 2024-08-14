package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.NumberAxis
import kotlin.test.assertEquals

class BubbleChartTest : LayoutsStyledTest<KtfxPane, BubbleChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = bubbleChart(axis1, axis2) {}

    override fun KtfxPane.child2() = bubbleChart(axis1, axis2)

    override fun child3() = styledBubbleChart(axis1, axis2, styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledBubbleChart(axis1, axis2, styleClass = arrayOf("style"))

    override fun BubbleChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}
