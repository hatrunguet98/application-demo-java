package GEM.service.user;

import GEM.model.Role;
import GEM.model.User;
import GEM.model.UserDTO;
import GEM.model.VerificationToken;
import GEM.repository.RoleRepository;
import GEM.repository.UserRepository;
import GEM.repository.VerifyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
public class UserAcount implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    VerifyRepository verifyRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User createdAccount(UserDTO userDTO) {
        User user = new User();
        user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String token) {
        VerificationToken verificationToken = verifyRepository.findByToken(token);
        return verificationToken.getUser();
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        verifyRepository.save(verificationToken);
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        return verifyRepository.findByToken(token);
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public void deleteToken(User user) {
        verifyRepository.deleteByUser(user);
    }

    @Override
    public boolean verifyOldPassword(String oldPassword) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public void saveNewPassword(String password) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

}
