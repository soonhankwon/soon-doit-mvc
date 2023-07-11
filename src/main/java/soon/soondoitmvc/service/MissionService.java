package soon.soondoitmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soon.soondoitmvc.domain.Mission;
import soon.soondoitmvc.domain.User;
import soon.soondoitmvc.dto.MissionSaveReqDto;
import soon.soondoitmvc.repository.MissionRepository;
import soon.soondoitmvc.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;


    public List<Mission> findMissionsByUser(String name) {
        User user = userRepository.findUserByName(name)
                .orElseThrow(IllegalArgumentException::new);
        return missionRepository.findAllByUser(user);
    }

    @Transactional
    public void save(MissionSaveReqDto dto) {
        missionRepository.save(new Mission(dto.getDeadLine(), dto.getContent()));
        log.info("deadline={}, content={}", dto.getDeadLine(), dto.getContent());
    }
}
