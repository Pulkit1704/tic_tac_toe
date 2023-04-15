import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class actions extends app implements ActionListener {

    private boolean playerstate = true;

    private int turn_counter = 0;

    private String winner = "Nobody";

    public void actionPerformed(ActionEvent actionEvent) {

        for(JButton button : playfield){
            if(actionEvent.getSource() == button){
                turn(button, playerstate); 
                break; 
            }
        }

        if(fieldcheck(playerstate)){
            if(playerstate){
                winner = "X"; 
            }else{
                winner = "O"; 
            }
            gameover(winner);
        }

        if(turn_counter == playfield.length){
            gameover(winner); 
        }

        playerstate = !playerstate; 

    }

    private void turn(JButton button, boolean playerturn){

        if(playerturn) {
            button.setText("X"); 
            player_information.setText("O's turn");

        }else{
            button.setText("O");
            player_information.setText("X's turn");

        }

        button.setEnabled(false);

        turn_counter++;
    }

    private boolean fieldcheck(boolean playerstate){
        
        String[] values = fieldvalues(playfield); 

        if(playerstate){
            return rowcheck("X", values) || columncheck("X", values) || diagonalcheck("X", values);
        }else{
            return rowcheck("O", values) || columncheck("O", values) || diagonalcheck("O", values);
        }
       
    }

    private String[] fieldvalues(JButton[] playfield){

        String[] values = new String[playfield.length]; 
        for(int i = 0; i < values.length; i++){
            values[i] = playfield[i].getText(); 
        }
        return values; 

    }

    private boolean rowcheck(String check, String[] values){
        if(values[0].equals(check) && values[1].equals(check) && values[2].equals(check)){
            return true; 
        }
        if(values[3].equals(check) && values[4].equals(check) && values[5].equals(check)){
            return true; 
        }

        if(values[6].equals(check) && values[7].equals(check) && values[8].equals(check)){
            return true; 
        }
        
        return false; 

    }

    private boolean columncheck(String check, String[] values ){
        if(values[0].equals(check) && values[3].equals(check) && values[6].equals(check)){
            return true; 

        }
        if(values[1].equals(check) && values[4].equals(check) && values[7].equals(check)){
            return true; 

        }
        if(values[2].equals(check) && values[5].equals(check) && values[8].equals(check)){
            return true; 

        }

        return false; 
    }

    private boolean diagonalcheck(String check, String[] values ){
        if(values[0].equals(check) && values[4].equals(check) && values[8].equals(check)){
            return true; 

        }
        if(values[2].equals(check) && values[4].equals(check) && values[6].equals(check)){
            return true; 

        }

        return false; 

    }
}
