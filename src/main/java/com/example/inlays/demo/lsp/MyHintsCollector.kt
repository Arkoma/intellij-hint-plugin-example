package com.example.inlays.demo.lsp

import com.example.inlays.demo.model.Diagnostic
import com.intellij.codeInsight.hints.declarative.EndOfLinePosition
import com.intellij.codeInsight.hints.declarative.InlayPayload
import com.intellij.codeInsight.hints.declarative.InlayTreeSink
import com.intellij.codeInsight.hints.declarative.OwnBypassCollector
import com.intellij.codeInsight.hints.declarative.StringInlayActionPayload
import com.intellij.psi.PsiFile

class MyHintsCollector(private val diagnostics: List<Diagnostic>) : OwnBypassCollector {
    /**
     * Collects all inlays for a given file.
     */
    override fun collectHintsForFile(file: PsiFile, sink: InlayTreeSink) {
        diagnostics.forEach {
            sink.addPresentation(
                EndOfLinePosition(it.lineNumber),
                listOf( InlayPayload("my.hint", StringInlayActionPayload("you should fix this"))),
                null,
                true
            ) {
                text("you should really fix this")
            }
        }
    }

}
