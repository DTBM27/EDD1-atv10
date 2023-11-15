import java.util.Stack;

public class torre {

    Stack<Integer> pilhaOriginal = new Stack<>();
    Stack<Integer> pilhaDest = new Stack<>();
    Stack<Integer> pilhaAux = new Stack<>();

    long jogadas = 0;

    void torreHanoi(int nDiscos, Stack<Integer> original, Stack<Integer> dest, Stack<Integer> aux) {
        if (nDiscos > 0) {
            torreHanoi(nDiscos - 1, original, aux, dest);
            dest.push(original.pop());
            jogadas++;
            torreHanoi(nDiscos - 1, aux, dest, original);
        }
    }

    public static void main(String[] args) {
        torre hanoi = new torre();
        int nDiscos = 30; // ou qualquer outro número de discos

        // Inicializa a pilha original com os discos
        for (int i = nDiscos; i > 0; i--) {
            hanoi.pilhaOriginal.push(i);
        }

        long startTime = System.currentTimeMillis(); // Captura o tempo inicial

        hanoi.torreHanoi(nDiscos, hanoi.pilhaOriginal, hanoi.pilhaDest, hanoi.pilhaAux);

        long endTime = System.currentTimeMillis(); // Captura o tempo final
        long tempoTotal = endTime - startTime; // Calcula o tempo total em milissegundos

        System.out.println("Jogadas realizadas: " + hanoi.jogadas);
        System.out.println("Tempo gasto (ms): " + tempoTotal);
    }
}
