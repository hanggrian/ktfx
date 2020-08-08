package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVarBy
import com.hendraanggrian.kotlinpoet.typeVarOf
import com.jfoenix.controls.JFXBadge
import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXCheckBox
import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXClippedPane
import com.jfoenix.controls.JFXColorPicker
import com.jfoenix.controls.JFXComboBox
import com.jfoenix.controls.JFXDatePicker
import com.jfoenix.controls.JFXDecorator
import com.jfoenix.controls.JFXDefaultChip
import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.JFXDrawersStack
import com.jfoenix.controls.JFXHamburger
import com.jfoenix.controls.JFXListCell
import com.jfoenix.controls.JFXListView
import com.jfoenix.controls.JFXMasonryPane
import com.jfoenix.controls.JFXNodesList
import com.jfoenix.controls.JFXPasswordField
import com.jfoenix.controls.JFXProgressBar
import com.jfoenix.controls.JFXRadioButton
import com.jfoenix.controls.JFXRippler
import com.jfoenix.controls.JFXScrollPane
import com.jfoenix.controls.JFXSlider
import com.jfoenix.controls.JFXSpinner
import com.jfoenix.controls.JFXTabPane
import com.jfoenix.controls.JFXTextArea
import com.jfoenix.controls.JFXTextField
import com.jfoenix.controls.JFXTimePicker
import com.jfoenix.controls.JFXToggleButton
import com.jfoenix.controls.JFXToggleNode
import com.jfoenix.controls.JFXTogglePane
import com.jfoenix.controls.JFXToolbar
import com.jfoenix.controls.JFXTreeCell
import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.JFXTreeView
import com.jfoenix.controls.JFXTreeViewPath
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import com.squareup.kotlinpoet.asClassName
import javafx.scene.Node
import javafx.scene.control.TreeView
import javafx.stage.Stage
import java.time.LocalTime

val LayoutsFactory.Companion.Jfoenix: LayoutsFactory
    get() = object : LayoutsFactory("features/jfoenix-layouts/src", "ktfx.jfoenix.layouts", "JfoenixLayoutsKt") {
        init {
            JFXBadge::class(customClass = true)
            JFXButton::class { text(); graphic() }
            JFXCheckBox::class { text() }
            JFXChip::class(T) { chipView(); item() }
            JFXChipView::class(T)
            JFXClippedPane::class(customClass = true)
            JFXColorPicker::class { color() }
            JFXComboBox::class(T) { items(T) }
            JFXDatePicker::class { date() }
            JFXDecorator::class {
                add<Stage>("stage")
                add<Node>("node")
                "fullScreen"<Boolean> { defaultValue("true") }
                "max"<Boolean> { defaultValue("true") }
                "min"<Boolean> { defaultValue("true") }
            }
            JFXDefaultChip::class(T) { chipView(); item() }
            JFXDrawer::class(customClass = true)
            JFXDrawersStack::class()
            JFXHamburger::class()
            JFXListCell::class(T)
            JFXListView::class(T)
            JFXMasonryPane::class(customClass = true)
            JFXNodesList::class(customClass = true)
            JFXPasswordField::class()
            JFXProgressBar::class { progress() }
            JFXRadioButton::class { text() }
            JFXRippler::class(customClass = true)
            JFXScrollPane::class(customClass = true)
            JFXSlider::class { slider("50.0") }
            JFXSpinner::class { progress() }
            JFXTabPane::class(customClass = true)
            JFXTextArea::class { text() }
            JFXTextField::class { text() }
            JFXTimePicker::class { "time"(LocalTime::class.asClassName().asNullable()) { defaultValue("null") } }
            JFXToggleButton::class()
            JFXToggleNode::class { graphic() }
            JFXTogglePane::class(customClass = true)
            JFXToolbar::class(customClass = true)
            JFXTreeCell::class(T)
            JFXTreeTableView::class("S".typeVarBy(RecursiveTreeObject::class.parameterizedBy(S))) {
                treeItem("root", S)
            }
            JFXTreeView::class(T) { treeItem("root", T) }
            JFXTreeViewPath::class {
                "treeView"(TreeView::class.asClassName().parameterizedBy("*".typeVarOf()).asNullable()) {
                    defaultValue("null")
                }
            }
        }

        fun ParameterSpecListScope.chipView() = add("view", JFXChipView::class.asClassName().parameterizedBy(T))
        fun ParameterSpecListScope.item() = add("item", T)
    }