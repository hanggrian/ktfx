@file:Suppress("ClassName")

package ktfx.layouts.internal

import javafx.scene.layout.ConstraintsBase
import ktfx.layouts.ConstraintsBuilder
import ktfx.layouts.LayoutManager

@PublishedApi
internal abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T>, LayoutManager<T> {
    override val childs: MutableList<T> = mutableListOf()

    abstract fun newInstance(): T

    abstract fun newInstance(width: Double): T

    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(init: (T.() -> Unit)?): T =
        newInstance().also { init?.invoke(it) }.add()

    override fun constraints(size: Double, init: (T.() -> Unit)?): T =
        newInstance(size).also { init?.invoke(it) }.add()

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: (T.() -> Unit)?): T =
        newInstance(minSize, prefSize, maxSize).also { init?.invoke(it) }.add()
}