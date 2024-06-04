package com.example.inlays.demo.lsp

import com.intellij.codeInsight.hints.declarative.InlayHintsProviderFactory
import com.intellij.codeInsight.hints.declarative.InlayProviderInfo
import com.intellij.lang.Language

class MyInlayHintFactory : InlayHintsProviderFactory {

    private val provider = InlayProviderInfo(MyDeclarativeInlayHintsProvider(), "com.example.inlays.demo", setOf(), true, "demo")
    /**
     * Searches for provider info by id of the provider. Must provide one of the providers of [getProvidersForLanguage].
     */
    override fun getProviderInfo(language: Language, providerId: String): InlayProviderInfo = provider

    /**
     * @return list of providers which may be run on a file with specific language.
     */
    override fun getProvidersForLanguage(language: Language): List<InlayProviderInfo> = listOf(provider)

    /**
     * List of languages for which theoretically this factory may create providers (or may not).
     */
    override fun getSupportedLanguages(): Set<Language> {
        return setOf()
    }
}
