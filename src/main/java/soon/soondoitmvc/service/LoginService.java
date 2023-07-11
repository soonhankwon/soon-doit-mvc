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
        return userRepository.findUserByNameAndPassword(dto.getName(), dto.getPassword())
                .orElse(null);
    }
}
