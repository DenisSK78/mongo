package com.example.mongo.changes;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import io.changock.migration.api.annotations.NonLockGuarded;

import java.util.logging.Logger;

@ChangeLog
public class MongoChanges {

    private static final Logger log = Logger.getAnonymousLogger();
    private static final String CHANGES_AUTHOR = "employee-api";

    private final CollectionNameResolver collectionNameResolver = new CollectionNameResolver();

    @ChangeSet(id = "dateTimeFormat", order = "1", author = CHANGES_AUTHOR)
    public void setDateTime(MongockTemplate mongoTemplate, @NonLockGuarded DateTimeFormatCorrector corrector) {
        log.info("Starting dateTimeFormat fix");
        migrateWith(corrector, 1, mongoTemplate);
        log.info("Finished dateTimeFormat fix");
    }


    private void migrateWith(DocumentCorrector documentCorrector,
                             int order,
                             MongockTemplate mongoTemplate) {
        mongoTemplate
                .getCollection(collectionNameResolver.getSourceCollection(order))
                .find()
                .map(documentCorrector::correct)
                .forEach(document ->
                        mongoTemplate.insert(
                                document,
                                collectionNameResolver.getDestinationCollection(order)
                        )
                );
    }
}
