/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.aluno.ifnmg.raa16.myplayer;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robert
 */
public class MyPlayer extends AbstractPlayer {

    public boolean isFirst = true;
    public boolean isSecond = false;
    public int count;

    @Override
    public String getDeveloperName() {
        return "Robert Aquino";
    }

    @Override
    public Move makeMyMove(Move opponentPreviousMove) {

        if (isFirst) {
            isFirst = false;
            isSecond = true;
            return Move.PAPER;
        }
        if (isSecond) {
            isSecond = false;
            return Move.SCISSORS;
        }
        if(count < 10) {
            try {
            int randomChoice = SecureRandom.getInstanceStrong().nextInt(3);
            switch (randomChoice) {
                case 0:
                    return Move.PAPER;
                case 1:
                    return Move.SCISSORS;
                case 2:
                    return Move.ROCK;
                default:
                    return Move.SCISSORS; // Fallback, embora não necessário
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
            return Move.PAPER; // Retorno padrão em caso de erro
        }
           
        }
        return Move.SCISSORS;
    }
}
