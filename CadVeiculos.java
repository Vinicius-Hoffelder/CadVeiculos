import java.util.ArrayList;

public class CadVeiculos {

    static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        int op;

        do {
            IO.println("\n1-Cadastrar  2-Listar  3-Remover índice");
            IO.println("4-Buscar  5-Editar  6-Remover nome  0-Sair");

            op = Input.readInt("Opção: ");

            switch (op) {
                case 1:
                    String nome = Input.readString("Nome: ");

                    if (nome.trim().isEmpty()) {
                        IO.println("Inválido");
                        break;
                    }

                    boolean existe = false;
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).equalsIgnoreCase(nome)) {
                            existe = true;
                        }
                    }

                    if (existe) {
                        IO.println("Já existe");
                    } else {
                        lista.add(nome);
                        IO.println("Cadastrado");
                    }
                    break;

                case 2:
                    if (lista.size() == 0) {
                        IO.println("Lista vazia");
                        break;
                    }

                    ordenar();

                    for (int i = 0; i < lista.size(); i++) {
                        IO.println(i + " - " + lista.get(i));
                    }

                    IO.println("Total: " + lista.size());
                    break;

                case 3:
                    if (lista.size() == 0) {
                        IO.println("Lista vazia");
                        break;
                    }

                    int i = Input.readInt("Índice: ");

                    if (i >= 0 && i < lista.size()) {
                        lista.remove(i);
                        IO.println("Removido");
                    } else {
                        IO.println("Erro");
                    }
                    break;

                case 4:
                    if (lista.size() == 0) {
                        IO.println("Lista vazia");
                        break;
                    }

                    String busca = Input.readString("Buscar: ");
                    boolean achou = false;

                    ordenar();

                    for (int j = 0; j < lista.size(); j++) {
                        if (lista.get(j).equalsIgnoreCase(busca)) {
                            IO.println("Encontrado: " + lista.get(j));
                            achou = true;
                        }
                    }

                    if (!achou) IO.println("Não encontrado");

                    IO.println("Total: " + lista.size());
                    break;

                case 5:
                    if (lista.size() == 0) {
                        IO.println("Lista vazia");
                        break;
                    }

                    int idx = Input.readInt("Índice: ");

                    if (idx < 0 || idx >= lista.size()) {
                        IO.println("Erro");
                        break;
                    }

                    String novo = Input.readString("Novo nome: ");

                    if (novo.trim().isEmpty()) {
                        IO.println("Inválido");
                        break;
                    }

                    boolean dup = false;
                    for (int k = 0; k < lista.size(); k++) {
                        if (lista.get(k).equalsIgnoreCase(novo)) {
                            dup = true;
                        }
                    }

                    if (dup) {
                        IO.println("Já existe");
                    } else {
                        lista.set(idx, novo);
                        IO.println("Editado");
                    }
                    break;

                case 6:
                    if (lista.size() == 0) {
                        IO.println("Lista vazia");
                        break;
                    }

                    String rem = Input.readString("Nome: ");
                    boolean ok = false;

                    for (int k = 0; k < lista.size(); k++) {
                        if (lista.get(k).equalsIgnoreCase(rem)) {
                            lista.remove(k);
                            ok = true;
                            break;
                        }
                    }

                    if (ok) IO.println("Removido");
                    else IO.println("Não encontrado");
                    break;
            }

        } while (op != 0);
    }

    static void ordenar() {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (lista.get(j).compareToIgnoreCase(lista.get(j + 1)) > 0) {
                    String temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
}
