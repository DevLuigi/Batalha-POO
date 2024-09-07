package com.batalha;

import java.util.List;

public class Jogo {
    
    public List<Jogador> getJogadores(){
        var jogador1 = new Jogador("Luigi");
        var jogador2 = new Jogador("Kaio");

        jogador1.setClasse("Mago");
        jogador2.setClasse("Guerreiro");

        return List.of(jogador1, jogador2);
    }

}
