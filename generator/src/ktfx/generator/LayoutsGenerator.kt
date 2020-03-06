package ktfx.generator

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.annotate
import com.hendraanggrian.kotlinpoet.buildFile
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainerScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.asClassName
import java.io.File

object LayoutsGenerator {
    private const val OUTPUT_PATH = "ktfx-layouts/src"
    private const val OUTPUT_CLASS = "LayoutsKt"

    @JvmStatic fun main(args: Array<String>) {
        println("Generating to $OUTPUT_PATH:")
        generate()
        println("Finished!")
    }

    fun generate() = LayoutsFactory.listAll().forEach { factory ->
        println(factory.generatedName)
        buildFile(KTFX_LAYOUTS, factory.generatedName) {
            indentSize = 4
            annotations {
                add<JvmMultifileClass>()
                JvmName::class { addMember("%S", OUTPUT_CLASS) }
                OPT_IN { addMember("%T::class", EXPERIMENTAL_CONTRACTS) }
            }
            functions {
                factory.managerClassNames.forEach { managerClassName ->
                    factory.functionName {
                        factory.typeVariableNames.forEach(::addTypeVariable)
                        receiver = managerClassName
                        kdoc += factory.getComment(add = true, styled = false, configured = false)
                        returns = factory.typeName
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
                factory.fullManagerClassNames.forEach { managerClassName ->
                    factory.functionName {
                        factory.typeVariableNames.forEach(::addTypeVariable)
                        if (managerClassName != null) receiver = managerClassName
                        addModifiers(KModifier.INLINE)
                        kdoc += factory.getComment(
                            add = managerClassName != null, styled = false, configured = true
                        )
                        returns = factory.typeName
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
                            NEW_CHILD, factory.customTypeName
                        )
                        if (managerClassName != null) append(")")
                        appendln()
                    }
                }
                factory.fullManagerClassNames.forEach { managerClassName ->
                    factory.styledFunctionName {
                        factory.typeVariableNames.forEach(::addTypeVariable)
                        if (managerClassName != null) receiver = managerClassName
                        kdoc += factory.getComment(
                            add = managerClassName != null, styled = true, configured = false
                        )
                        returns = factory.typeName
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
                factory.fullManagerClassNames.forEach { managerClassName ->
                    factory.styledFunctionName {
                        factory.typeVariableNames.forEach(::addTypeVariable)
                        if (managerClassName != null) receiver = managerClassName
                        addModifiers(KModifier.INLINE)
                        kdoc += factory.getComment(add = managerClassName != null, styled = true, configured = true)
                        returns = factory.typeName
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
                            NEW_CHILD, factory.customTypeName
                        )
                        if (managerClassName != null) append(")")
                        appendln()
                    }
                }
            }
        }.writeTo(File(OUTPUT_PATH))
    }

    private fun FunSpecBuilder.contractln() = appendln("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecContainerScope.styleClass() = add("styleClass", String::class, KModifier.VARARG)

    private fun ParameterSpecContainerScope.configuration(factory: LayoutsFactory) = add(
        "configuration", factory.customTypeName
            .annotate(LAYOUTS_DSL_MARKER)
            .lambdaBy(returnType = Unit::class.asClassName())
    )
}