package tictactoe.views.game;

import javax.swing.*;
import java.awt.*;

public class SingleSquareGame extends JButton {
    private static final int empty = 0;
    private static final int playerX = 1;
    private static final int playerY = 2;
    private int state;
    public SingleSquareGame(){
        state = empty;
        Dimension dimension = new Dimension(50,50);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
    }

    public int getState(){
        return state;
    }

    public void setState(int state){
        if (canChangeState()){
            this.state = state;
        }
    }

    private boolean canChangeState(){
        return state == empty;
    }
}