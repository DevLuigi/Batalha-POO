package com.batalha;

import java.util.Random;

public class Jogador {
    private String nome;
    private String classe;
    private int xp = 10;
    private int hp = 100;
    private boolean envenenado = false;
    private boolean antidoto = false;

    public Jogador() {}

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getXp() {
        return this.xp;
    }

    public int getHp() {
        return this.hp;
    }

    public boolean isEnvenenado() {
        return this.envenenado;
    }

    public boolean temAntidoto() {
        return this.antidoto;
    }

    public void guardarAntidoto() {
        this.antidoto = true;
    }

    public void receberDano(int pontos) {
        this.hp -= pontos;
    }

    public void receberCura(int pontos) {
        this.hp += pontos;
    }

    public void ganharExperiencia(int pontos) {
        this.xp += pontos;
    }

    public void receberAntidoto() {
        this.antidoto = !this.antidoto;
        this.envenenado = !this.envenenado;
    }

    public void atacar(Jogador jogador) {
        if (jogador.getHp() <= 0) {
            return;
        }

        jogador.receberDano(this.xp);
        this.ganharExperiencia(1);
    }

    public void curar(Jogador jogador) {
        if (jogador.getHp() >= 100) {
            return;
        }

        jogador.receberCura(5);

        var random = new Random();
        int probabilidade = random.nextInt(100);
        
        // Menor que 10 porque o range é de 0 a 100
        if (probabilidade >= 10) { 
            return;
        }

        this.guardarAntidoto();
    }

    public void darAntidoto(Jogador jogador) {
        if (!this.temAntidoto() || jogador.temAntidoto()) {
            return;
        }

        jogador.guardarAntidoto();
        this.antidoto = false;
    }
}
