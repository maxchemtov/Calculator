import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CalcFrame extends JFrame
{
    private CalcPanel2 normalPanel = new CalcPanel2();//The contents of the actual calculator;
    private JMenuBar menu = new JMenuBar();//The menu at the top of the frame;
    private JMenu file = new JMenu("File");//The file menu;
    private JMenu mode = new JMenu("Mode");//The mode selection menu;
    private JMenu help = new JMenu("Help");//The help meny;
    private JMenuItem exit = new JMenuItem("Exit");//The not-so-useful exit button;
    private JMenuItem normal = new JMenuItem("Normal");//Normal calculator mode;
    private JMenuItem scientific = new JMenuItem("Scientific");//Scientific calculator mode;
    private JMenuItem instructions = new JMenuItem("Instructions");//Instructions;
    private static int tries = 0;//The number of attempts at quitting with the exit button;
    private static int instances = 0;//The number of instances of the calculator;
    private static CalcFrame[] frames = new CalcFrame[5];//Keeps track of the first 5 calculators so they can be made invisible;

    public CalcFrame()
    //Called when an instance is created
    {
        //Keep track of the first 5 calculators and the # of instances:
        if(instances < 5)
        {
            frames[instances] = this;
        }
        instances ++;
        
        //Set up the menu bar:
        exit.setToolTipText("Close the Calculator");
        file.add(exit);
        normal.setToolTipText("Normal Calculator");
        mode.add(normal);
        scientific.setToolTipText("Scientific Calculator");
        mode.add(scientific);
        scientific.setToolTipText("Instructions");
        help.add(instructions);
        menu.add(file);
        menu.add(mode);
        menu.add(help);
        
        //Add listeners to the menu:
        MenuListener listener = new MenuListener();
        exit.addActionListener(listener);
        normal.addActionListener(listener);
        scientific.addActionListener(listener);
        instructions.addActionListener(listener);
        
        //Add a listener to the actual window:
        CloseListener close = new CloseListener();
        addWindowListener(close);
        
        //Assemble the frame:
        setJMenuBar(menu);
        setLocation((int)(Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 250)), (int)(Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 350)));
        setResizable(false);
        setSize(250, 350);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().add(normalPanel);
        if(instances == 1) JOptionPane.showMessageDialog(null, "Welcome to the calculator that's\nso great you won't want to leave!", "Welcome!", JOptionPane.PLAIN_MESSAGE);
        setVisible(true);
    }
    private static void makeInvisible()
    //Called after exit attempt 3, to make the five calculators that should be on the screen invisible
    {
        for(int x = 0; x < 5; x ++)
        {
            frames[x].setVisible(false);
        }
    }
    private class MenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        //Called whenever the user clicks a button or menu item
        {
            if(event.getSource() == exit)
            //Handles the message/action that is presented when the user tries to exit, depending on the # of tries
            {
                tries ++;
                setVisible(false);
                try
                {
                    Thread.sleep(3000);
                }
                catch(Exception e)
                {
                    
                }
                switch(tries)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null, "There is no escape!");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "If at first you don't succeed, try try again!");
                        new CalcFrame();
                        new CalcFrame();
                        new CalcFrame();
                        new CalcFrame();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Third time's the charm!");
                        makeInvisible();
                        try
                        {
                            Thread.sleep(5000);
                        }
                        catch(Exception e)
                        {
                    
                        }
                        for(int x = 0; x < 70; x ++)
                        {
                            new CalcFrame();
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                        JOptionPane.showMessageDialog(null, "Just give up, this isn't going to work.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Okay, fine. Close the instructions before reaching the end.");
                }
                setVisible(true);
            }
            else if(event.getSource() == normal)
            //Changes the panel to the normal calculator
            {
                getContentPane().removeAll();
                getContentPane().add(normalPanel);
                repaint();
            }
            else if(event.getSource() == scientific)
            //Changes the panel to the scientific calculator
            {
                getContentPane().removeAll();
                getContentPane().add(new JLabel(":("));
                repaint();
                JOptionPane.showMessageDialog(null, "Sorry, this part of the calculator is under construction :(", "Sorry!", JOptionPane.ERROR_MESSAGE);
                actionPerformed(new ActionEvent(normal, ActionEvent.ACTION_LAST + 1, ""));
            }
            else if(event.getSource() == instructions)
            //Displays the instructions
            {
                String[] buttons = {"Next", "Close"};
                String[] closeButton = {"Close"};
                int ans;
                ans = JOptionPane.showOptionDialog(null, "It's a calculator, you shouldn't need instructions.\nClick \"Close\" to return to the calculator or \"Next\" if you really need the help.", "Instructions (1 of 5)", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, null);
                if(ans == 0)
                {
                    ans = JOptionPane.showOptionDialog(null, "Use the buttons to type mathematical phrases.\nThen click the = button to get the result.", "Instructions (2 of 5)", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, null);
                    if(ans == 0)
                    {
                        ans = JOptionPane.showOptionDialog(null, "You can also use the number pad on your keyboard to type things.\nUse ENTER for =, BACKSPACE for \u2190, and DELETE for C.\nIf, for whatever reason, that doesn't work, you can still type while holding ALT.", "Instructions (3 of 5)", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, null);
                        if(ans == 0)
                        {
                            ans = JOptionPane.showOptionDialog(null, "Also, try entering \"1 - 100\".", "Instructions (4 of 5)", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, null);
                            if(ans == 0)
                            {
                                ans = JOptionPane.showOptionDialog(null, "Good luck quitting...", "Instructions (5 of 5)", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, closeButton, null);
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "3507C");
                    }
                }
            }
        }
    }
    private class CloseListener implements WindowListener
    {
        public void windowDeactivated(WindowEvent event)
        //Useless method
        {
            
        }
        public void windowActivated(WindowEvent event)
        //Useless method
        {
            
        }
        public void windowDeiconified(WindowEvent event)
        //Useless method
        {
            
        }
        public void windowIconified(WindowEvent event)
        //Useless method
        {
            
        }
        public void windowClosed(WindowEvent event)
        //Useless method
        {
            
        }
        public void windowClosing(WindowEvent event)
        //Prevents user from closing the window
        {
            JOptionPane.showMessageDialog(null, "An error has occurred: you can never leave.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        public void windowOpened(WindowEvent event)
        //Useless method
        {
            
        }
    }
}