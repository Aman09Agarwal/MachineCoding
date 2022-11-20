package FactoryPattern.ingestion.onPremise;

import FactoryPattern.ingestion.IngestToDatabase;

public class SourceDataFromAPI implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Read from API and ingest");
    }
}
