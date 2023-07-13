package soon.soondoitmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soon.soondoitmvc.domain.Mission;
import soon.soondoitmvc.dto.MissionSaveReqDto;
import soon.soondoitmvc.dto.MissionUpdateReqDto;
import soon.soondoitmvc.service.MissionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public String missions(Model model) {
        List<Mission> missions = missionService.findAllMission();
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
    public String addMission(@Validated @ModelAttribute("mission") MissionSaveReqDto dto) {
        missionService.save(dto);
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
}
