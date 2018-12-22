package ktfx.fxml

import javafx.fxml.FXMLLoader

inline fun <T, C> FXMLLoader.use(block: C.() -> Unit): T {
    val result = load<T>()
    getController<C>().block()
    return result
}