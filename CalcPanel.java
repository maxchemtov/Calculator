import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.*;
public class CalcPanel extends JPanel
{
    private JLabel labelAnswer = new JLabel();//Where the answer is displayed
    private JLabel labelInput = new JLabel();//Where the input is displayed
    private JButton button0 = new JButton("0");//      ----
    private JButton button1 = new JButton("1");//           \
    private JButton button2 = new JButton("2");//            \
    private JButton button3 = new JButton("3");//            |
    private JButton button4 = new JButton("4");//            |
    private JButton button5 = new JButton("5");//             > Buttons for entering the numbers
    private JButton button6 = new JButton("6");//            |
    private JButton button7 = new JButton("7");//            |
    private JButton button8 = new JButton("8");//            |
    private JButton button9 = new JButton("9");//           /
    private JButton buttonPoint = new JButton(".");//  ----
    private JButton buttonDelete = new JButton("\u2190");//Delete button (backspace)
    private JButton buttonPlus = new JButton("+");//Addition button
    private JButton buttonMinus = new JButton("-");//Subtraction button
    private JButton buttonTimes = new JButton("\u00D7");//Multiplication button
    private JButton buttonDivide = new JButton("\u00F7");//Division button
    private JButton buttonEquals = new JButton("=");//Equals button
    private JButton buttonClear = new JButton("C");//Clear (answer and input) button
    private GridBagLayout layout = new GridBagLayout();//Layout
    private GridBagConstraints constraints = new GridBagConstraints();//Settings for the layout
    
    public CalcPanel()
    //Called when a calculator is opened. Sets up the buttons and labels with their placement (layout), mnemonics, and listeners
    {
        setLayout(layout);
        ButtonHandler listener = new ButtonHandler();
        KeyHandler keys = new KeyHandler();
        addKeyListener(keys);
        
        constraints = new GridBagConstraints(0, 0, 5, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(labelAnswer, constraints);
        add(labelAnswer);
        labelAnswer.setFocusable(false);
        
        constraints = new GridBagConstraints(0, 2, 5, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(labelInput, constraints);
        add(labelInput);
        labelInput.setFocusable(false);
        
        constraints = new GridBagConstraints(0, 6, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button0, constraints);
        add(button0);
        button0.setMnemonic(KeyEvent.VK_NUMPAD0);
        button0.addActionListener(listener);
        button0.setFocusable(false);
        
        constraints = new GridBagConstraints(0, 5, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button1, constraints);
        add(button1);
        button1.setMnemonic(KeyEvent.VK_NUMPAD1);
        button1.addActionListener(listener);
        button1.setFocusable(false);
        
        constraints = new GridBagConstraints(1, 5, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button2, constraints);
        add(button2);
        button2.setMnemonic(KeyEvent.VK_NUMPAD2);
        button2.addActionListener(listener);
        button2.setFocusable(false);
        
        constraints = new GridBagConstraints(2, 5, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button3, constraints);
        add(button3);
        button3.setMnemonic(KeyEvent.VK_NUMPAD3);
        button3.addActionListener(listener);
        button3.setFocusable(false);
        
        constraints = new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button4, constraints);
        add(button4);
        button4.setMnemonic(KeyEvent.VK_NUMPAD4);
        button4.addActionListener(listener);
        button4.setFocusable(false);
        
        constraints = new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button5, constraints);
        add(button5);
        button5.setMnemonic(KeyEvent.VK_NUMPAD5);
        button5.addActionListener(listener);
        button5.setFocusable(false);
        
        constraints = new GridBagConstraints(2, 4, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button6, constraints);
        add(button6);
        button6.setMnemonic(KeyEvent.VK_NUMPAD6);
        button6.addActionListener(listener);
        button6.setFocusable(false);
        
        constraints = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button7, constraints);
        add(button7);
        button7.setMnemonic(KeyEvent.VK_NUMPAD7);
        button7.addActionListener(listener);
        button7.setFocusable(false);
        
        constraints = new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button8, constraints);
        add(button8);
        button8.setMnemonic(KeyEvent.VK_NUMPAD8);
        button8.addActionListener(listener);
        button8.setFocusable(false);
        
        constraints = new GridBagConstraints(2, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(button9, constraints);
        add(button9);
        button9.setMnemonic(KeyEvent.VK_NUMPAD9);
        button9.addActionListener(listener);
        button9.setFocusable(false);
        
        constraints = new GridBagConstraints(1, 6, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonPoint, constraints);
        add(buttonPoint);
        buttonPoint.setMnemonic(KeyEvent.VK_DECIMAL);
        buttonPoint.addActionListener(listener);
        buttonPoint.setFocusable(false);
        
        constraints = new GridBagConstraints(2, 6, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonDelete, constraints);
        add(buttonDelete);
        buttonDelete.setMnemonic(KeyEvent.VK_BACK_SPACE);
        buttonDelete.addActionListener(listener);
        buttonDelete.setFocusable(false);
        
        constraints = new GridBagConstraints(3, 6, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonPlus, constraints);
        add(buttonPlus);
        buttonPlus.setMnemonic(KeyEvent.VK_ADD);
        buttonPlus.addActionListener(listener);
        buttonPlus.setFocusable(false);
        
        constraints = new GridBagConstraints(3, 5, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonMinus, constraints);
        add(buttonMinus);
        buttonMinus.setMnemonic(KeyEvent.VK_SUBTRACT);
        buttonMinus.addActionListener(listener);
        buttonMinus.setFocusable(false);
        
        constraints = new GridBagConstraints(3, 4, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonTimes, constraints);
        add(buttonTimes);
        buttonTimes.setMnemonic(KeyEvent.VK_MULTIPLY);
        buttonTimes.addActionListener(listener);
        buttonTimes.setFocusable(false);
        
        constraints = new GridBagConstraints(3, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonDivide, constraints);
        add(buttonDivide);
        buttonDivide.setMnemonic(KeyEvent.VK_DIVIDE);
        buttonDivide.addActionListener(listener);
        buttonDivide.setFocusable(false);
        
        constraints = new GridBagConstraints(4, 5, 1, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonEquals, constraints);
        add(buttonEquals);
        buttonEquals.setMnemonic(KeyEvent.VK_ENTER);
        buttonEquals.addActionListener(listener);
        buttonEquals.setFocusable(false);
        
        constraints = new GridBagConstraints(4, 3, 1, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        layout.setConstraints(buttonClear, constraints);
        add(buttonClear);
        buttonClear.setMnemonic(KeyEvent.VK_DELETE);
        buttonClear.addActionListener(listener);
        buttonClear.setFocusable(false);
        
        setFocusable(true);
        requestFocus();
    }
    private class KeyHandler implements KeyListener
    {
        public void keyPressed(KeyEvent event)
        //Called when a key is pressed on the keyboard. Activates the buttons depending on what key is pressed
        {
            switch(event.getKeyCode())
            {
                case KeyEvent.VK_NUMPAD0:
                    button0.doClick();
                    break;
                case KeyEvent.VK_NUMPAD1:
                    button1.doClick();
                    break;
                case KeyEvent.VK_NUMPAD2:
                    button2.doClick();
                    break;
                case KeyEvent.VK_NUMPAD3:
                    button3.doClick();
                    break;
                case KeyEvent.VK_NUMPAD4:
                    button4.doClick();
                    break;
                case KeyEvent.VK_NUMPAD5:
                    button5.doClick();
                    break;
                case KeyEvent.VK_NUMPAD6:
                    button6.doClick();
                    break;
                case KeyEvent.VK_NUMPAD7:
                    button7.doClick();
                    break;
                case KeyEvent.VK_NUMPAD8:
                    button8.doClick();
                    break;
                case KeyEvent.VK_NUMPAD9:
                    button9.doClick();
                    break;
                case KeyEvent.VK_DECIMAL:
                    buttonPoint.doClick();
                    break;
                case KeyEvent.VK_ADD:
                    buttonPlus.doClick();
                    break;
                case KeyEvent.VK_SUBTRACT:
                    buttonMinus.doClick();
                    break;
                case KeyEvent.VK_MULTIPLY:
                    buttonTimes.doClick();
                    break;
                case KeyEvent.VK_DIVIDE:
                    buttonDivide.doClick();
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    buttonDelete.doClick();
                    break;
                case KeyEvent.VK_DELETE:
                    buttonClear.doClick();
                    break;
                case KeyEvent.VK_ENTER:
                    buttonEquals.doClick();
            }
        }
        public void keyReleased(KeyEvent event)
        //Useless method
        {
           
        }
        public void keyTyped(KeyEvent event)
        //Useless method
        {
            
        }
    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        //Called when a button is clicked. Either adds a number or an operator to the input label, or it deletes the last character or the entire entry
        //The equals button uses a ScriptEngine to interpret the input.
        {
            String oldInput = labelInput.getText();
            if(event.getSource() == button0)
            {
                labelInput.setText(oldInput + "0");
            }
            else if(event.getSource() == button1)
            {
                labelInput.setText(oldInput + "1");
            }
            else if(event.getSource() == button2)
            {
                labelInput.setText(oldInput + "2");
            }
            else if(event.getSource() == button3)
            {
                labelInput.setText(oldInput + "3");
            }
            else if(event.getSource() == button4)
            {
                labelInput.setText(oldInput + "4");
            }
            else if(event.getSource() == button5)
            {
                labelInput.setText(oldInput + "5");
            }
            else if(event.getSource() == button6)
            {
                labelInput.setText(oldInput + "6");
            }
            else if(event.getSource() == button7)
            {
                labelInput.setText(oldInput + "7");
            }
            else if(event.getSource() == button8)
            {
                labelInput.setText(oldInput + "8");
            }
            else if(event.getSource() == button9)
            {
                labelInput.setText(oldInput + "9");
            }
            else if(event.getSource() == buttonPoint)
            {
                boolean valid = true;
                for(int x = oldInput.length() - 1; x >= 0; x --)
                {
                    if(oldInput.charAt(x) == ' ')
                    {
                        break;
                    }
                    else if(oldInput.charAt(x) == '.')
                    {
                        valid = false;
                    }
                }
                if(valid)
                {
                    labelInput.setText(oldInput + ".");
                }
            }
            else if(event.getSource() == buttonPlus)
            {
                if(oldInput.length() != 0 && oldInput.charAt(oldInput.length() - 1) != ' ' && oldInput.charAt(oldInput.length() - 1) != '-')
                {
                    labelInput.setText(oldInput + " + ");
                }
            }
            else if(event.getSource() == buttonMinus)
            {
                if(oldInput.length() == 0 || oldInput.charAt(oldInput.length() - 1) == ' ' && oldInput.charAt(oldInput.length() - 1) != '-')
                {
                    labelInput.setText(oldInput + "-");
                }
                else if(oldInput.charAt(oldInput.length() - 1) != '-')
                {
                    labelInput.setText(oldInput + " - ");
                }
            }
            else if(event.getSource() == buttonTimes)
            {
                if(oldInput.length() != 0 && oldInput.charAt(oldInput.length() - 1) != ' ' && oldInput.charAt(oldInput.length() - 1) != '-')
                {
                    labelInput.setText(oldInput + " * ");
                }
            }
            else if(event.getSource() == buttonDivide)
            {
                if(oldInput.length() != 0 && oldInput.charAt(oldInput.length() - 1) != ' ' && oldInput.charAt(oldInput.length() - 1) != '-')
                {
                    labelInput.setText(oldInput + " / ");
                }
            }
            else if(event.getSource() == buttonDelete)
            {
                if(oldInput.length() != 0)
                {
                    if(oldInput.charAt(oldInput.length() - 1) == ' ')
                    {
                        labelInput.setText(oldInput.substring(0, oldInput.length() - 3));
                    }
                    else
                    {
                        labelInput.setText(oldInput.substring(0, oldInput.length() - 1));
                    }
                }
            }
            else if(event.getSource() == buttonClear)
            {
                if(oldInput.equals("3507"))
                    System.exit(0);
                labelInput.setText("");
                labelAnswer.setText("");
            }
            else if(event.getSource() == buttonEquals)
            {
                if(! oldInput.equals("") && oldInput.charAt(oldInput.length() - 1) != ' ' && oldInput.charAt(oldInput.length() - 1) != '-' && ! oldInput.equals("."))
                {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
                    try
                    {
                        labelAnswer.setText(engine.eval(oldInput).toString());
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "An error has occurred: you can't have a free-floating decimal point.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
}