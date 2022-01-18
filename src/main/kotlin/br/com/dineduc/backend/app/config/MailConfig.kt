//package br.com.dineduc.backend.app.config
//
//import br.com.dineduc.backend.infraestructure.ses.Mail
//import com.amazonaws.auth.AWSStaticCredentialsProvider
//import com.amazonaws.auth.BasicAWSCredentials
//import com.amazonaws.regions.Regions
//import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
//import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
//import io.awspring.cloud.ses.SimpleEmailServiceJavaMailSender
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.mail.javamail.JavaMailSender
//
//@Configuration
//class MailConfig(
//    @Value("\${dineduc.aws.accessKey}")
//    private val accessKey: String,
//    @Value("\${dineduc.aws.secretKey}")
//    private val secretKey: String
//) {
//
//
//    @Bean
//    fun amazonSimpleEmailService() : AmazonSimpleEmailService {
//       return AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(
//            AWSStaticCredentialsProvider(
//                BasicAWSCredentials(
//                    accessKey, secretKey
//                )
//            )
//        ).withRegion(Regions.SA_EAST_1).build();
//    }
//
//    @Bean
//    fun javaMailSender (amazonSimpleEmailService: AmazonSimpleEmailService): JavaMailSender{
//        return SimpleEmailServiceJavaMailSender(amazonSimpleEmailService)
//    }
//
//}

class MailConfig(){}