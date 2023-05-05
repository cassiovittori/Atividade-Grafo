import java.io.*;
import java.util.*;

public class Grafo {
    private int[][] matrizAdj;
    private ArrayList<ArrayList<Integer>> listaAdj;

    public Grafo(int numVertices) {
        matrizAdj = new int[numVertices][numVertices];
        listaAdj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numVertices; i++) {
            listaAdj.add(new ArrayList<Integer>());
        }
    }

    public void adicionarAresta(int v1, int v2) {
        matrizAdj[v1][v2] = 1;
        matrizAdj[v2][v1] = 1;
        listaAdj.get(v1).add(v2);
        listaAdj.get(v2).add(v1);
    }

    public void adicionarVertice() {
        int numVertices = matrizAdj.length + 1;
        int[][] novaMatriz = new int[numVertices][numVertices];
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj[i].length; j++) {
                novaMatriz[i][j] = matrizAdj[i][j];
            }
        }
        matrizAdj = novaMatriz;

        ArrayList<Integer> novaLista = new ArrayList<Integer>();
        listaAdj.add(novaLista);
    }

    public void imprimirMatrizAdjacencia() {
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj[i].length; j++) {
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimirListaAdjacencia() {
        for (int i = 0; i < listaAdj.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < listaAdj.get(i).size(); j++) {
                System.out.print(listaAdj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int s, int t) {
        boolean visitado[] = new boolean[matrizAdj.length];
        int distancia[] = new int[matrizAdj.length];
        int anterior[] = new int[matrizAdj.length];

        Queue<Integer> fila = new LinkedList<Integer>();
        fila.add(s);
        visitado[s] = true;
        distancia[s] = 0;
        anterior[s] = -1;

        while (!fila.isEmpty()) {
            int u = fila.remove();

            for (int i = 0; i < matrizAdj.length; i++) {
                if (matrizAdj[u][i] == 1 && !visitado[i]) {
                    fila.add(i);
                    visitado[i] = true;
                    distancia[i] = distancia[u] + 1;
                    anterior[i] = u;
                }
            }
        }

        if (!visitado[t]) {
            System.out.println("Não há caminho entre os vértices.");
            return;
        }

        LinkedList<Integer> caminho = new LinkedList<Integer>();
        int u = t;
        while (u != -1) {
            caminho.addFirst(u);
            u = anterior[u];
        }
    }
    public void dfs(int s, int t) {
        int numVertices;
        boolean[] visitados = new boolean[numVertices];
        Stack<Integer> pilha = new Stack<>();

        visitados[s] = true;
        pilha.push(s);

        while (!pilha.isEmpty()) {
            int v = pilha.pop();
            System.out.print(v + " ");

            if (v == t) {
                System.out.println();
                return;
            }

            for (int i = numVertices - 1; i >= 0; i--) {
                if (matrizAdj[v][i] && !visitados[i]) {
                    visitados[i] = true;
                    pilha.push(i);
                }
            }
        }

        System.out.println("Não há caminho entre os vértices.");
    }

}