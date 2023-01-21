package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.ScatterChart
import kotlin.test.assertEquals

class ScatterChartTest : LayoutsTest<KtfxPane, ScatterChart<Number, Number>>() {
    private lateinit var axis1: NumberAxis
    private lateinit var axis2: NumberAxis

    override fun onCreate() {
        super.onCreate()
        axis1 = NumberAxis()
        axis2 = NumberAxis(1.0, 2.0, 3.0)
    }

    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): ScatterChart<Number, Number> = scatterChart(axis1, axis2) { }
    override fun KtfxPane.child2(): ScatterChart<Number, Number> = scatterChart(axis1, axis2)
    override fun KtfxPane.child3(): ScatterChart<Number, Number> = scatterChart(axis1, axis2) { }

    override fun ScatterChart<Number, Number>.testDefaultValues() {
        assertEquals(axis1, xAxis)
        assertEquals(axis2, yAxis)
        assertThat(data).isEmpty()
    }
}
