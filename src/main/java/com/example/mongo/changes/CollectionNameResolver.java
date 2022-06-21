package com.example.mongo.changes;

public class CollectionNameResolver {

    public static final String BASE_COLLECTIONS_NAME = "employee";

    public String getDestinationCollection(int order) {
        return buildCollectionName(order);
    }

    public String getSourceCollection(int order) {
        return buildCollectionName(order - 1);
    }

    private String buildCollectionName(int order) {
        if (order < 0) {
            throw new IllegalArgumentException("Order is negative " + order);
        }
        if (order == 0) {
            return BASE_COLLECTIONS_NAME;
        }
        return BASE_COLLECTIONS_NAME + "_v" + order;
    }
}
