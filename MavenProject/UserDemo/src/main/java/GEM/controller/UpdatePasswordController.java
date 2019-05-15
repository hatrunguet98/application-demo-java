package GEM.controller;

import GEM.model.User;
import GEM.service.user.IUserService;
import GEM.service.user.UserAcount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class UpdatePasswordController {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    MessageSource messageSource;

    @Autowired
    private IUserService iUserService;

    @PostMapping("/updatePassword")
    public String registerAcount(WebRequest webRequest,Model model, @RequestParam("oldPassword") String oldPassword, @RequestParam("password") String password) {
        Locale locale = webRequest.getLocale();
        if(!iUserService.verifyOldPassword(oldPassword)){
            String messageValue = messageSource.getMessage("auth.message.oldPassword", null, locale);
            model.addAttribute("message", messageValue);
            return "updatePassword";
        }
        else{
            iUserService.saveNewPassword(password);
            return "/";
        }
    }
}
