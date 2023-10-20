package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.NumberAxis
import kotlin.test.assertEquals

class BubbleChartTest : LayoutsTest<KtfxPane, BubbleChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): BubbleChart<Number, Number> = bubbleChart(axis1, axis2) { }

    override fun KtfxPane.child2(): BubbleChart<Number, Number> = bubbleChart(axis1, axis2)

    override fun KtfxPane.child3(): BubbleChart<Number, Number> = bubbleChart(axis1, axis2) { }

    override fun BubbleChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}
