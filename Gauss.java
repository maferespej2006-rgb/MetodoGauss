/**
 * Clase: Gauss
 * Implementa el método de Eliminación de Gauss
 * Resuelve sistemas de ecuaciones lineales
 */
public class Gauss {

    private double[][] matriz;
    private int n;

    public Gauss(double[][] matrizAumentada) {
        this.n = matrizAumentada.length;
        this.matriz = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrizAumentada[i], 0, this.matriz[i], 0, n + 1);
        }
    }

    public void eliminacionAdelante() {
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = matriz[i][k] / matriz[k][k];
                for (int j = k; j <= n; j++) {
                    matriz[i][j] -= factor * matriz[k][j];
                }
            }
        }
    }

    public double[] sustitucionAtras() {
        double[] x = new double[n];
        x[n - 1] = matriz[n - 1][n] / matriz[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j];
            }
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }
        return x;
    }

    public double[] resolver() {
        eliminacionAdelante();
        return sustitucionAtras();
    }

    public void mostrarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%10.4f ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
