package com.example.smartsort.api;

import com.example.smartsort.model.GeminiRequest;
import com.example.smartsort.model.GeminiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GeminiApiService {
    @POST("v1beta/models/gemini-2.5-flash:generateContent")
    Call<GeminiResponse> classifyImage(
            @Query("key") String apiKey,
            @Body GeminiRequest request
    );
}