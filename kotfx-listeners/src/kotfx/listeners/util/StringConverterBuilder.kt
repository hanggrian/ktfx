package kotfx.listeners

interface StringConverterBuilder<T> {

    fun toString(listener: (T?) -> String)

    fun fromString(listener: (String) -> T?)
}