package com.example.inlays.demo.lsp

import com.intellij.codeInsight.hints.declarative.InlayHintsProviderFactory
import com.intellij.codeInsight.hints.declarative.InlayProviderInfo
import com.intellij.lang.Language

class MyInlayHintFactory : InlayHintsProviderFactory {
    private val provider = InlayProviderInfo(MyDeclarativeInlayHintsProvider(), "com.example.inlays.demo", setOf(), true, "demo")
    override fun getProviderInfo(language: Language, providerId: String): InlayProviderInfo = provider
    override fun getProvidersForLanguage(language: Language): List<InlayProviderInfo> = listOf(provider)
    override fun getSupportedLanguages(): Set<Language> = setOf()
}
