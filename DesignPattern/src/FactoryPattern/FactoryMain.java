package FactoryPattern;

import FactoryPattern.storage.IngestionService;
import FactoryPattern.storage.StorageFactory;

public class FactoryMain {
    public static void main(String[] args) {
        StorageFactory storageFactory = new StorageFactory();
        IngestionService ingestionService = storageFactory.getStorageService("CLOUD");
        ingestionService.ingestDataToMyDB("API");
    }
}
