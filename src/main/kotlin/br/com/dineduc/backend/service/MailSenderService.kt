package br.com.dineduc.backend.service

import br.com.dineduc.backend.infraestructure.ses.Mail

interface MailSenderService {
    fun sendEmail(mail: Mail)
}