package kotfx.internal

import kotlin.annotation.AnnotationTarget.TYPE

@DslMarker
@Target(TYPE)
annotation class AnimationDsl

@DslMarker
@Target(TYPE)
annotation class ControlDsl

@DslMarker
@Target(TYPE)
annotation class DialogDsl

@DslMarker
@Target(TYPE)
annotation class LayoutDsl

@DslMarker
@Target(TYPE)
annotation class ServiceDsl