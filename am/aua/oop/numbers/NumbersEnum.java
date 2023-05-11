package am.aua.oop.numbers;

public enum NumbersEnum {
    MODULAR("MODULAR"),
    COMPLEX("COMPLEX"),
    SIMPLE("SIMPLE");

    private String type;

    NumbersEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
