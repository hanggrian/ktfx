@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts

/**
 * [Accordion] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxAccordion : Accordion(), TitledPaneContainer {
    final override fun <T : TitledPane> addChild(child: T): T = child.also { panes += it }

    /** Call [NodeContainer.titledPane] by string invocation. */
    inline operator fun String.invoke(
        configuration: (@KtfxLayoutDslMarker KtfxTitledPane).() -> Unit,
    ): TitledPane = titledPane(this, configuration)
}
