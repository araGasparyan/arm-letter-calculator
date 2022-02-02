package calculator;

/**
 * @author Ara Gasparyan
 */
public class DeleteCharcater {

    static String SetNewString(String temp) {
        if (temp.substring(temp.length()-1).equals("Ւ")) {
            temp = temp.substring(0, temp.length()-2) + "Ւ";
        }

        if (temp.length() == 1) return "0";

        return temp.substring(0, temp.length() - 1);
    }
}
