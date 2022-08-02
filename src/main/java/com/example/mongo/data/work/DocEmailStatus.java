package com.example.mongo.data.work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DocEmailStatus implements DocStatus {
    private EmailStatus emailStatus;
    private LocalDateTime timeUpdate;
}
