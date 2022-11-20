package FactoryPattern.ingestion.cloud;

import FactoryPattern.ingestion.IngestToDatabase;

public class CloudDataStoreFromFile implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Cloud : Read from file and ingest");
    }
}
