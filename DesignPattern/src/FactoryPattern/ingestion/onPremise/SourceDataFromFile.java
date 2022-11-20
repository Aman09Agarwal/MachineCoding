package FactoryPattern.ingestion.onPremise;

import FactoryPattern.ingestion.IngestToDatabase;

public class SourceDataFromFile implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Read from file and ingest");
    }
}
