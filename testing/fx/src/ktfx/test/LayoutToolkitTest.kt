package ktfx.test

import kotlin.test.Test

abstract class LayoutToolkitTest<Manager>(private val manager: Manager) : ToolkitInitializer {

    @Test fun test() = manager.layout()

    abstract fun Manager.layout()
}

abstract class LayoutTest<Manager>(private val manager: Manager) {

    @Test fun createWithBuilder() {
        manager.createWithBuilder()
    }

    @Test fun add() {
        manager.add()
    }

    @Test fun addWithBuilder() {
        manager.addWithBuilder()
    }

    abstract fun Manager.createWithBuilder()

    abstract fun Manager.add()

    abstract fun Manager.addWithBuilder()
}