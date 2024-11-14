package org.generativeai.academicwritingassistant.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class WritingAssistantService {
    @Value("${openai.api.key}")
    private String openAiApiKey;

    // The chat completions API endpoint for GPT-3.5-turbo
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public String getSuggestion(String prompt) {
        try {
            // Set up HTTP headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + openAiApiKey);
            headers.set("Content-Type", "application/json");

            // Create the request body with messages array for chat format
            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "gpt-3.5-turbo");

            // Prepare message content for chat format
            JSONArray messages = new JSONArray();
            JSONObject userMessage = new JSONObject();
            userMessage.put("role", "user");
            userMessage.put("content", prompt);
            messages.put(userMessage);

            requestBody.put("messages", messages);
            requestBody.put("max_tokens", 150);
            requestBody.put("temperature", 0.7);

            // Make HTTP request
            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

            // Parse the response to get the generated text
            JSONObject jsonResponse = new JSONObject(response.getBody());
            String generatedText = jsonResponse
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content")
                    .trim();

            return generatedText;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating suggestion. Please try again. Because API Rate Limit";
        }
    }
}
