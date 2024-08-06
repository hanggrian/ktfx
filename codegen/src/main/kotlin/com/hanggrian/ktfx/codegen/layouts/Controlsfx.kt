package com.hanggrian.ktfx.codegen.layouts

import com.hanggrian.kotlinpoet.generics
import com.hanggrian.kotlinpoet.genericsBy
import com.hanggrian.kotlinpoet.name
import com.hanggrian.kotlinpoet.nullable
import com.hanggrian.ktfx.codegen.T
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
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
    get() =
        object : LayoutsFactory(
            "thirdparty/ktfx-controlsfx-layouts/src/main/kotlin",
            "ktfx.controlsfx.layouts",
            "ControlsfxLayoutsKt",
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
                    "root"(CheckBoxTreeItem::class.name.parameterizedBy(T).nullable()) {
                        defaultValue("null")
                    }
                }
                GridView::class(T) { items(T) }
                HiddenSidesPane::class(customClass = true)
                HyperlinkLabel::class { text() }
                InfoOverlay::class(customClass = true) {
                    content()
                    text()
                }
                ListSelectionView::class(T)
                MaskerPane::class()
                MasterDetailPane::class(customClass = true) {
                    "detailSide"(Side::class.name) {
                        defaultValue("%M", Side::class.name.member("RIGHT"))
                    }
                    "showDetailNode"(BOOLEAN) { defaultValue("true") }
                }
                NotificationPane::class(customClass = true)
                PlusMinusSlider::class()
                PrefixSelectionChoiceBox::class(T)
                PrefixSelectionComboBox::class(T)
                PropertySheet::class {
                    "items"(
                        ObservableList::class.parameterizedBy(PropertySheet.Item::class).nullable(),
                    ) {
                        defaultValue("null")
                    }
                }
                RangeSlider::class {
                    "min"(DOUBLE) { defaultValue("0.0") }
                    "max"(DOUBLE) { defaultValue("1.0") }
                    "lowValue"(DOUBLE) { defaultValue("0.25") }
                    "highValue"(DOUBLE) { defaultValue("0.75") }
                }
                Rating::class {
                    "max"(INT) { defaultValue("5") }
                    "rating"(INT) { defaultValue("-1") }
                }
                SegmentedBar::class("T".genericsBy(SegmentedBar.Segment::class))
                SegmentedButton::class(customClass = true)
                SnapshotView::class(customClass = true)
                StatusBar::class()
                TaskProgressView::class(
                    "T".genericsBy(Task::class.name.parameterizedBy("*".generics)),
                )
                ToggleSwitch::class { text() }
                WorldMapView::class()
            }
        }
