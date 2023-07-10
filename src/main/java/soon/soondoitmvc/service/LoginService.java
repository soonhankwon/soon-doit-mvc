package soon.soondoitmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import soon.soondoitmvc.domain.User;
import soon.soondoitmvc.dto.LoginReqDto;
import soon.soondoitmvc.repository.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;

    public User login(LoginReqDto dto) {
        log.info(dto.getName());
        User user = userRepository.findUserByName(dto.getName())
                .orElseThrow(() -> new IllegalArgumentException("illegal name"));
        return user.isPasswordValid(dto.getPassword()) ? user : null;
    }
}
