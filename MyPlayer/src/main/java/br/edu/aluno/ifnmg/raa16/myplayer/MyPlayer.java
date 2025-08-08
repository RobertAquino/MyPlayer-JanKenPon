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
    public boolean isThird = false;
    public static int count;
    public static int countPosAleatorio = 0;

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
            isThird = true;
            return Move.SCISSORS;
        }
        if(isThird)
        {
            isThird = false;
            return Move.PAPER;
        }
        if (count <= 50 || (count > 100 && count <= 130)) {
            count++;
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
                        return Move.SCISSORS; 
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(MyPlayer.class.getName()).log(Level.SEVERE, null, ex);
                return Move.PAPER;
            }
        }

        if ((count > 50 && count <= 80) || (count > 130 && count <= 150) || (count > 175)) {
            if (countPosAleatorio == 0) {
                count++;
                countPosAleatorio++;
                return Move.SCISSORS;
            }
            if(countPosAleatorio == 1)
            {
                count++;
                countPosAleatorio++;
                return Move.ROCK;
            }
            if(countPosAleatorio == 2)
            {
                count++;
                countPosAleatorio = 0;
                return Move.PAPER;
            }
        }
        
        if((count > 80 && count <=83) || (count > 150 && count <= 153))
        {
           count++;
           return Move.ROCK;
        }
        if((count > 83 && count <=86) || (count > 153 && count <= 156))
        {
            count++;
            return Move.SCISSORS;
        }
        if((count > 86 && count <=90) || (count > 156 && count <= 160))
        {
            count++;
            return Move.PAPER;
        }
        
        if((count > 90 && count <= 100) || (count > 160 && count <= 175))
        {
            if(opponentPreviousMove == Move.PAPER)
            {
                count++;
                return Move.PAPER;
            }
            if(opponentPreviousMove == Move.SCISSORS)
            {
                count++;
                return Move.SCISSORS;
            }
            if(opponentPreviousMove == Move.ROCK)
            {
                count++;
                return Move.SCISSORS;
            }
        }

        return Move.SCISSORS;
    }
}
