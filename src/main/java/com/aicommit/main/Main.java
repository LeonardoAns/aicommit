package com.aicommit.main;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String diff = getStagedDiff();
        if (diff.isBlank()) {
            System.out.println("No staged changes found.");
            return;
        }

        String message = generateCommitMessage(diff);
        System.out.println("Suggested commit message:\n" + message);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to use this message? (y/n)");
            if (scanner.next().trim().equalsIgnoreCase("y")) {
                commit(message);
            } else {
                System.out.println("Commit canceled.");
            }
        }
    }

    static String getStagedDiff() {
        try {
            Process process = new ProcessBuilder("git", "diff", "--cached")
                    .redirectErrorStream(true)
                    .start();
            return new String(process.getInputStream().readAllBytes());
        } catch (IOException e) {
            return "";
        }
    }

    static String generateCommitMessage(String diff) {
        String apiKey = System.getenv("OPENAI_API_KEY"); // Your api key here(env variable or hardcoded)
        OpenAiService ai = new OpenAiService(apiKey);

        String prompt = """
                Given the code diff below, generate a clear and concise Conventional Commit message:

                %s

                Rules:
                - Use Conventional Commits (feat:, fix:, chore:, etc.)
                - Be specific and use imperative mood
                - Avoid vague words like "update"
                - Max length: 150 characters
                - Output only the commit message
                Commit message:
                """.formatted(diff);

        ChatMessage system = new ChatMessage("system", "You are a helpful assistant that writes git commit messages. Please provide only one suggestion.");
        ChatMessage user = new ChatMessage("user", prompt);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(List.of(system, user))
                .maxTokens(100)
                .temperature(0.5)
                .topP(1.0)
                .n(1)
                .build();

        List<ChatCompletionChoice> choices = ai.createChatCompletion(request).getChoices();
        return choices.isEmpty() ? "Unable to generate a commit message." : choices.getFirst().getMessage().getContent().trim();
    }

    static void commit(String message) {
        try {
            new ProcessBuilder("git", "commit", "-m", message)
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            System.out.println("Error while executing commit: " + e.getMessage());
        }
    }
}
