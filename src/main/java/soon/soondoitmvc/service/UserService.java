package soon.soondoitmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soon.soondoitmvc.domain.User;
import soon.soondoitmvc.dto.SignupReqDto;
import soon.soondoitmvc.repository.UserRepository;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(SignupReqDto dto) {
        User user = new User(dto);
        log.info("save = {}", user);
        userRepository.save(user);
    }
}
