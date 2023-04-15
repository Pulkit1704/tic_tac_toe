import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class app {

    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    public static JButton[] playfield = new JButton[9];
    
    public static JLabel player_information = new JLabel("X's turn");

    public static void new_app(){
        
        ActionListener action  = new actions();

        frame.setLayout(new GridLayout(3,3));
        frame.setTitle("Playfield");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        panel.setLayout(new GridLayout(4,3));
        panel.setSize(100, 100);
        panel.removeAll();

        for(int i = 0; i < 9; i ++){

            playfield[i] = new JButton();
            playfield[i].addActionListener(action);

            panel.add(playfield[i]);

        }
        panel.add(player_information);
        panel.add(new JLabel());
        frame.add(panel);
        frame.setVisible(true);
        frame.setEnabled(true); 
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args){

        EventQueue.invokeLater(() ->{

            // a master frame controls the game progression. 
            JFrame control_frame = new JFrame("tic tac toe"); 
            control_frame.setLayout(new FlowLayout());
            control_frame.setSize(400, 200); 
            control_frame.setLocationRelativeTo(null);

            JPanel control_panel = new JPanel(); 
            control_panel.setLayout(new FlowLayout());

            JLabel welcome = new JLabel("welcome to tic tac toe: ");

            JButton new_game = new JButton("new game"); 
            new_game.addActionListener(new ActionListener(){
                
                public void actionPerformed(ActionEvent e){

                    new_app(); 

                }
            }); 

            control_panel.add(welcome); 
            control_panel.add(new_game);  
            control_frame.add(control_panel); 
            control_frame.setVisible(true);
            control_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        });
    }

     
    public void gameover(String winner){

        frame.setEnabled(false);

        JFrame message_frame = new JFrame("game over");
        message_frame.setLayout(new FlowLayout());
        message_frame.setLocationRelativeTo(frame);
        message_frame.setSize(300, 100);

        JPanel panel = new JPanel();
        panel.setLayout( new FlowLayout());

        JLabel label = new JLabel("game over: ");
        String winner_message = String.format("%s wins", winner); 

        JLabel winner_label = new JLabel(winner_message); 

        panel.add(label);
        panel.add(winner_label); 
        panel.revalidate();
        message_frame.add(panel);
        message_frame.setVisible(true);
        message_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}