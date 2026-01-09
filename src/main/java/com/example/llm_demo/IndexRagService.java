package com.example.llm_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*  Setup:
    docker run -d --name pgvector -e POSTGRES_USER=app -e POSTGRES_PASSWORD=password -e POSTGRES_DB=demo -p 5432:5432 pgvector/pgvector:pg18-trixie
    docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
    docker exec -it ollama ollama pull mxbai-embed-large
 */

@Service
public class IndexRagService implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(IndexRagService.class);
    private final VectorStore vectorStore;

    @Autowired
    public IndexRagService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) throws Exception {
        index();
    }

    private void index() {
        log.info("Начинаю индексировать документы...");

        List<Document> documents = List.of(
                new Document("Java is a high-level, object-oriented programming language known for its platform independence."),
                new Document("It is widely used for developing enterprise applications, Android apps, and big data processing systems."),
                new Document("Java's strong typing, automatic memory management, and extensive libraries contribute to its popularity.", Map.of("reason", "popularity")));

        this.vectorStore.add(documents);
        log.info("Документы проиндексированы");
    }
}