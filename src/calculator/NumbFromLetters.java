package calculator;

/**
 * @author Ara Gasparyan
 */
public class NumbFromLetters {
    private static String letters ="ԱԲԳԴԵԶԷԸԹԺԻԼԽԾԿՀՁՂՃՄՅՆՇՈՉՊՋՌՍՎՏՐՑՒՓՔ";
  
    private static int numbers [] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900,
            1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000 };
   
    private static int length;
    
    static String NumbConverter (String let) {
         String tmp;
         int k;

         int counter = 0;
         int result = 0;
         length = let.length();

         for (int i = length-1; i >= 0; i--) {
              tmp = Character.toString(let.charAt(i));
              if (tmp.equals("Ւ")) i--;

              k = letters.indexOf(tmp, 0);
              counter++;

              if (counter == 1) {
                  result += numbers[k];
              } else if ((counter == 2) && (result >= 1) && (result <= 9) && (k < 9 )) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 2) && (result >= 10) && (result <= 99) && (k < 18)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 2) && (result >= 100) && (result <= 999) && (k < 27)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 2) && (result >= 1000) && (result <= 9999)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 2)) {
                  result += numbers[k];
              } else if ((counter == 3) && (result >= 10) && (result <= 99) && (k < 18)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 3) && (result >= 100) && (result <= 999) && (k < 27)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 3) && (result >= 1000) && (result <= 9999)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 3)) {
                  result+=numbers[k];
              } else if ((counter == 4) && (result >= 100) && (result <= 999) && (k < 27)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 4) && (result >= 1000) && (result <= 9999)) {
                  return Massage.Massage2Arm.getText();
              } else if ((counter == 4)) {
                  result += numbers[k];
              } else if ((counter > 4)) return Massage.Massage2Arm.getText();
         }

         return Integer.toString(result);
    }

    static String LettConverter(String ntemp) {
        int length = ntemp.length();
        int [] numbs = {1000,100,10,1};
        String stmp = "";

        if (length > 4) return Massage.Massage3Arm.getText();
        else {
            int ntmp;
            int x = Integer.parseInt(ntemp);

            for (int i = 0; i<4; i++) {
                ntmp = (int) (x / numbs[i]);

                if ((i == 0) && (ntmp != 0)) {
                    if (letters.charAt(letters.length() - 10 + ntmp) == 'Ւ') stmp += "ՈՒ";
                    else stmp += letters.charAt(letters.length() - 10 + ntmp);
                } else if ((i == 1) && (ntmp !=0 )) {
                    if (letters.charAt(letters.length() - 19 +  ntmp) == 'Ւ') stmp += "ՈՒ";
                    else stmp += letters.charAt(letters.length() - 19 + ntmp);
                } else if ((i == 2) && (ntmp != 0)) {
                    if (letters.charAt(letters.length() - 28 + ntmp) == 'Ւ') stmp += "ՈՒ";
                    else stmp += letters.charAt(letters.length() - 28 + ntmp);
                } else if ((i == 3) && (ntmp != 0)) {
                    if (letters.charAt(letters.length() - 37 + ntmp) == 'Ւ') stmp += "ՈՒ";
                    else stmp += letters.charAt(letters.length() - 37 + ntmp);
                }

                x -= (ntmp*numbs[i]);
            }
        }
        
        return stmp;
    }
}
