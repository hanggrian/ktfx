package ktfx.rules

import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.PsiElement

inline fun <reified T : PsiElement> ASTNode.psi(): T = getPsi(T::class.java)