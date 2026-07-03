package com.example.smartsort.model;

import java.util.List;

public class GeminiRequest {
    public List<Content> contents;

    public static class Content {
        public List<Part> parts;
    }

    public static class Part {
        public String text;
        public InlineData inline_data;
    }

    public static class InlineData {
        public String mime_type;
        public String data;
    }
}
