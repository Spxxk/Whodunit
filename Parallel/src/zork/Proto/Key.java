package zork.Proto;

public class Key extends Item {
    private String keyId;
    
    public Key(String keyId, String keyName, double weight) {
        super(keyName, weight, false);
        this.keyId = keyId;
    }
    
    public String getKeyId() {
        return keyId;
    }
}
