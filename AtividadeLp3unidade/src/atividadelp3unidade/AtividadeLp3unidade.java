/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividadelp3unidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Thamires
 */
public class AtividadeLp3unidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Funcionario func1 = new  Funcionario();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Insira o nome do funcionário:");
        func1.setNome(teclado.next());
        
       System.out.println("Informe a data de admissão do funcionário (Por favor, insira no formato dd/MM/yyyy):");
        String aux = teclado.next();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try { 
            Date data = df.parse(aux); // Converte o texto em formato de data

             // Verifica se a data fornecida estará por vir
            Date hoje = new Date();
            if (data.after(hoje)) {
                System.out.println("O funcionário ainda será admitido. Por favor, aguarde até que isso aconteça, para que seja possível calcular o valor do salário!");
                System.exit(0); // Interrompe o programa
            } else {
                func1.setDataAdmissao(data);
                System.out.println("");
            }
        } catch (ParseException ex) {
            System.out.println("Data Inválida. Por favor, insira corretamente");
            System.exit(0); // Interrompe o programa
        }
        
        System.out.print("Informe o valor da hora trabalhada: ");
        func1.setValorHora(teclado.nextFloat());

        System.out.println("Informe as horas trabalhadas: ");
        func1.setHorasTrabalhadas(teclado.nextFloat());
        
       // Exibe os resultados
        System.out.println("\nNome do funcionário: " + func1.getNome());
        System.out.println("Tempo de empresa: " + func1.calcularTempoEmpresa()+ " anos");
        System.out.println("Salário a receber: R$ " + String.format("%.2f", func1.calcularSalario()));

    }
    
}