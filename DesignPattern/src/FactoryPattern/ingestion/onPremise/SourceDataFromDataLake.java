package FactoryPattern.ingestion.onPremise;

import FactoryPattern.ingestion.IngestToDatabase;

public class SourceDataFromDataLake implements IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Read from data lake and ingest");
    }
}
