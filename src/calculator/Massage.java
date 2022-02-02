package calculator;

/**
 * @author Ara Gasparyan
 */
public enum Massage {
    Massage1Arm("չգոյ",1,"AM"),
    Massage2Arm("Մուտքագրուած թիւն գոյութիւն չունի",2,"AM"),
    Massage3Arm("Մուտագրուէք չորս թուանշանից ոչ ավել թուանշան պարոնակող թիւ",3,"AM"),
    Massage4Arm("Զրոյի վրայ բաժանումն խստիւ արգելվում է",4,"AM");

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
