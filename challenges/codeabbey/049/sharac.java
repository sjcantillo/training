package sharac;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Sharac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sal = "", npartidas = sc.nextLine();
        int jugador1 = 0, jugador2 = 0, n = Integer.parseInt(npartidas);
        String[] resul = new String[n];
        boolean exp1, exp2, exp3, exp4, exp5, exp6;
        for (int i = 0; i <= n - 1; i++) {
            String casoprueba = sc.nextLine();
            StringTokenizer st = new StringTokenizer(casoprueba);
            int lon = st.countTokens();
            for (int j = 0; j <= lon - 1; j++) {
                String partida = st.nextToken();
                exp1 = partida.equals("SP");
                exp2 = partida.equals("PR");
                exp3 = partida.equals("RS");
                exp4 = partida.equals("PS");
                exp5 = partida.equals("RP");
                exp6 = partida.equals("SR");
                if (exp1 || exp2 || exp3) {
                    jugador1++;
                }
                if (exp4 || exp5 || exp6) {
                    jugador2++;
                }
            }
            if (jugador1 > jugador2) {
                resul[i] = "1";
            } else {
                resul[i] = "2";
            }
            jugador1 = 0;
            jugador2 = 0;
            if (i == 0) {
                sal = resul[i];
            } else {
                StringBuilder a = (new StringBuilder()).append(sal);
                sal = a.toString();
                sal = a.append(" ").toString();
                sal = a.append(resul[i]).toString();
            }
        }
        System.out.println(sal);
    }
}
