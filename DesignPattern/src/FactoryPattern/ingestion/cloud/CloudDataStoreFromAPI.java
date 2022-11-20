package FactoryPattern.ingestion.cloud;

import FactoryPattern.ingestion.IngestToDatabase;

public class CloudDataStoreFromAPI implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Cloud : Read from API and ingest");
    }
}
