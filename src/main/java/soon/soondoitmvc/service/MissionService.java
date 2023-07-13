package soon.soondoitmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soon.soondoitmvc.domain.Mission;
import soon.soondoitmvc.domain.User;
import soon.soondoitmvc.dto.MissionSaveReqDto;
import soon.soondoitmvc.dto.MissionUpdateReqDto;
import soon.soondoitmvc.repository.MissionRepository;
import soon.soondoitmvc.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MissionService {

    private final MissionRepository missionRepository;

    @Transactional
    public void save(MissionSaveReqDto dto, User user) {
        missionRepository.save(new Mission(dto.getDeadLine(), dto.getContent(), user));
        log.info("deadline={}, content={}", dto.getDeadLine(), dto.getContent());
    }

    public Mission findMissionById(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    @Transactional
    public void updateMission(Long missionId, MissionUpdateReqDto dto) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(IllegalArgumentException::new);
        mission.update(dto);
    }

    @Transactional
    public void deleteMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId).orElseThrow(IllegalArgumentException::new);
        missionRepository.delete(mission);
    }

    @Transactional(readOnly = true)
    public List<Mission> findAllMissionByUser(User user) {
        return missionRepository.findAllByUser(user);
    }
}
