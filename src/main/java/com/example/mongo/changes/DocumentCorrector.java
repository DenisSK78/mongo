package com.example.mongo.changes;

import org.bson.Document;

public interface DocumentCorrector {
    Document correct(Document document);
}
