package br.com.dineduc.backend.component

interface HtmlParser {
    fun markdownToHtml(text:String) : String
}