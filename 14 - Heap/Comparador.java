public class Comparador {
    public int compare(Object x, Object y) {
        try {    
            int a = (int) x;
            int b = (int) y;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        } catch(Exception e) {
            System.out.println("Deu erro: " + e);
        }
        return 0;
    }
}