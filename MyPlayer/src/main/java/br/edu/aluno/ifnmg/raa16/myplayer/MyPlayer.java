/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.aluno.ifnmg.raa16.myplayer;
import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;
/**
 *
 * @author robert
 */
public class MyPlayer extends AbstractPlayer{

    @Override
    public String getDeveloperName() {
        return "Robert Aquino";
    }

    @Override
    public Move makeMyMove(Move opponentPreviousMove) {
        return opponentPreviousMove;
    }
}
