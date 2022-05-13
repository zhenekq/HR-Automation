package by.mifort.automation.hr.dev.service;

import by.mifort.automation.hr.dev.entity.CommunicationHistory;

import java.util.List;

public interface CommunicationHistoryService {

    List<CommunicationHistory> findByOrderByCreateDateDesc();

}
