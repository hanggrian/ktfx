package ktfx.generator

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.buildAnnotation
import com.hendraanggrian.kotlinpoet.buildFile
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainerScope
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.asClassName
import java.io.File

object LayoutsGenerator {
    private const val OUTPUT_PATH = "ktfx-layouts/src"
    private const val OUTPUT_CLASS = "LayoutsKt"

    @JvmStatic fun main(args: Array<String>) {
        println("Generating to $OUTPUT_PATH:")
        LayoutsFactory.values().forEach { factory ->
            println(factory.generatedName)
            buildFile(KTFX_LAYOUTS, factory.generatedName) {
                indentCount = 4
                annotations {
                    add<JvmMultifileClass>()
                    JvmName::class { addMember("%S", OUTPUT_CLASS) }
                    USE_EXPERIMENTAL { addMember("%T::class", EXPERIMENTAL_CONTRACTS) }
                }
                functions {
                    repeat(factory.managerClassNames) { managerClassName ->
                        factory.styledFunctionName {
                            if (managerClassName != null) receiver = managerClassName
                            kdoc += factory.getComment(
                                add = managerClassName != null, styled = true, configured = false
                            )
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                styleClass()
                            }
                            appendln(
                                "return ${factory.styledFunctionName}(${factory.getParameterName(
                                    namedArgument = true, commaSuffix = true
                                )}styleClass = *styleClass) { }"
                            )
                        }
                    }
                    repeat(factory.managerClassNames) { managerClassName ->
                        factory.styledFunctionName {
                            if (managerClassName != null) receiver = managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += factory.getComment(add = managerClassName != null, styled = true, configured = true)
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                styleClass()
                                configuration(factory)
                            }
                            contractln()
                            append("return ")
                            if (managerClassName != null) append("addChild(")
                            append(
                                "%M(%T(${factory.getParameterName(
                                    namedArgument = false, commaSuffix = false
                                )}), styleClass = *styleClass, configuration = configuration)",
                                NEW_CHILD, factory.customClassName
                            )
                            if (managerClassName != null) append(")")
                            appendln()
                        }
                    }
                    factory.managerClassNames.forEach {
                        factory.functionName {
                            receiver = it
                            kdoc += factory.getComment(add = true, styled = false, configured = false)
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                            }
                            appendln(
                                "return ${factory.functionName}(${factory.getParameterName(
                                    namedArgument = true, commaSuffix = false
                                )}) { }"
                            )
                        }
                    }
                    repeat(factory.managerClassNames) { managerClassName ->
                        factory.functionName {
                            if (managerClassName != null) receiver = managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += factory.getComment(
                                add = managerClassName != null, styled = false, configured = true
                            )
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                configuration(factory)
                            }
                            contractln()
                            append("return ")
                            if (managerClassName != null) append("addChild(")
                            append(
                                "%M(%T(${factory.getParameterName(
                                    namedArgument = false, commaSuffix = false
                                )}), configuration = configuration)",
                                NEW_CHILD, factory.customClassName
                            )
                            if (managerClassName != null) append(")")
                            appendln()
                        }
                    }
                }
            }.writeTo(File(OUTPUT_PATH))
        }
    }

    private fun repeat(managerClassNames: List<ClassName>, action: (managerClassName: ClassName?) -> Unit) =
        repeat(1 + managerClassNames.size) { action((listOf(null, *managerClassNames.toTypedArray()))[it]) }

    private fun FunSpecBuilder.contractln() = appendln("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecContainerScope.styleClass() = add("styleClass", String::class, KModifier.VARARG)

    private fun ParameterSpecContainerScope.configuration(factory: LayoutsFactory) = add(
        "configuration", LambdaTypeName.get(
            factory.customClassName.copy(annotations = listOf(buildAnnotation(LAYOUTS_DSL_MARKER))),
            returnType = Unit::class.asClassName()
        )
    )
}