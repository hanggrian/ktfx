@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.controls

import javafx.collections.ObservableList
import javafx.scene.Node
import org.controlsfx.control.decoration.Decoration
import org.controlsfx.control.decoration.Decorator

/** Adds the given decoration to the given node. */
fun Node.addDecoration(decoration: Decoration): Unit = Decorator.addDecoration(this, decoration)

/** Adds the given decorations to the given node. */
inline fun Node.addDecorations(vararg decorations: Decoration): Unit =
    decorations.forEach { Decorator.addDecoration(this, it) }

/** Removes the given decoration from the given node. */
fun Node.removeDecoration(decoration: Decoration): Unit = Decorator.removeDecoration(this, decoration)

/** Removes all the decorations that have previously been set on the given node. */
fun Node.clearDecorations(): Unit = Decorator.removeAllDecorations(this)

/** Returns all the currently set decorations for the given node. */
val Node.decorations: ObservableList<Decoration> get() = Decorator.getDecorations(this)
