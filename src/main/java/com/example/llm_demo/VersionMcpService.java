package com.example.llm_demo;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

@Service
public class VersionMcpService {
    @McpTool(description = "Give latest programming language version for Java, C++, C#, JavaScript")
    public String getLatestVersion(@McpToolParam(description = "Programming language name") String language) {
        System.out.println("language = " + language);
        return "25 (LTS)";
    }
}