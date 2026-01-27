package agenda;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();

        Contato c1 = new Contato("Maria", "4002-8022", "maria@gmail.com");
        Contato c2 = new Contato("João", "98888-0000", "joao@gmail.com");
        Contato c3 = new Contato("Ana", "97777-1111", "ana@gmail.com");

        dao.salvar(c1);
        dao.salvar(c2);
        dao.salvar(c3);

        System.out.println("=== Todos os contatos do banco ===");
        List<Contato> banco = dao.listarTodos();
        for (Contato c : banco) {
            System.out.println(c);
        }

        System.out.println("\n=== Buscando Ana no banco ===");
        Contato busca = dao.buscarPorNome("Ana");
        if (busca != null) {
            System.out.println(busca);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
