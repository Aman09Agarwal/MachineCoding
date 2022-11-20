package FactoryPattern.storage;

import FactoryPattern.ingestion.IngestToDatabase;
import FactoryPattern.ingestion.cloud.CloudDataStoreFromAPI;
import FactoryPattern.ingestion.cloud.CloudDataStoreFromFile;

public class CloudStoreService implements IngestionService {
    IngestToDatabase ingestToDatabase = null;

    @Override
    public IngestToDatabase getInstanceFromSource(String source) {
        switch (source) {
            case "API":
                ingestToDatabase = new CloudDataStoreFromAPI();
                break;
            case "FILE":
                ingestToDatabase = new CloudDataStoreFromFile();
            default:
                break;
        }
        return ingestToDatabase;
    }
}
