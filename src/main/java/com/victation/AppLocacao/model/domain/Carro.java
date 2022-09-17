package com.victation.AppLocacao.model.domain;

import com.victation.AppLocacao.model.domain.exeptions.QuantidadePortasCarroInvalidoException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carro extends Automovel{

    public Integer id;
    public int portas;



    public Carro(Integer id, String marca, String modelo, int portas) {
        this.id = id;
        super.marca =marca;
        super.modelo = modelo;
        this.portas = portas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public float calcularValorLocacao() throws QuantidadePortasCarroInvalidoException {
        if(portas >4){
            throw new QuantidadePortasCarroInvalidoException("portas: " +portas+ " Maior que 4, Quantidade por portas invalida");
        }

        return  getPortas() > 2 ?  valor * 3.5f  :  valor * 2.5f;
    };

    @Override
    public String toString() {
        return "\nCarro{" +
                "portas=" + portas +
                ";" + super.toString() +
                '}';
    }

    @Override
    public void impressao() {
        System.out.println("#Carro");
        System.out.println(this);
    }
}
