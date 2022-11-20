package FactoryPattern.storage;

public class StorageFactory {
    public IngestionService getStorageService(String storage) {
        switch (storage) {
            case "ON_PREMISE":
                return new OnPremiseStoreService();
            case "CLOUD":
                return new CloudStoreService();
            default:
                return null;
        }
    }
}
