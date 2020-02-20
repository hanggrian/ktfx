package ktfx.generator

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.buildAnnotation
import com.hendraanggrian.kotlinpoet.buildFile
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainerScope
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.asClassName
import java.io.File

object LayoutsGenerator {

    @JvmStatic fun main(args: Array<String>) {
        LayoutsFactory.values().forEach { factory ->
            println("Generating ${factory.simpleName}...")
            buildFile(KTFX_LAYOUTS, "_${factory.simpleName}") {
                indentCount = 4
                annotations {
                    add<JvmMultifileClass>()
                    JvmName::class { addMember("%S", "LayoutsKt") }
                    USE_EXPERIMENTAL { addMember("ExperimentalContracts::class") }
                }
                addImport("kotlin.contracts", "ExperimentalContracts", "InvocationKind", "contract")
                addImport("ktfx.internal.KtfxInternals", "newChild")
                functions {
                    repeat(2) { time ->
                        factory.styledFunctionName {
                            if (time == 1) receiver = factory.managerClassName
                            kdoc.append(factory.getComment(hasReceiver = time == 1, isStyled = true))
                            returns(factory.kClass)
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                styleClass()
                            }
                            appendln("return ${factory.styledFunctionName}(*styleClass) { }")
                        }
                    }
                    repeat(2) { time ->
                        factory.styledFunctionName {
                            if (time == 1) receiver = factory.managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc.append(
                                factory.getComment(
                                    hasReceiver = time == 1,
                                    isStyled = true,
                                    hasConfiguration = true
                                )
                            )
                            returns(factory.kClass)
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                styleClass()
                                configuration(factory)
                            }
                            appendlnContract()
                            appendln(
                                buildString {
                                    append("return ")
                                    if (time == 1) append("addChild(")
                                    append("newChild(%T(), *styleClass, configuration = configuration)")
                                    if (time == 1) append(')')
                                },
                                factory.customClassName
                            )
                        }
                    }
                    factory.functionName {
                        receiver = factory.managerClassName
                        kdoc.append(factory.getComment(hasReceiver = true))
                        returns(factory.kClass)
                        parameters {
                            factory.parameterSpecs.forEach(::add)
                        }
                        appendln("return ${factory.functionName} { }")
                    }
                    repeat(2) { time ->
                        factory.functionName {
                            if (time == 1) receiver = factory.managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc.append(factory.getComment(hasReceiver = time == 1, hasConfiguration = true))
                            returns(factory.kClass)
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                configuration(factory)
                            }
                            appendlnContract()
                            appendln(
                                buildString {
                                    append("return ")
                                    if (time == 1) append("addChild(")
                                    append("newChild(%T(), configuration = configuration)")
                                    if (time == 1) append(')')
                                },
                                factory.customClassName
                            )
                        }
                    }
                }
            }.writeTo(File("ktfx-layouts/src"))
        }
    }

    private fun FunSpecBuilder.appendlnContract() =
        appendln("contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }")

    private fun ParameterSpecContainerScope.styleClass() =
        add("styleClass", String::class, KModifier.VARARG)

    private fun ParameterSpecContainerScope.configuration(factory: LayoutsFactory) =
        add(
            "configuration", LambdaTypeName.get(
                factory.customClassName.copy(annotations = listOf(buildAnnotation(LAYOUTS_DSL_MARKER))),
                returnType = Unit::class.asClassName()
            )
        )
}