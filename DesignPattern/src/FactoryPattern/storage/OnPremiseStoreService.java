package FactoryPattern.storage;

import FactoryPattern.ingestion.IngestToDatabase;
import FactoryPattern.ingestion.onPremise.SourceDataFromAPI;
import FactoryPattern.ingestion.onPremise.SourceDataFromDataLake;
import FactoryPattern.ingestion.onPremise.SourceDataFromFile;

public class OnPremiseStoreService implements IngestionService {
    IngestToDatabase ingestToDatabase = null;

    @Override
    public IngestToDatabase getInstanceFromSource(String source) {
        switch (source) {
            case "API":
                ingestToDatabase = new SourceDataFromAPI();
                break;
            case "FILE":
                ingestToDatabase = new SourceDataFromFile();
                break;
            case "DATA_LAKE":
                ingestToDatabase = new SourceDataFromDataLake();
            default:
                break;
        }
        return ingestToDatabase;
    }
}
