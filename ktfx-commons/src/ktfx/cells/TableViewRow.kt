package ktfx.cells

import javafx.scene.control.TableView

/** Set custom row factory to this [TableView]. */
inline fun <S> TableView<S>.rowFactory(
    crossinline builderAction: KtfxTableRow<S>.(TableView<S>) -> Unit
): Unit = setRowFactory {
    val builder = KtfxTableRow<S>()
    builder.builderAction(it)
    builder
}
