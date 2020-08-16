package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVarBy
import com.hendraanggrian.kotlinpoet.typeVarOf
import com.hendraanggrian.ktfx.codegen.T
import javafx.collections.ObservableList
import javafx.concurrent.Task
import javafx.geometry.Side
import javafx.scene.control.CheckBoxTreeItem
import org.controlsfx.control.BreadCrumbBar
import org.controlsfx.control.CheckComboBox
import org.controlsfx.control.CheckListView
import org.controlsfx.control.CheckTreeView
import org.controlsfx.control.GridView
import org.controlsfx.control.HiddenSidesPane
import org.controlsfx.control.HyperlinkLabel
import org.controlsfx.control.InfoOverlay
import org.controlsfx.control.ListSelectionView
import org.controlsfx.control.MaskerPane
import org.controlsfx.control.MasterDetailPane
import org.controlsfx.control.NotificationPane
import org.controlsfx.control.PlusMinusSlider
import org.controlsfx.control.PrefixSelectionChoiceBox
import org.controlsfx.control.PrefixSelectionComboBox
import org.controlsfx.control.PropertySheet
import org.controlsfx.control.RangeSlider
import org.controlsfx.control.Rating
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedButton
import org.controlsfx.control.SnapshotView
import org.controlsfx.control.StatusBar
import org.controlsfx.control.TaskProgressView
import org.controlsfx.control.ToggleSwitch
import org.controlsfx.control.WorldMapView
import org.controlsfx.control.textfield.CustomPasswordField
import org.controlsfx.control.textfield.CustomTextField

val LayoutsFactory.Companion.ControlsFx: LayoutsFactory
    get() = object : LayoutsFactory(
        "features/controlsfx-layouts/src", "ktfx.controlsfx.layouts", "ControlsFxLayoutsKt"
    ) {
        init {
            // org.controlsfx.control.textfield
            CustomPasswordField::class()
            CustomTextField::class()

            // org.controlsfx.control
            BreadCrumbBar::class(T) { treeItem("selectedCrumb", T) }
            CheckComboBox::class(T) { items(T) }
            CheckListView::class(T) { items(T) }
            CheckTreeView::class(T) {
                "root"(CheckBoxTreeItem::class.parameterizedBy(T).asNullable()) { defaultValue("null") }
            }
            GridView::class(T) { items(T) }
            HiddenSidesPane::class(customClass = true)
            HyperlinkLabel::class{ text() }
            InfoOverlay::class(customClass = true) { content(); text(); }
            ListSelectionView::class(T)
            MaskerPane::class()
            MasterDetailPane::class(customClass = true) {
                "detailSide"<Side> { defaultValue("%M", Side::class.memberOf("RIGHT")) }
                "showDetailNode"<Boolean> { defaultValue("true") }
            }
            NotificationPane::class(customClass = true)
            PlusMinusSlider::class()
            PrefixSelectionChoiceBox::class(T)
            PrefixSelectionComboBox::class(T)
            PropertySheet::class {
                "items"(ObservableList::class.parameterizedBy(PropertySheet.Item::class).asNullable()) {
                    defaultValue("null")
                }
            }
            RangeSlider::class {
                "min"<Double> { defaultValue("0.0") }
                "max"<Double> { defaultValue("1.0") }
                "lowValue"<Double> { defaultValue("0.25") }
                "highValue"<Double> { defaultValue("0.75") }
            }
            Rating::class {
                "max"<Int> { defaultValue("5") }
                "rating"<Int> { defaultValue("-1") }
            }
            SegmentedBar::class("T".typeVarBy(SegmentedBar.Segment::class))
            SegmentedButton::class(customClass = true)
            SnapshotView::class(customClass = true)
            StatusBar::class()
            TaskProgressView::class("T".typeVarBy(Task::class.parameterizedBy("*".typeVarOf())))
            ToggleSwitch::class { text() }
            WorldMapView::class()
        }
    }