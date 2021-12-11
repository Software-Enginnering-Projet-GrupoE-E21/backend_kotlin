package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.infraestructure.ses.Mail
import br.com.dineduc.backend.service.MailSenderService
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring5.SpringTemplateEngine
import java.nio.charset.StandardCharsets
import javax.mail.MessagingException
import javax.mail.internet.MimeMessage


@Service
class MailSenderServiceImpl (
    private val javaMailSender: JavaMailSender,
    private val templateEngine: SpringTemplateEngine,
        ) : MailSenderService {

    @Async
    @Throws(MessagingException::class)
    override fun sendEmail(mail: Mail) {
        val message = getMimeMessage(mail)
        javaMailSender.send(message)
    }

    @Throws(MessagingException::class)
    private fun getMimeMessage(mail: Mail): MimeMessage? {
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(
            message,
            MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
            StandardCharsets.UTF_8.name()
        )
        val context = Context()
        context.setVariables(mail.model)
        val html = templateEngine.process("confirm_email", context)
        helper.setTo(mail.to ?: "")
        helper.setText(html, true)
        helper.setSubject(mail.subject ?: "")
        helper.setFrom(mail.from ?: "")
        return message
    }
}