package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.hendraanggrian.kotlinpoet.buildParameterSpec
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVarOf
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import javafx.animation.Animation
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.geometry.Rectangle2D
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.ButtonBase
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBoxBase
import javafx.scene.control.ContextMenu
import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.scene.control.ListView
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.Tab
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafx.scene.control.TreeView
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.RotateEvent
import javafx.scene.input.ScrollEvent
import javafx.scene.input.SwipeEvent
import javafx.scene.input.TouchEvent
import javafx.scene.input.ZoomEvent
import javafx.scene.media.Media
import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javafx.scene.transform.Transform
import javafx.scene.transform.TransformChangedEvent
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import javafx.stage.PopupWindow
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

open class ListenersFactory(
    path: String,
    packageName: String,
    className: String
) : BaseListenersFactory(
    path,
    packageName,
    className,
    KModifier.INLINE,
    extraFileConfiguration = {
        annotations.add<Suppress> { addMember("%S", "NOTHING_TO_INLINE") }
    }
) {
    companion object;

    override fun ParameterSpecListScope.action(vararg params: TypeName): Boolean =
        add("action", Unit::class.asTypeName().lambdaBy(*params), KModifier.NOINLINE)
}

open class CoroutinesFactory(
    path: String,
    packageName: String,
    className: String
) : BaseListenersFactory(
    path,
    packageName,
    className,
    null,
    buildParameterSpec<CoroutineContext>("context") { defaultValue("Dispatchers.JavaFx") },
    {
        addImport("kotlinx.coroutines", "GlobalScope")
        addImport("kotlinx.coroutines", "Dispatchers")
        addImport("kotlinx.coroutines", "launch")
        addImport("kotlinx.coroutines.javafx", "JavaFx")
    }
) {
    companion object;

    override fun ParameterSpecListScope.action(vararg params: TypeName): Boolean =
        add(
            "action", Unit::class.asTypeName().lambdaBy(*params, receiver = CoroutineScope::class.asTypeName())
                .copy(suspending = true)
        )
}

abstract class BaseListenersFactory(
    val path: String,
    val packageName: String,
    val className: String,
    val extraFunctionModifier: KModifier? = null,
    private val extraFunctionParameter: ParameterSpec? = null,
    val extraFileConfiguration: FileSpecBuilder.() -> Unit = { }
) {
    val entries = mutableListOf<ListenersClassEntry>()

    operator fun KClass<*>.invoke(configuration: FunctionsFactory.() -> Unit) = asTypeName().invoke(configuration)

    operator fun TypeName.invoke(configuration: FunctionsFactory.() -> Unit) {
        entries += ListenersClassEntry(
            this,
            extraFunctionModifier,
            FunctionsFactory(extraFunctionParameter).apply(configuration).entries,
            extraFileConfiguration
        )
    }

    inline fun <reified Type> ParameterSpecListScope.action(): Boolean = action(Type::class.asTypeName())

    abstract fun ParameterSpecListScope.action(vararg params: TypeName): Boolean

    class FunctionsFactory(private val extraFunctionParameter: ParameterSpec?) {
        val entries = mutableListOf<ListenersFunctionEntry>()

        operator fun String.invoke(configuration: ParameterSpecListScope.() -> Unit = { }) {
            val parameters = listOfNotNull(extraFunctionParameter).toMutableList()
            ParameterSpecListScope(parameters).configuration()
            entries += ListenersFunctionEntry(this, parameters)
        }
    }
}