package com.example.llm_demo;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class RestAPI {
    private final VectorStore vectorStore;

    @Autowired
    public RestAPI(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    /*  Setup:
        docker run -d --name pgvector -e POSTGRES_USER=app -e POSTGRES_PASSWORD=password -e POSTGRES_DB=demo -p 5432:5432 pgvector/pgvector:pg18-trixie
        docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
        docker exec -it ollama ollama pull mxbai-embed-large
        docker exec -it ollama ollama pull llama3.1
     */

    @GetMapping("/index")
    public String index() {
        List<Document> documents = List.of(
                new Document("Java is a high-level, object-oriented programming language known for its platform independence."),
                new Document("It is widely used for developing enterprise applications, Android apps, and big data processing systems."),
                new Document("Java's strong typing, automatic memory management, and extensive libraries contribute to its popularity.", Map.of("reason", "popularity")));

        this.vectorStore.add(documents);

        return "OK";
    }
}