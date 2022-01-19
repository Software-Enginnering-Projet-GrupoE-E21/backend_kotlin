package br.com.dineduc.backend.component.impl

import br.com.dineduc.backend.component.HtmlParser
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import org.springframework.stereotype.Component

@Component
class HtmlParserImpl : HtmlParser {
    private val flavour = CommonMarkFlavourDescriptor()

    override fun markdownToHtml(text: String): String {
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(text)
        val html = HtmlGenerator(text, parsedTree, flavour).generateHtml()
        return html.replace("\n", "<br>")
    }

}