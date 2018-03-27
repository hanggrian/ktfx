package ktfx.styles.internal

/**
 * Some css elements are somewhat complicated and type-safe styling is currently unsupported.
 * For the time being, property marked with this annotation are using unsafe traditional string.
 */
@Target(AnnotationTarget.PROPERTY)
annotation class Beta