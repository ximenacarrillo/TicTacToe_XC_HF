package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.models.Welcome;
import tictactoe.views.Window;
import tictactoe.views.game.GamePanel;
import tictactoe.views.game.GameWindow;
import tictactoe.views.WelcomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class WelcomeController {
    private final Welcome welcome;//Model
    private final WelcomePanel view;
    private final ProgramController programController;


    public WelcomeController(Welcome welcome, WelcomePanel view, ProgramController programController){

        this.welcome = welcome;
        this.view = view;
        this.programController = programController;


        initializeView(view);

        welcome.addListener(view);

        view.addExitListener((ActionEvent e) ->onExitClicked());
        view.addPlayListener((ActionEvent e) ->onPlayClicked());
        view.addHistoryListener((new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                HistoryPanel historyPanel = new HistoryPanel();
                HistoryWindow historyWindow = new HistoryWindow("History", historyPanel);
                HistoryController controller = new HistoryController(historyWindow, historyPanel.getHistoryInformation());
                historyWindow.setVisible(true);
            }
        }));
    }


    private void onPlayClicked() {
        if(playersNamesAreValid()){
            programController.closeWelcomeWindow();
            ProgramController.playGame(view.getBoardSize(),view.getPlayer1JTextField(), view.getPlayer2JTextField());
        }else{
            JOptionPane.showMessageDialog( view.getParent(),"Error: Players names are invalid","Tic Tac Toe Game",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean playersNamesAreValid() {
        return view.getPlayer1JTextField().length() >=1
                && view.getPlayer2JTextField().length() >=1
                && !view.getPlayer2JTextField().equals(view.getPlayer1JTextField());
    }

    private void onExitClicked() {
        if (JOptionPane.showConfirmDialog( view.getParent(),"Please, confirm if you want to Exit","Tic Tac Toe Game",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }

    private void initializeView(WelcomePanel view) {
        view.player1NameChanged("");
        view.player2NameChanged("");
    }
}
