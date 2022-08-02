package com.example.mongo.data.work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.EnumMap;

@Data
@AllArgsConstructor
@Builder
public class DocumentProperties {
    private String ownerInn;
    private DocType docType;
    private Direction direction;
    private Boolean isDeleted;
    private EnumMap<ActStatuses, DocStatus> statusMap;
}
