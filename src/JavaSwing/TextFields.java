package JavaSwing;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

public class TextFields implements ActionListener {
    
    JTextField givenName;
    JTextField familyName;
    JTextField fullName;
    JButton submitButton = new JButton("Submit");

    public TextFields()
    {
        JFrame frame = new JFrame("Text Fields");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create fields for I/O
        givenName = new JTextField(10);
        familyName = new JTextField(10);
        fullName = new JTextField(10);
        fullName.setEditable(false);

        // Add labelled input fields to display
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));

        JLabel g_name = new JLabel("Given Name");
        JLabel f_name = new JLabel("Family Name");
        JLabel b_enter = new JLabel("Press Button to Enter Names");

        panel.add(g_name);
        panel.add(givenName);
        givenName.addActionListener(this);


        panel.add(f_name);
        panel.add(familyName);
        familyName.addActionListener(this);

        frame.add(panel,BorderLayout.NORTH);

        // Add submission button
        JPanel submitPane = new JPanel();
        submitPane.setLayout(new FlowLayout());
        submitPane.add(b_enter);
        submitButton.addActionListener(this);

        submitPane.add(submitButton);
        frame.add(submitPane,BorderLayout.CENTER);

        // Add Output fields
        JPanel outFieldPane = new JPanel();
        outFieldPane.setLayout(new GridLayout(1,2));
        outFieldPane.add(new JLabel("Full Name"));
        outFieldPane.add(fullName);
        frame.add(outFieldPane,BorderLayout.SOUTH);

        // Display the final product
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {
        // Display full name if and only if button was pushed
        if (e.getSource() == submitButton)
        {
            String fullString = familyName.getText().trim() + ", "
                    + givenName.getText().trim();
            fullName.setText(fullString);
        }
    }

    public static void main(String[] args)
    {
        new TextFields();
    }
}