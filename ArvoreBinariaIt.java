package org.siedrig;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaIt {

    void emOrdem(No raiz, List<String> lista) {
    if (raiz == null) return;
    emOrdem(raiz.esquerda, lista);
    lista.add(raiz.nome);
    emOrdem(raiz.direita, lista);
    }

    public static class No {

        public String nome;
        public No esquerda, direita;

        public No(String nome) {
            this.nome = nome;
            esquerda = direita = null;
        }
    }

    public No raiz;

    int tamanho = 0;

    public void Cadastrar(String nome) {
        No novo = new No(nome);

        if (raiz == null) {
            raiz = novo;
            return;
        }
        No atual = raiz;
        No pai = null;

        while (atual != null) {
            pai = atual;

            if (nome.compareToIgnoreCase(atual.nome) < 0) {
                atual = atual.esquerda;
            } else if (nome.compareToIgnoreCase(atual.nome) > 0) {
                atual = atual.direita;
            }
            tamanho++;
        }

        if (pai != null) {
            if (nome.compareToIgnoreCase(pai.nome) < 0) {
                pai.esquerda = novo;
            } else {
                pai.direita = novo;
            }
        }

    }

    public boolean Listar(String nome) {
        No atual = raiz;
        while (atual != null) {
            if (nome.equalsIgnoreCase(atual.nome)) {
                return true;
            } else if (nome.compareToIgnoreCase(atual.nome) < 0) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        return false;
    }

    public void emOrdem() {
        No[] pilha = new No[tamanho];
        int topo = -1;
        No atual = raiz;
        while (atual != null || topo != -1) {
            while (atual != null) {
                pilha[++topo] = atual;
                atual = atual.esquerda;
            }
            atual = pilha[topo--];
            System.out.println(atual.nome);
            atual = atual.direita;
        }
    }

    public List<String> emOrdemRecursivo() {
        List<String> resultado = new ArrayList<>();
        emOrdemRecursivo(raiz, resultado);
        return resultado;
    }

    private void emOrdemRecursivo(No atual, List<String> resultado) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda, resultado);
            resultado.add(atual.nome); // supondo que o nó tem um campo 'nome'
            emOrdemRecursivo(atual.direita, resultado);
        }
    }

}
