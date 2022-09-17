package com.victation.AppLocacao.model.test;


import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.service.CarroService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(4)
public class CarroTeste implements ApplicationRunner  {

    private final CarroService carroService;

    public CarroTeste(CarroService carroService) {
        this.carroService = carroService;
    }
    @Override
    public void run(ApplicationArguments args) {

        String dir = "//home//wid_vlima//dev//git_study//infnet//APP-Locacao//dev//";
        String arq = "carro.txt";
        String fileName = dir + arq;
        System.out.println(fileName);

        try {
            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha = null;
                while ((linha = leitura.readLine()) != null) {
                    String[] campos = linha.split(";");

                    try {
                        Carro carro = new Carro(
                                Integer.valueOf(campos[0]),
                                campos[1],
                                campos[2],
                                Integer.valueOf(campos[3])
                        );
                        carroService.incluir(carro);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(leitura.readLine());
                fileReader.close();
                leitura.close();
            } catch (FileNotFoundException e) {
                System.out.println("[ERRO] O arquivo não existe!!!");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("[ERRO] erro ao fechar o reader");
            }
        } catch (Exception e) {
        } finally {
            System.out.println("terminou");
        }

    }
}
