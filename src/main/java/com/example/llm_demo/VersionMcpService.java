package com.example.llm_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

@Service
public class VersionMcpService {
    private final Logger log = LoggerFactory.getLogger(VersionMcpService.class);

    @McpTool(description = "Give latest programming language version for Java, C++, C#, JavaScript")
    public String getLatestVersion(@McpToolParam(description = "Programming language name") String language) {
        log.info("Передан параметр language = " + language);
        return "Java".equalsIgnoreCase(language) ? "25 (LTS)" : "33";
    }
}