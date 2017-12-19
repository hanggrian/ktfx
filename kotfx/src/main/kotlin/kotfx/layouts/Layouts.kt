@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.layout.*
import javafx.scene.text.TextFlow

inline fun anchorPane(init: (@KotfxDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@KotfxDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ItemManager.anchorPane(init: (@KotfxDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()

inline fun borderPane(init: (@KotfxDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildManager.borderPane(init: (@KotfxDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()
inline fun ItemManager.borderPane(init: (@KotfxDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()

inline fun flowPane(init: (@KotfxDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@KotfxDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ItemManager.flowPane(init: (@KotfxDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()

inline fun gridPane(init: (@KotfxDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@KotfxDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ItemManager.gridPane(init: (@KotfxDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()

inline fun hbox(init: (@KotfxDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@KotfxDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ItemManager.hbox(init: (@KotfxDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()

inline fun stackPane(init: (@KotfxDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@KotfxDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ItemManager.stackPane(init: (@KotfxDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()

inline fun textFlow(init: (@KotfxDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@KotfxDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ItemManager.textFlow(init: (@KotfxDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()

inline fun tilePane(init: (@KotfxDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildManager.tilePane(init: (@KotfxDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()
inline fun ItemManager.tilePane(init: (@KotfxDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()

inline fun vbox(init: (@KotfxDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildManager.vbox(init: (@KotfxDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
inline fun ItemManager.vbox(init: (@KotfxDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()