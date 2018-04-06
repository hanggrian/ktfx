@file:Suppress("ClassName")

package ktfx.layouts.internal

import javafx.scene.layout.ConstraintsBase
import ktfx.layouts.ConstraintsBuilder

@PublishedApi
internal abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T> {
    val constraints: MutableList<T> = mutableListOf()

    abstract fun newInstance(): T

    abstract fun newInstance(width: Double): T

    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(init: T.() -> Unit): T =
        newInstance().apply(init).also { constraints += it }

    override fun constraints(size: Double, init: T.() -> Unit): T =
        newInstance(size).apply(init).also { constraints += it }

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: T.() -> Unit): T =
        newInstance(minSize, prefSize, maxSize).apply(init).also { constraints += it }
}