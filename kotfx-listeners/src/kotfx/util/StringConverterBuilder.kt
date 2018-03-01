package kotfx.util

interface StringConverterBuilder<T> {

    fun toString(listener: (T?) -> String)

    fun fromString(listener: (String) -> T?)
}