
/**
 * Implementação de Fila Sequencial Circular de forma estruturada.
 *
 * Utiliza o critério FIFO
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Tamanho máximo da fila.
     */
    private static final int TAMANHO_FILA = 10;
    /**
     * Início da fila.
     */
    private static int inicio = 0;
    /**
     * Final da fila.
     */
    private static int fim = 0;
    /**
     * Tamanho atual da fila.
     */
    private static int n = 0;

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Adiciona um novo nó no final da fila.
     *
     * Também chamado de Enqueue.
     *
     * @param fila Fila onde será inserido o novo elemento.
     * @param valor Valor a ser inserido na fila.
     * @return verdadeiro ou falso se conseguiu enfileirar
     */
    public static boolean enfileirar(int[] fila, int valor) {
        if (n < TAMANHO_FILA) {
            //Calcula a próxima posição
            fim = fim % TAMANHO_FILA;
            //Adiciona o valor a fila
            fila[fim] = valor;
            //Incrementa a próxima posição
            fim = fim + 1;
            //Incrementa a quantidade de elementos
            n = n + 1;
            return true;
        } else {
            System.out.println("Enfileirar - Fila Cheia.");
            return false;
        }
    }

    /**
     * Acessa o primeiro nó da fila sem removê-lo.
     *
     * Também chamado de Peek.
     *
     * @param fila Fila que contem os nós.
     * @param n Quantidade de nós na fila.
     * @param inicio Início da fila.
     * @return o valor ou -1 se não conseguiu acessar.
     */
    public static int acessarInicio(int[] fila, int n, int inicio) {
        if (n != 0) {
            return fila[inicio];
        } else {
            System.out.println("Acessar início - Fila Vazia.");
            return -1;
        }
    }

    /**
     * Altera o dado primeiro nó da fila.
     *
     * @param fila Fila que contem os nós.
     * @param n Quantidade de nós na fila.
     * @param inicio Início da fila.
     * @param valor Novo valor para o primeiro nó.
     * @return verdadeiro ou falso se conseguiu alterar.
     */
    public static boolean alterarInicio(int[] fila, int n, int inicio, int valor) {
        if (n != 0) {
            fila[inicio] = valor;
            return true;
        } else {
            System.out.println("Alterar início - Fila Vazia.");
            return false;
        }
    }

    /**
     * Remove um nó do inicio da fila.
     *
     * Também chamado de Dequeue.
     *
     * @param fila fila que contêm os nós.
     * @return O nó que foi desemfileirado.
     */
    public static int desenfileirar(int[] fila) {
        if (n != 0) {
            //Posiciona no próximo inicio
            inicio = inicio % TAMANHO_FILA;
            //Decrementa a quantidade de nós
            n = n - 1;
            //Guarda o valor do inicio
            int valor = fila[inicio];
            //Incrementa para o próximo elemento
            inicio = inicio + 1;
            return valor;
        } else {
            System.out.println("Desemfileira - Fila Vazia.");
            return -1;
        }
    }

    /**
     * Lista os dados da fila.
     *
     * @param fila Fila para exibir os dados.
     * @param inicio Início da fila.
     * @param fim Final da fila.
     * @return Uma String com os dados da fila.
     */
    public static String listar(int[] fila, int inicio, int fim) {
        int i = 0;
        int t = inicio;
        //String de retorno
        String temp = "";
        while (i < n) {
            temp = temp + (t) + "-" + fila[t] + "\n";
            t = (t + 1) % TAMANHO_FILA;
            i = i + 1;
        }
        return temp;
    }

    /**
     * Retorna se a fila está cheia.
     *
     * @return Verdadeiro ou falso se a fila está cheia.
     */
    public static boolean estaCheia() {
        return n == TAMANHO_FILA;
    }

    /**
     * Retorna se a fila esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public static boolean estaVazia() {
        return inicio == fim;
    }

    /**
     * Retorna a quantidade de elementos da fila.
     *
     * @return A quantidade de elementos da fila.
     */
    public static int getQuantidade() {
        return n;
    }

    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declaração da fila
         */
        int fila[] = new int[TAMANHO_FILA];
        
        // Controla o menu da fila
        int opcao = -1;

        //Menu para controle da fila
        while (opcao != 9) {	
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Fila Sequencial Circular ###\n"
                    + "Selecione a opção desejada:\n"
                    + "1 - Enfileirar\n"
                    + "2 - Consultar Inicio\n"
                    + "3 - Alterar Inicio\n"
                    + "4 - Desenfileirar\n"
                    + "5 - Está cheia?\n"
                    + "6 - Está vazia?\n"
                    + "7 - Tamanho da Fila\n"
                    + "8 - Listar\n"
                    + "9 - Sair"));
            switch (opcao) {
                case 1: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (enfileirar(fila, dado) == true) {
                        JOptionPane.showMessageDialog(null, "Valor emfileirado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não emfileirado!");
                    }
                    break;
                }
                case 2: {
                     if (!estaVazia()) {
                        int dado = acessarInicio(fila, n, inicio);
                        JOptionPane.showMessageDialog(null, "O valor do início é " + dado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila vazia!");
                    }
                    break;
                }
                case 3: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (alterarInicio(fila, n, inicio, dado)) {
                        JOptionPane.showMessageDialog(null, "Alteração do início realizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alteração do início não realizada!");
                    }
                    break;
                }
                case 4: {
                    int dado = desenfileirar(fila);
                    if (dado != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi desenfileirado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não desenfileirado!");
                    }
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "Está cheia : " + estaCheia());
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(null, "Está vazia : " + estaVazia());
                    break;
                }
                case 7: {
                    JOptionPane.showMessageDialog(null, "Quantidade de elementos na fila : " + getQuantidade());
                    break;
                }
                case 8: {
                    if (!estaVazia()) {                        ;
                        JOptionPane.showMessageDialog(null, "Listagem \n" + listar(fila, inicio, fim));
                    } else {                        
                        JOptionPane.showMessageDialog(null, "Fila vazia!");
                    }
                    break;
                }
                default:
                    break;
            }//Fim Switch
        }//Fim While
    }//Fim main
}
