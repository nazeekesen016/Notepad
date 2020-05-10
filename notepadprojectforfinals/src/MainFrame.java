import notepad.Main;

import javax.swing.*;

import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    private JButton button1;
    private Main dialog;
    public MainFrame() {
        setSize(500, 250);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        button1 = new JButton("Start notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(this);
        button1.setActionCommand("Open");
        add(button1);
        pack();

        dialog = new Main();
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dialog.setVisible(true);
            }

        });
        panel.add(button1);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if(cmd.equals("Open"))
        {
            dispose();
            new Main();
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}