package by.mifort.automation.hr.dev.util;

import by.mifort.automation.hr.dev.dto.CommunicationHistoryDto;
import by.mifort.automation.hr.dev.entity.CommunicationHistory;

public interface AssertDifferencesUpdates {

    CommunicationHistory assertCommunicationHistoryAndDto(CommunicationHistory history, CommunicationHistoryDto historyDto);

}
