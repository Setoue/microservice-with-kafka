package com.setoue.data.services;

import com.setoue.data.dto.CarPostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDto carPostDto);

}
