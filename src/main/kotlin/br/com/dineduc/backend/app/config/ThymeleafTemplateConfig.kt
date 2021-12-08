package br.com.dineduc.backend.app.config

import org.springframework.context.annotation.Bean
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.templatemode.TemplateMode
import java.nio.charset.StandardCharsets


class ThymeleafTemplateConfig (
    private val htmlTemplateResolver: SpringResourceTemplateResolver
        ) {
    @Bean
    fun springTemplateEngine(): SpringTemplateEngine {
        val templateEngine = SpringTemplateEngine()
        templateEngine.addTemplateResolver(htmlTemplateResolver)
        return templateEngine
    }

    @Bean
    fun htmlTemplateResolver(): SpringResourceTemplateResolver {
        val emailTemplateResolver = SpringResourceTemplateResolver()
        emailTemplateResolver.prefix = "/templates/"
        emailTemplateResolver.suffix = ".html"
        emailTemplateResolver.templateMode = TemplateMode.HTML
        emailTemplateResolver.characterEncoding = StandardCharsets.UTF_8.name()
        return emailTemplateResolver
    }
}