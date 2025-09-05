package Calculatoor;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class Calculator extends JFrame implements ActionListener{
        double number, answer;
        int calculation;
        private final JButton[] numButtons;
        private final JButton[] opButtons;
        private final JButton cButton;
        private final JButton equalButton;
        private final TextArea textArea;
        public Calculator(){
            JPanel p = new JPanel();
            textArea = new TextArea("");
            String[] num = {"1","2","3","4","5","6","7","8","9","0"};
            numButtons = new JButton[10];
            String[] op = {"+","-","/","*"};
            opButtons = new JButton[4];
            cButton = new JButton("C");
            equalButton = new JButton("=");

            add(textArea, BorderLayout.NORTH);
            add(p);
            for(int i = 0; i < 10; i++){
                numButtons[i] = new JButton(num[i]);
                p.add(numButtons[i], BorderLayout.CENTER);
                numButtons[i].addActionListener(this);
            }
            for(int i = 0; i < 4; i++){
                opButtons[i] = new JButton(op[i]);
                p.add(opButtons[i], BorderLayout.CENTER);
                opButtons[i].addActionListener(this);
            }
            p.add(equalButton);
            equalButton.addActionListener(this);
            p.add(cButton);
            cButton.addActionListener(this);

            setTitle("Calculator");
            setSize(250,400);
            p.setLayout(new GridLayout(4,4));
            setLocationRelativeTo(this);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }

        public static void main(String[] args){
            new Calculator();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < 10; i++) {
                if (e.getSource() == numButtons[i]) {
                    textArea.setText(textArea.getText() + numButtons[i].getText());
                }
            }
            for(int i = 0; i < 4; i++) {
                if (e.getSource() == opButtons[i]) {
                    if (textArea.getText().contains(opButtons[i].getText())){
                        textArea.setText(textArea.getText());
                    }else {
                        number = Double.parseDouble(textArea.getText());
                        textArea.setText(textArea.getText() + opButtons[i].getText());
                        calculation = i;
                    }
                }
            }
            if (e.getSource() == cButton){
                textArea.setText("");
            }
            else if (e.getSource() == equalButton){
                switch (calculation) {
                    case 1 -> {
                        answer = number + Double.parseDouble(textArea.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textArea.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textArea.setText(Double.toString(answer));
                        }
                    }
                    case 2 -> {
                        answer = number - Double.parseDouble(textArea.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textArea.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textArea.setText(Double.toString(answer));
                        }
                    }
                    case 3 -> {
                        answer = number * Double.parseDouble(textArea.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textArea.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textArea.setText(Double.toString(answer));
                        }
                        textArea.setText("");
                    }
                    case 4 -> {
                        answer = number / Double.parseDouble(textArea.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textArea.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textArea.setText(Double.toString(answer));
                        }
                    }
                }
            }
        }
    }