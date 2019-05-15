package GEM.service.user;

import GEM.model.User;
import GEM.model.UserDTO;
import GEM.model.VerificationToken;

public interface IUserService {
    User createdAccount(UserDTO userDTO);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    User getUserByEmail(String email);

    void deleteToken(User user);

    boolean verifyOldPassword(String oldPassword);

    void saveNewPassword(String password);
}
