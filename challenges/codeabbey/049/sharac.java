import java.util.*;
public class sharac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sal = "", n_partidas = sc.nextLine();
        int jugador1 = 0, jugador2 = 0, N = Integer.parseInt(n_partidas);
        String[] resul = new String[N];
        for (int i = 0; i <= N - 1; i++) {
            String caso_prueba = sc.nextLine();
            StringTokenizer st = new StringTokenizer(caso_prueba);
            int lon = st.countTokens();
            for (int j = 0; j <= lon - 1; j++) {
                String partida = st.nextToken();
                if (partida.equals("SP") || partida.equals("PR") || partida.equals("RS")) {
                    jugador1++;
                }
                if (partida.equals("PS") || partida.equals("RP") || partida.equals("SR")) {
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
                sal=(new StringBuilder()).append(sal).append(" ").append(resul[i]).toString();
            }
        }
        System.out.println(sal);
    }
}
