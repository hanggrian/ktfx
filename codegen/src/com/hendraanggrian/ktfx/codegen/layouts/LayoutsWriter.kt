package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.annotate
import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.hendraanggrian.ktfx.codegen.CONTRACT
import com.hendraanggrian.ktfx.codegen.EXACTLY_ONCE
import com.hendraanggrian.ktfx.codegen.EXPERIMENTAL_CONTRACTS
import com.hendraanggrian.ktfx.codegen.LAYOUTS_DSL_MARKER
import com.hendraanggrian.ktfx.codegen.NEW_CHILD
import com.hendraanggrian.ktfx.codegen.OPT_IN
import com.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.asClassName
import java.io.File

object LayoutsWriter {

    fun write(factory: LayoutsFactory) {
        println("Generating to ${factory.path}:")
        factory.entries.forEach { entry ->
            val filteredEntries = factory.entries.filter { it.kClass == entry.kClass }
            val fileName = when (filteredEntries.size) {
                1 -> entry.generatedName
                else -> "${entry.generatedName}${filteredEntries.indexOf(entry)}"
            }
            println(fileName)
            buildFileSpec(factory.packageName, fileName) {
                indentSize = 4
                annotations {
                    add<JvmMultifileClass>()
                    JvmName::class { addMember("%S", factory.className) }
                    OPT_IN { addMember("%T::class", EXPERIMENTAL_CONTRACTS) }
                }
                functions {
                    entry.managerClassNames.forEach { managerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            receiver = managerClassName
                            kdoc += entry.getFileComment(add = true, styled = false, configured = false)
                            returns(entry.typeName, entry.getReturnsComment(add = true, styled = false))
                            parameters {
                                entry.parameters.forEach(::plusAssign)
                            }
                            appendLine(
                                "return ${entry.functionName}(${entry.parameters.toString(
                                    namedArgument = true, commaSuffix = false
                                )}) { }"
                            )
                        }
                    }
                    entry.fullManagerClassNames.forEach { managerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            if (managerClassName != null) receiver = managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += entry.getFileComment(
                                add = managerClassName != null, styled = false, configured = true
                            )
                            returns(
                                entry.typeName, entry.getReturnsComment(add = managerClassName != null, styled = false)
                            )
                            parameters {
                                entry.parameters.forEach(::plusAssign)
                                configuration(entry)
                            }
                            contractln()
                            appendLine {
                                append("return ")
                                if (managerClassName != null) append("addChild(")
                                append(
                                    "%M(%T(${entry.parameters.toString(
                                        namedArgument = false, commaSuffix = false
                                    )}), configuration = configuration)",
                                    NEW_CHILD, entry.customTypeName
                                )
                                if (managerClassName != null) append(")")
                            }
                        }
                    }
                    if (entry.supportStyledFunction) {
                        entry.fullManagerClassNames.forEach { managerClassName ->
                            entry.styledFunctionName {
                                entry.typeVarNames.forEach { typeVariables += it }
                                if (managerClassName != null) receiver = managerClassName
                                kdoc += entry.getFileComment(
                                    add = managerClassName != null, styled = true, configured = false
                                )
                                returns(
                                    entry.typeName,
                                    entry.getReturnsComment(add = managerClassName != null, styled = true)
                                )
                                parameters {
                                    entry.parameters.forEach(::plusAssign)
                                    styleClass()
                                    id()
                                }
                                appendLine(
                                    "return ${entry.styledFunctionName}(${entry.parameters.toString(
                                        namedArgument = true, commaSuffix = true
                                    )}styleClass = *styleClass, id = id) { }"
                                )
                            }
                        }
                        entry.fullManagerClassNames.forEach { managerClassName ->
                            entry.styledFunctionName {
                                entry.typeVarNames.forEach { typeVariables += it }
                                if (managerClassName != null) receiver = managerClassName
                                addModifiers(KModifier.INLINE)
                                kdoc += entry.getFileComment(
                                    add = managerClassName != null, styled = true, configured = true
                                )
                                returns(
                                    entry.typeName,
                                    entry.getReturnsComment(add = managerClassName != null, styled = true)
                                )
                                parameters {
                                    entry.parameters.forEach(::plusAssign)
                                    styleClass()
                                    id()
                                    configuration(entry)
                                }
                                contractln()
                                appendLine {
                                    append("return ")
                                    if (managerClassName != null) append("addChild(")
                                    append(
                                        "%M(%T(${entry.parameters.toString(
                                            namedArgument = false, commaSuffix = false
                                        )}), styleClass = *styleClass, id = id, configuration = configuration)",
                                        NEW_CHILD, entry.customTypeName
                                    )
                                    if (managerClassName != null) append(")")
                                }
                            }
                        }
                    }
                }
            }.writeTo(File(factory.path))
        }
        println("Finished!")
        println()
    }

    private fun FunSpecBuilder.contractln() = appendLine("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecListScope.styleClass() = add("styleClass", String::class, KModifier.VARARG) {
        kdoc.append("the CSS style class.")
    }

    private fun ParameterSpecListScope.id() = add("id", String::class.asNullable()) {
        kdoc.append("the CSS id.")
        defaultValue("null")
    }

    private fun ParameterSpecListScope.configuration(entry: LayoutsEntry) = add(
        "configuration", Unit::class.asClassName()
            .lambdaBy(receiver = entry.customTypeName.annotate(LAYOUTS_DSL_MARKER))
    ) {
        kdoc.append("the configuration block.")
    }
}