package GEM.service.user;

import GEM.model.User;
import GEM.model.event.SendVerifyEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Component
public class SendEmailListtener implements ApplicationListener<SendVerifyEmail> {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(SendVerifyEmail event) {
        try {
            this.configSendEmail(event);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void configSendEmail(SendVerifyEmail event) throws MessagingException {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        iUserService.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/verifyEmail?token=" + token;
        String message = messageSource.getMessage("register.message.SendEmail", null, event.getLocale());

        MimeMessage messageEmail = mailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(messageEmail, multipart, "utf-8");
        String htmlSend = message + "<a href='"+ confirmationUrl + " '> Verity account!</a>";
        messageEmail.setContent(htmlSend, "text/html");
        helper.setFrom("testw1605@gmail.com");
        helper.setTo(recipientAddress);
        helper.setSubject("Verity accout!");
        this.mailSender.send(messageEmail);
    }
}
