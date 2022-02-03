package calculator;

/**
 * @author Ara Gasparyan
 */
public enum Massage {
    Massage1Arm("Does not exist",1,"EN"),
    Massage2Arm("Not a number",2,"EN"),
    Massage3Arm("The maximal number of digits of the natural number should be 4",3,"EN"),
    Massage4Arm("Division by zero",4,"EN");

    private final String text;
    private final int id;
    private final String language;

    Massage(String text, int id, String language) {
        this.text = text;
        this.id = id;
        this.language=language;
    }

    public String getText() {
        return text;
    }
}
