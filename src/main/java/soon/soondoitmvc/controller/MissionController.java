package soon.soondoitmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soon.soondoitmvc.argumentresolver.Login;
import soon.soondoitmvc.domain.Mission;
import soon.soondoitmvc.domain.User;
import soon.soondoitmvc.dto.MissionSaveReqDto;
import soon.soondoitmvc.dto.MissionUpdateReqDto;
import soon.soondoitmvc.service.MissionService;
import soon.soondoitmvc.session.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public String missions(@Login User loginUser, Model model) {
        log.info("sessionUser = {}", loginUser);
        List<Mission> missions = missionService.findAllMissionByUser(loginUser);
        model.addAttribute("missions", missions);
        return "missions/missions";
    }

    @GetMapping("/{missionId}")
    public String mission(@PathVariable Long missionId, Model model) {
        Mission mission = missionService.findMissionById(missionId);
        model.addAttribute("mission", mission);
        return "missions/mission";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("mission", new Mission());
        return "missions/addForm";
    }

    @PostMapping("/add")
    public String addMission(@Validated @ModelAttribute("mission") MissionSaveReqDto dto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);
        missionService.save(dto, loginUser);
        return "redirect:/missions";
    }

    @GetMapping("/{missionId}/edit")
    public String editForm(@PathVariable Long missionId, Model model) {
        Mission mission = missionService.findMissionById(missionId);
        model.addAttribute("mission", mission);
        return "missions/editForm";
    }

    @PostMapping("/{missionId}/edit")
    public String edit(@PathVariable Long missionId, @ModelAttribute("mission") MissionUpdateReqDto dto) {
        missionService.updateMission(missionId, dto);
        return "redirect:/missions/{missionId}";
    }

    @PostMapping("/{missionId}/delete")
    public String delete(@PathVariable Long missionId) {
        missionService.deleteMission(missionId);
        return "redirect:/missions";
    }
}
