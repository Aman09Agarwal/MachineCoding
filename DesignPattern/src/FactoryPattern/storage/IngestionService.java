package FactoryPattern.storage;

import FactoryPattern.ingestion.IngestToDatabase;

public interface IngestionService {
    default void ingestDataToMyDB(String source) {
        IngestToDatabase sourceObject = getInstanceFromSource(source);
        sourceObject.ingestData();
    }
    IngestToDatabase getInstanceFromSource(String source);
}
