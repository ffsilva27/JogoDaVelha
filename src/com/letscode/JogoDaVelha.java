package com.letscode;

import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        char[][] tabuleiro = {
                {'_' , '|' , '_' , '|' , '_'},
                {'_' , '|' , '_' , '|' , '_'},
                {'_' , '|' , '_' , '|' , '_'}
        };

        Scanner sc = new Scanner(System.in);
        boolean acabou = checkVitoria(tabuleiro);
        printTabuleiro(tabuleiro);
        while (!acabou){
            System.out.print("Informe uma posição de 1 a 9 para sua jogada: ");
            int jogada = Integer.parseInt(sc.nextLine());
            boolean possibilidade = checarPosicao(jogada,tabuleiro);
            acabou = checkVitoria(tabuleiro);
            if(!possibilidade && !acabou) {
                while (!possibilidade){
                    System.out.print("Essa posição já foi escolhida, favor informar outra: ");
                    jogada = Integer.parseInt(sc.nextLine());
                    possibilidade = checarPosicao(jogada,tabuleiro);
                }
                System.out.println("-------------------------------");
                atualizarTabuleiro(jogada, 1, tabuleiro);
                System.out.println("-------------------------------");
                acabou = checkVitoria(tabuleiro);
            }else{
                System.out.println("-------------------------------");
                atualizarTabuleiro(jogada, 1, tabuleiro);
                System.out.println("-------------------------------");
                acabou = checkVitoria(tabuleiro);
            }
            if(!acabou){
                jogadaPC(tabuleiro);
                acabou = checkVitoria(tabuleiro);
                System.out.println("-------------------------------");
            }
        }
    }
    public static void printTabuleiro(char[][] tabuleiro) {
        for(char[] row: tabuleiro ){
            for(char collumn: row){
                System.out.print(collumn);
            }
            System.out.println();
        }
    }

    public static void jogadaPC(char[][] tabuleiro) {
        Random random = new Random();
        int movimento = random.nextInt(9)+1;
        boolean check = checarPosicao(movimento,tabuleiro);
        if(check){
            atualizarTabuleiro(movimento,2,tabuleiro);
        }else{
            jogadaPC(tabuleiro);
        }
    }


    public static boolean checkVitoria(char[][] tabuleiro){
        if(tabuleiro[0][0] == tabuleiro[0][2] && tabuleiro[0][2] == tabuleiro[0][4]){
            if(tabuleiro[0][0]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[0][0]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[1][0] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[1][4]){
            if(tabuleiro[1][0]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[1][0]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[2][0] == tabuleiro[2][2] && tabuleiro[2][2] == tabuleiro[2][4]){
            if(tabuleiro[2][0]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[2][0]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[0][0] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][4]){
            if(tabuleiro[0][0]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[0][0]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0]){
            if(tabuleiro[0][0]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[0][0]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2]){
            if(tabuleiro[0][2]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[0][2]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[0][4] == tabuleiro[1][4] && tabuleiro[1][4] == tabuleiro[2][4]){
            if(tabuleiro[0][4]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[0][4]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        if(tabuleiro[0][4] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][0]){
            if(tabuleiro[0][4]=='x'){
                System.out.println("Jogador 1 Venceu!");
                return true;
            }else if (tabuleiro[0][4]=='o'){
                System.out.println("PC Venceu!");
                return true;
            }
        }
        for (char[] linha : tabuleiro) {
            for (int j = 0; j < linha.length; j += 2) {
                if (linha[j] == '_') {
                    return false;
                }
            }
        }
        System.out.println("Não houve vencedor!");
        return true;
    }

    public static boolean checarPosicao(int posicao, char[][] tabuleiro){
        boolean result = false;
        switch (posicao){
            case 1:
                if(tabuleiro[0][0]=='_'){
                    result = true;
                }
                break;
            case 2:
                if(tabuleiro[0][2]=='_'){
                    result = true;
                }
                break;
            case 3:
                if(tabuleiro[0][4]=='_'){
                    result = true;
                }
                break;
            case 4:
                if(tabuleiro[1][0]=='_'){
                    result = true;
                }
                break;
            case 5:
                if(tabuleiro[1][2]=='_'){
                    result = true;
                }
                break;
            case 6:
                if(tabuleiro[1][4]=='_'){
                    result = true;
                }
                break;
            case 7:
                if(tabuleiro[2][0]=='_'){
                    result = true;
                }
                break;
            case 8:
                if(tabuleiro[2][2]=='_'){
                    result = true;
                }
                break;
            case 9:
                if(tabuleiro[2][4]=='_'){
                    result = true;
                }
                break;
            default:
                break;
        }
        return result;
    }

    //Jogador 1 = 'x' | Jogador 2 = 'o'
    public static void atualizarTabuleiro(int posicao, int jogador, char[][] tabuleiro){
        char character;
        if(jogador==1) {
            character = 'x';
        }else {
            character = 'o';
        }
        switch (posicao){
            case 1:
                tabuleiro[0][0] = character;
                printTabuleiro(tabuleiro);
                break;
            case 2:
                tabuleiro[0][2] = character;
                printTabuleiro(tabuleiro);
                break;
            case 3:
                tabuleiro[0][4] = character;
                printTabuleiro(tabuleiro);
                break;
            case 4:
                tabuleiro[1][0] = character;
                printTabuleiro(tabuleiro);
                break;
            case 5:
                tabuleiro[1][2] = character;
                printTabuleiro(tabuleiro);
                break;
            case 6:
                tabuleiro[1][4] = character;
                printTabuleiro(tabuleiro);
                break;
            case 7:
                tabuleiro[2][0] = character;
                printTabuleiro(tabuleiro);
                break;
            case 8:
                tabuleiro[2][2] = character;
                printTabuleiro(tabuleiro);
                break;
            case 9:
                tabuleiro[2][4] = character;
                printTabuleiro(tabuleiro);
                break;
            default:
                break;
        }
    }
}

