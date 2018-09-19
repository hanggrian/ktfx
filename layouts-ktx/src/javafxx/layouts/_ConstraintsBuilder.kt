package javafxx.layouts

import javafx.scene.layout.ConstraintsBase

@PublishedApi
@Suppress("ClassName")
internal abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T>, LayoutManager<T> {

    override val childs: MutableList<T> = mutableListOf()

    abstract fun newInstance(): T

    abstract fun newInstance(width: Double): T

    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(init: (T.() -> Unit)?): T =
        newInstance().also { init?.invoke(it) }()

    override fun constraints(size: Double, init: (T.() -> Unit)?): T =
        newInstance(size).also { init?.invoke(it) }()

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: (T.() -> Unit)?): T =
        newInstance(minSize, prefSize, maxSize).also { init?.invoke(it) }()
}