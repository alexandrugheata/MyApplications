import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    
    JFrame frame;
    JTextField textField, textCopy;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;// for numbers and operations without delete, clear

    Font myFont = new Font("Ink Free",Font.BOLD, 30);

    double num1=0, num2=0, result=0;
    char operator;//hold the muliply, sub, add, div



    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close whenever the program
        frame.setSize(420, 550);
        frame.setLayout(null);//no layout manager

        //settings for textField
        textField = new JTextField();
        textField.setBounds(50, 50, 300, 50);//bound for text
        textField.setFont(myFont);
        textField.setEditable(false);//cant update/write in the textfield

        //settings for textCopy
        textCopy = new JTextField();
        textCopy.setBounds(200, 10, 150, 30);//bound for text
        textCopy.setFont(myFont);
        textCopy.setEditable(false);//cant update/write in the textfield

        //buttons related to functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
      
        //array of Jbutons  
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
             functionButtons[i].addActionListener(this);
             functionButtons[i].setFont(myFont);
             functionButtons[i].setFocusable(false);//annoying outliner for the button,turn off
        }

        for (int i = 0; i < 10; i++) {
             numberButtons[i] = new JButton(String.valueOf(i));//instantiate number buttons
             numberButtons[i].addActionListener(this);
             numberButtons[i].setFont(myFont);
             numberButtons[i].setFocusable(false);
            
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100 , 300,300);
        panel.setLayout(new GridLayout(4, 4, 10, 10 ));
        //panel.setBackground(Color.GRAY);//for delimitation

        //first row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        //second row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        //third row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton); 





        
       //add all to frame
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton); 
        frame.add(textCopy);
        frame.add(textField);//add texfield to frame
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        
     Calculator calc = new Calculator();



    }


    @Override
    public void actionPerformed(ActionEvent e) {
            //functionality for the numbers
           
            for (int i = 0; i < 10; i++) {
                if(e.getSource() == numberButtons[i]){

                    textField.setText(textField.getText().concat(String.valueOf(i)));//show the pressed numbers
                    textCopy.setText(textField.getText().concat(String.valueOf(i)));//show the pressed numbers


                }
            }
            //decimal character
            if(e.getSource() == decButton){
                textField.setText(textField.getText().concat("."));
                decButton.setEnabled(false);
            }

            //add button
            if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textCopy.setText(textCopy.getText().concat("+"));
                textField.setText("");
            }
            //sub button
            if(e.getSource() == subButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            //multiply button
            if(e.getSource() == mulButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            //divide button
            if(e.getSource() == divButton){
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            //equal button
            if(e.getSource() == equButton) {    
                num2 = Double.parseDouble(textField.getText());

                switch(operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }

                textField.setText(String.valueOf(result));//updating textfield
                num1 = result;//if we want to continue with the same number
            }

            //clear button
            if(e.getSource() == clrButton){
                textField.setText("");  
                decButton.setEnabled(true);
            }
            //delete button
            if(e.getSource() == delButton){
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length()-1; i++) {
                    textField.setText(textField.getText()+string.charAt(i));//add every number before the last one
                    //deleting from the last number
                }
                decButton.setEnabled(true);


                
            }





    }

}