package ktfx.fxml

import javafx.fxml.FXMLLoader
import ktfx.internal.Experimental
import java.util.ResourceBundle

@Experimental
inline fun <T, reified C> loadFxml(
    location: String,
    resources: ResourceBundle? = null,
    block: C.() -> Unit
): T {
    val loader = FXMLLoader(C::class.java.getResource(location), resources)
    val result = loader.load<T>()
    loader.getController<C>().block()
    return result
}