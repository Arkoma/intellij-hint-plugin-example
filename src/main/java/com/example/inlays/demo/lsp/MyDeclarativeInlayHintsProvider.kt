package com.example.inlays.demo.lsp

import com.example.inlays.demo.model.Diagnostic
import com.intellij.codeInsight.hints.declarative.InlayHintsCollector
import com.intellij.codeInsight.hints.declarative.InlayHintsProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class MyDeclarativeInlayHintsProvider : InlayHintsProvider {
    /**
     * Creates collector for given file and editor if it may create inlays, or null otherwise.
     */
    override fun createCollector(file: PsiFile, editor: Editor): InlayHintsCollector {
        // hard coded return from lsp
        val diagnostics = listOf(Diagnostic("unique-identifier", "my diagnostic", "this code is bad", 5))
        return MyHintsCollector(diagnostics)
    }
}
