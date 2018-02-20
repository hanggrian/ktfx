@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.layout

import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.TilePane
import javafx.scene.layout.VBox
import javafx.scene.text.TextFlow
import kotfx.annotations.SceneDsl

inline fun anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ItemManager.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ButtonManager.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()

inline fun borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildManager.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()
inline fun ItemManager.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()
inline fun ButtonManager.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()

inline fun flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ItemManager.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ButtonManager.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()

inline fun gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ItemManager.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ButtonManager.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()

inline fun hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ItemManager.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ButtonManager.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()

inline fun stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ItemManager.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ButtonManager.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()

inline fun textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ItemManager.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ButtonManager.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()

inline fun tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildManager.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()
inline fun ItemManager.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()
inline fun ButtonManager.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()

inline fun vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildManager.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
inline fun ItemManager.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
inline fun ButtonManager.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()