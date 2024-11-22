/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividadelp3unidade;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Thamires
 */
public class Funcionario {
    
private String nome;
    private Date dataAdmissao;
    private float valorHora, horasTrabalhadas;

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public long calcularTempoEmpresa() {
        
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataAdmissaoCal = Calendar.getInstance();
        dataAdmissaoCal.setTime(this.dataAdmissao);

        long anoAtual = dataAtual.get(Calendar.YEAR);
        long anoAdmissao = dataAdmissaoCal.get(Calendar.YEAR);

        long anosTrabalhados = anoAtual - anoAdmissao;

        // Verifica se a data de admissão ainda não passou deste ano (mês/dia)
        if (dataAtual.get(Calendar.DAY_OF_YEAR) < dataAdmissaoCal.get(Calendar.DAY_OF_YEAR)) {
            anosTrabalhados--;
        }

        return anosTrabalhados;
    }

    public float calcularSalario() {

        long diferencaMillis = new Date().getTime() - dataAdmissao.getTime();
        long anosTrabalhados = TimeUnit.MILLISECONDS.toDays(diferencaMillis) / 365;

        float salarioBase = valorHora * horasTrabalhadas;
        if (anosTrabalhados >= 5) {
            return salarioBase * 1.05f; // Acrescenta 5%
        } else if (anosTrabalhados >= 10) {
            return salarioBase * 1.10f; // Acrescenta 10%
        } else {
            return salarioBase;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

}

