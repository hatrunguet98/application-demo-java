package GEM.controller;

import GEM.model.User;
import GEM.model.VerificationToken;
import GEM.model.event.SendVerifyEmail;
import GEM.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Locale;

@Controller
public class VerifyEmailController {
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public String verifyToken(WebRequest request, Model model, @RequestParam("token") String token) {
        Locale locale = request.getLocale();
        VerificationToken verificationToken = iUserService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messageSource.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "verifyError";
        }
        User user = iUserService.getUser(token);
        Calendar cal = Calendar.getInstance();
        if(user.getVerify()==true){
            String messageValue = messageSource.getMessage("auth.message.invalidUser", null, locale);
            model.addAttribute("message", messageValue);
            return "verifyError";
        }
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messageSource.getMessage("auth.message.expiredToken", null, locale);
            model.addAttribute("message", messageValue);
            return "verifyError";
        }

        user.setVerify(true);
        iUserService.saveRegisteredUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "verifyEmailOther", method = RequestMethod.POST)
    public String sendAgain(@RequestParam("email") String email, HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        User user = iUserService.getUserByEmail(email);
        if (user == null) {
            String message = messageSource.getMessage("auth.message.invalidEmail", null, locale);
            model.addAttribute("message", message);
            return "verifyError";
        }
        else
        {
            iUserService.deleteToken(user);
            String appUrl="http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            eventPublisher.publishEvent(new SendVerifyEmail( appUrl, request.getLocale(), user));
            return "redirect:/login";
        }
    }
}
