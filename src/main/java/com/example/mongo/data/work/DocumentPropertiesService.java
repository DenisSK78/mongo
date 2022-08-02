package com.example.mongo.data.work;

import com.example.mongo.data.Employee;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.EnumMap;

import static java.time.ZoneOffset.UTC;

@Service
public class DocumentPropertiesService {


    public DocumentProperties setDefaultStatuses(DocumentProperties properties) {
        DocSignStatus docSignStatus = DocSignStatus.builder()
                .timeUpdate(LocalDateTime.now(UTC))
                .signStatus(SignStatus.NOT_SIGNET)
                .build();

        DocEmailStatus docEmailStatus = DocEmailStatus.builder()
                .timeUpdate(LocalDateTime.now(UTC))
                .emailStatus(EmailStatus.NOT_SENT)
                .build();

        EnumMap<ActStatuses, DocStatus> actStatusesMap = new EnumMap<>(ActStatuses.class);
        actStatusesMap.put(ActStatuses.EMAIL_STATUS, docEmailStatus);
        actStatusesMap.put(ActStatuses.SIGN_STATUS, docSignStatus);
        properties.setStatusMap(actStatusesMap);

        return properties;
    }

    public Employee setDefaultDocumentProperties(Employee employee, Direction direction, String ownerInn) {
        DocumentProperties properties = DocumentProperties.builder()
                .docType(DocType.ACT)
                .direction(direction)
                .isDeleted(Boolean.FALSE)
                .ownerInn(ownerInn)
                .build();
        employee.setDocumentProperties(setDefaultStatuses(properties));
        return employee;
    }
}
