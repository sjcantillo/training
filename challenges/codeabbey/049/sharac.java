import java.util.Scanner;
import java.util.StringTokenizer;

public class Sharac {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sal = "", npartidas = sc.nextLine();
    int jugador1 = 0, jugador2 = 0, n = Integer.parseInt(npartidas);
    String[] resul = new String[n];
    for (int i = 0; i <= n - 1; i++) {
    String casoprueba = sc.nextLine();
    StringTokenizer st = new StringTokenizer(casoprueba);
    int lon = st.countTokens();
      for (int j = 0; j <= lon - 1; j++) {
        String partida = st.nextToken();
        if (partida.equals("SP")||partida.equals("PR")||partida.equals("RS")){
            jugador1++;
        }
        if (partida.equals("PS")||partida.equals("RP")||partida.equals("SR")){
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
        sal = (new StringBuilder()).append(sal).toString();
        sal = (new StringBuilder()).append(sal).append(" ").toString();
        sal = (new StringBuilder()).append(sal).append(resul[i]).toString();
    }
    }
  System.out.println(sal);
  }
}
