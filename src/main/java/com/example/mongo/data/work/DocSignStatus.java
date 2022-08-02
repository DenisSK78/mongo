package com.example.mongo.data.work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DocSignStatus implements DocStatus {
    private SignStatus signStatus;
    private LocalDateTime timeUpdate;
}
