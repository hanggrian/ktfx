package kotfx

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class TestDsl

fun build1(builder: (@TestDsl DslReceiver1).() -> Unit) {}
fun build2(builder: (@TestDsl DslReceiver2).() -> Unit) {}


fun dslUsage() = build1 {

    dslMethod1()  // ok here

    build2 {
        dslMethod2() // ok as this lambda has implicit receiver of type DslReceiver2
        // dslMethod1() // error: 'fun DslReceiver1.dslMethod1(): Unit' cant be called in this context by implicit receiver.
    }
}


// here are some external DSL classes and their methods
class DslReceiver1

class DslReceiver2

fun DslReceiver1.dslMethod1() {}
fun DslReceiver2.dslMethod2() {}