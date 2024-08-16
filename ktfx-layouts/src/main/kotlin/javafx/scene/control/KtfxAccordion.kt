@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

/**
 * [Accordion] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxAccordion :
    Accordion(),
    TitledPaneContainer {
    final override fun <T : TitledPane> addChild(child: T): T = child.also { panes += it }

    /** Call [NodeContainer.titledPane] by string invocation. */
    public inline operator fun String.invoke(
        configuration: (@KtfxLayoutDslMarker KtfxTitledPane).() -> Unit,
    ): TitledPane = titledPane(this, configuration)
}
