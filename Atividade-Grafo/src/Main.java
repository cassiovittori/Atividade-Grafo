import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "arquivo.txt";
        try {
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);

            int numVertices = scanner.nextInt();
            Grafo grafo = new Grafo(numVertices);

            int numArestas = scanner.nextInt();
            for (int i = 0; i < numArestas; i++) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                grafo.adicionarAresta(v1, v2);
            }

            scanner.close();

            grafo.imprimirMatrizAdjacencia();
            grafo.imprimirListaAdjacencia();

            int s = 0;
            int t = numVertices - 1;

            System.out.println("Caminho BFS:");
            grafo.bfs(s, t);

            System.out.println("Caminho DFS:");
            grafo.dfs(s, t);
        } catch (FileNotFoundException e) {
            System.out.println("Erro!");
        }
    }
}
