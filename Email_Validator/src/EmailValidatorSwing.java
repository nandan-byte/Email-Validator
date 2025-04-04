import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmailValidatorSwing extends JFrame {
    
    private JTextField emailfield;
    private JLabel resultfield;

    EmailValidatorSwing() {
        this.setTitle("Email Validator");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setLocationRelativeTo(null);

        // Set Dark Mode
        this.getContentPane().setBackground(Color.DARK_GRAY);

        // GUI Components
        JLabel emailLabel = new JLabel("Enter your email to validate:");
        emailLabel.setForeground(Color.WHITE);
        emailfield = new JTextField(20);
        emailfield.setBackground(Color.BLACK);
        emailfield.setForeground(Color.WHITE);
        emailfield.setCaretColor(Color.white); //Blink cursor
        JButton validateButton = new JButton("Validate");
        resultfield = new JLabel("");
        resultfield.setForeground(Color.WHITE);

        // Button Style
        
        validateButton.setFocusable(false);
        validateButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Button Click Event (Lambda)
        validateButton.addActionListener(e -> validateEmail());

        // Add Components
        add(emailLabel);
        add(emailfield);
        add(resultfield);
        add(validateButton);

        this.setVisible(true);
    }

    private void validateEmail() {
        String email = emailfield.getText();
        if (isValidEmail(email)) {
            resultfield.setText(email + " is Valid ready to go.");
            resultfield.setForeground(Color.GREEN);
            resultfield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
            emailfield.setCaretColor(Color.green);
            emailfield.setBorder(BorderFactory.createLineBorder(Color.green));
        } else {
            resultfield.setText(email + " is NOT Valid ");
            resultfield.setForeground(Color.RED);
            resultfield.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            emailfield.setCaretColor(Color.red);
            emailfield.setBorder(BorderFactory.createLineBorder(Color.red));
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$";
        return Pattern.matches(emailRegex, email);
        //Equivalent to 
        //Pattern pattern = Pattern.compile(emailRegex);
//		Matcher matcher = pattern.matcher(email);
//		return matcher.matches();
    }

    public static void main(String[] args) {
        new EmailValidatorSwing();
    }
}
