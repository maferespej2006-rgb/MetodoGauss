import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("      MÉTODO DE ELIMINACIÓN DE GAUSS    ");
        System.out.println("========================================\n");

        System.out.print("Ingresa el número de ecuaciones: ");
        int n = teclado.nextInt();
        double[][] sistema = new double[n][n + 1];

        System.out.println("\nIngresa los coeficientes y términos independientes:\n");
        for (int fila = 0; fila < n; fila++) {
            System.out.println("→ Fila " + (fila + 1) + ":");
            for (int col = 0; col <= n; col++) {
                if (col < n) {
                    System.out.print("  x" + (col + 1) + " = ");
                } else {
                    System.out.print("  Término independiente = ");
                }
                sistema[fila][col] = teclado.nextDouble();
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("MATRIZ AUMENTADA:");
        Gauss gauss = new Gauss(sistema);
        gauss.mostrarMatriz();

        System.out.println("\nCalculando...\n");
        double[] sol = gauss.resolver();

        System.out.println("=========== SOLUCIÓN ===========");
        for (int i = 0; i < sol.length; i++) {
            System.out.printf("x%d = %.6f%n", (i + 1), sol[i]);
        }
        System.out.println("=================================");
        teclado.close();
    }
}
