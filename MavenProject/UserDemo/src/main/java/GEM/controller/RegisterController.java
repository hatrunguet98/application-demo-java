package GEM.controller;

import GEM.model.User;
import GEM.model.UserDTO;
import GEM.model.event.SendVerifyEmail;
import GEM.service.user.UserAcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegisterController {
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    UserAcount userAcount;

    @Autowired
    MessageSource messageSource;

    @PostMapping("/registration")
    public String registerAcount(@ModelAttribute("user") @Valid UserDTO accountDto, HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        User registrationUser = userAcount.createdAccount(accountDto);
        if (registrationUser == null) {
            String messageValue = messageSource.getMessage("register.message.Success", null, locale);
            model.addAttribute("message", messageValue);
        }
        String appUrl="http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        eventPublisher.publishEvent(new SendVerifyEmail( appUrl, request.getLocale(), registrationUser));
        return "redirect:/";
    }
}