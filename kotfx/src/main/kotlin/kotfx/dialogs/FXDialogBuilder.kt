package kotfx.dialogs

import javafx.beans.property.*
import javafx.event.EventHandler
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.scene.control.DialogPane
import javafx.stage.Window
import javafx.util.Callback

@PublishedApi
internal open class FXDialogBuilder<R> : DialogBuilder<R> {

    open val dialog: Dialog<R> = Dialog()

    override var owner: Window
        get() = dialog.owner
        set(value) = dialog.initOwner(value)

    override val resizableProperty: BooleanProperty get() = dialog.resizableProperty()

    override val showingProperty: ReadOnlyBooleanProperty get() = dialog.showingProperty()

    override val heightProperty: ReadOnlyDoubleProperty get() = dialog.heightProperty()
    override var height: Double
        get() = dialog.height
        set(value) = dialog.setHeight(value)

    override val widthProperty: ReadOnlyDoubleProperty get() = dialog.widthProperty()
    override var width: Double
        get() = dialog.width
        set(value) = dialog.setWidth(value)

    override val xProperty: ReadOnlyDoubleProperty get() = dialog.xProperty()
    override var x: Double
        get() = dialog.x
        set(value) = dialog.setX(value)

    override val yProperty: ReadOnlyDoubleProperty get() = dialog.yProperty()
    override var y: Double
        get() = dialog.y
        set(value) = dialog.setY(value)

    override val titleProperty: StringProperty get() = dialog.titleProperty()

    override val paneProperty: ObjectProperty<DialogPane> get() = dialog.dialogPaneProperty()

    override val resultProperty: ObjectProperty<R> get() = dialog.resultProperty()

    override val resultConverterProperty: ObjectProperty<Callback<ButtonType, R>> get() = dialog.resultConverterProperty()

    override val onShowingProperty: ObjectProperty<EventHandler<DialogEvent>> get() = dialog.onShowingProperty()

    override val onShownProperty: ObjectProperty<EventHandler<DialogEvent>> get() = dialog.onShownProperty()

    override val onHidingProperty: ObjectProperty<EventHandler<DialogEvent>> get() = dialog.onHidingProperty()

    override val onHiddenProperty: ObjectProperty<EventHandler<DialogEvent>> get() = dialog.onHiddenProperty()

    override val onCloseRequestProperty: ObjectProperty<EventHandler<DialogEvent>> get() = dialog.onCloseRequestProperty()

    override fun build(): Dialog<R> = dialog
}