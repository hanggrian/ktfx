package javafx.scene.control.cell

import javafx.scene.control.TreeItem
import javafx.util.StringConverter

@PublishedApi
internal object KtfxCellUtils {

    fun <T> defaultStringConverter(): StringConverter<T> =
        CellUtils.defaultStringConverter<T>()

    fun <T> defaultTreeItemStringConverter(): StringConverter<TreeItem<T>> =
        CellUtils.defaultTreeItemStringConverter<T>()
}
