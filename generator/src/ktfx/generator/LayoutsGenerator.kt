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
                    repeatTwice { isAdd ->
                        factory.styledFunctionName {
                            if (isAdd) receiver = factory.managerClassName
                            kdoc += factory.getComment(isAdd = isAdd, isStyled = true)
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                styleClass()
                            }
                            appendln("return ${factory.styledFunctionName}(styleClass = *styleClass) { }")
                        }
                    }
                    repeatTwice { isAdd ->
                        factory.styledFunctionName {
                            if (isAdd) receiver = factory.managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += factory.getComment(isAdd = isAdd, isStyled = true, hasConfiguration = true)
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                styleClass()
                                configuration(factory)
                            }
                            contractln()
                            append("return ")
                            if (isAdd) append("addChild(")
                            append(
                                "%M(%T(), styleClass = *styleClass, configuration = configuration)",
                                NEW_CHILD,
                                factory.customClassName
                            )
                            if (isAdd) append(")")
                            appendln()
                        }
                    }
                    factory.functionName {
                        receiver = factory.managerClassName
                        kdoc += factory.getComment(isAdd = true)
                        returns = factory.className
                        parameters {
                            factory.parameterSpecs.forEach(::add)
                        }
                        appendln("return ${factory.functionName} { }")
                    }
                    repeatTwice { isAdd ->
                        factory.functionName {
                            if (isAdd) receiver = factory.managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += factory.getComment(isAdd = isAdd, hasConfiguration = true)
                            returns = factory.className
                            parameters {
                                factory.parameterSpecs.forEach(::add)
                                configuration(factory)
                            }
                            contractln()
                            append("return ")
                            if (isAdd) append("addChild(")
                            append("%M(%T(), configuration = configuration)", NEW_CHILD, factory.customClassName)
                            if (isAdd) append(")")
                            appendln()
                        }
                    }
                }
            }.writeTo(File(OUTPUT_PATH))
        }
    }

    private fun repeatTwice(action: (isAdd: Boolean) -> Unit) = repeat(2) { action(it == 1) }

    private fun FunSpecBuilder.contractln() = appendln("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecContainerScope.styleClass() = add("styleClass", String::class, KModifier.VARARG)

    private fun ParameterSpecContainerScope.configuration(factory: LayoutsFactory) = add(
        "configuration", LambdaTypeName.get(
            factory.customClassName.copy(annotations = listOf(buildAnnotation(LAYOUTS_DSL_MARKER))),
            returnType = Unit::class.asClassName()
        )
    )
}