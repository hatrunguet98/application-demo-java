package GEM.model.event;

import GEM.model.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class SendVerifyEmail extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private User user;

    public SendVerifyEmail(String appUrl, Locale locale, User user) {
        super(user);
        this.appUrl = appUrl;
        this.locale = locale;
        this.user = user;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }
}
