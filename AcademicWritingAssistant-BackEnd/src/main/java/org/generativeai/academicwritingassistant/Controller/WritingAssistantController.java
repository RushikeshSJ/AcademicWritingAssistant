package org.generativeai.academicwritingassistant.Controller;

import org.generativeai.academicwritingassistant.Model.UserHistory;
import org.generativeai.academicwritingassistant.Model.UserHistoryRepository;
import org.generativeai.academicwritingassistant.Service.WritingAssistantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/writing")
public class WritingAssistantController {
    private final WritingAssistantService writingAssistantService;
    private UserHistoryRepository userHistoryRepository;

    public WritingAssistantController(WritingAssistantService service, UserHistoryRepository repository) {
        this.writingAssistantService = service;
        this.userHistoryRepository = repository;
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> getSuggestion(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String suggestion = writingAssistantService.getSuggestion(prompt);

        UserHistory history = new UserHistory();
        history.setUserInput(prompt);
        history.setResponse(suggestion);
        history.setTimestamp(LocalDateTime.now());
        userHistoryRepository.save(history);

        return ResponseEntity.ok(suggestion);
    }
}
