
import java.util.Scanner;
import utilities.utilities;

public class M05UF2Practica1Git {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        int operacion;
        String decision;
        boolean comprobar = false;

        do {

            String numero1;
            do {
                System.out.println("\n Introdueix el primer numero.");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {
                utilities.imprimirMenu();
                operacion = sc.nextInt();
                sc.nextLine();
                if (operacion>0 && operacion<7) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.println("\n Introdueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

            do {
                comprobar = true;
                switch (operacion) {
                    case 1:
                        res = utilities.suma(n1, n2);
                        break;
                    case 2:
                        res = utilities.resta(n1, n2);
                        break;
                    case 3:
                        res = utilities.multiplicacion(n1,n2);
                        break;
                    case 4:
                        while (n2 == 0) {
                            do {
                                System.err.println(" Al denominador hi ha un zero \n"
                                        + "per a  evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = utilities.division(n1, n2);
                        break;
                    case 5:
                        res = Math.pow(n1, n2);
                        break;
                    case 6:
                        while (n2 == 0) {
                            do {
                                System.err.println(" Al denominador hi ha un zero \n"
                                        + "per a  evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n Vols continuar operant? \n");
            System.out.println(" [s/n]");
            do {
                comprobar = true;
                decision = sc.nextLine();

                switch (decision) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (comprobar != true);
        } while (decision.equals("s") || decision.equals("S"));
    }
}
