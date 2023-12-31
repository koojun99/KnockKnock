package com.example.knockknock.domain.gathering.service;

import com.example.knockknock.global.naverclient.LocalSearchRequestDto;
import com.example.knockknock.global.naverclient.LocalSearchResponseDto;
import com.example.knockknock.global.naverclient.NaverClient;
import com.example.knockknock.global.naverclient.NaverGeocodingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationRecommendService {
    private final NaverClient naverClient;
    private final NaverGeocodingClient naverGeocodingClient;

    public LocalSearchResponseDto localSearch(String location, LocalSearchRequestDto request) {
        return naverClient.localSearch(location, request);
    }
}
