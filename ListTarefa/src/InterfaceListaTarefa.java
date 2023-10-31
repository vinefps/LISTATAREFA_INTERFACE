import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class InterfaceListaTarefa extends JFrame {

    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private int i = 0;

    public InterfaceListaTarefa() {
        setTitle("Aplicativo de Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JButton adicionarButton = new JButton("Adicionar Tarefa");
        JButton removerButton = new JButton("Remover Tarefa");
        JButton listarButton = new JButton("Listar Tarefas");
        JButton gerarJsonButton = new JButton("Gerar JSON");
        JButton lerJsonButton = new JButton("Ler JSON");
        JButton sairButton = new JButton("Sair");

        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeTarefa = JOptionPane.showInputDialog("Digite a tarefa a ser adicionada:");
                Tarefa objTarefa = new Tarefa();
                objTarefa.setCod_tarefa(i++);
                objTarefa.setNome_tarefa(nomeTarefa);
                adicionarTarefa(tarefas, objTarefa);
            }
        });

        removerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String indiceStr = JOptionPane.showInputDialog("Digite o índice da tarefa a ser removida:");
                int indice = Integer.parseInt(indiceStr);
                removerTarefa(tarefas, indice);
            }
        });

        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarTarefas(tarefas);
            }
        });

        gerarJsonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarJson(tarefas);
            }
        });

        lerJsonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lerJson(tarefas);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(adicionarButton);
        panel.add(removerButton);
        panel.add(listarButton);
        panel.add(gerarJsonButton);
        panel.add(lerJsonButton);
        panel.add(sairButton);

        add(panel);
    }

    private void adicionarTarefa(ArrayList<Tarefa> tarefas, Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    private void removerTarefa(ArrayList<Tarefa> tarefas, int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
        } else {
            JOptionPane.showMessageDialog(this, "Índice inválido.");
        }
    }

    private void listarTarefas(ArrayList<Tarefa> tarefas) {
        StringBuilder lista = new StringBuilder();
        for (Tarefa tarefa : tarefas) {
            lista.append(tarefa.getCod_tarefa()).append(". ").append(tarefa.getNome_tarefa()).append("\n");
        }
        JOptionPane.showMessageDialog(this, lista.toString());
    }

    private static void gerarJson(ArrayList<Tarefa> tarefas) {
        Gson gson = new Gson();
        // converte objetos Java para JSON e retorna JSON como String
        String json = gson.toJson(tarefas);
        try {
            // Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter("tarefas.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    private static void lerJson(ArrayList<Tarefa> tarefas) {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("tarefas.json"));
            //Converte String JSON para objeto Java
            ArrayList<Tarefa> arrayListTarefas = gson.fromJson(br, ArrayList.class);
            System.out.println(arrayListTarefas.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceListaTarefa app = new InterfaceListaTarefa();
            app.setVisible(true);
        });
    }
}
