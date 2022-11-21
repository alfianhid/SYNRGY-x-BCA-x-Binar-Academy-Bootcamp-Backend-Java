package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.payload.request.ScheduleRequest;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import com.binarxbca.chapter5.payload.response.ScheduleResponse;

public interface ScheduleService {

	PagedResponse<ScheduleResponse> getAllSchedules(int page, int size);

	ScheduleResponse getSchedule(Long id);

	ScheduleResponse updateSchedule(Long id, ScheduleRequest scheduleRequest);

	ScheduleResponse addSchedule(ScheduleRequest scheduleRequest);

	ApiResponse deleteSchedule(Long id);

//	PagedResponse<ScheduleResponse> getAllSchedulesByFilm(Long filmId, int page, int size);
}