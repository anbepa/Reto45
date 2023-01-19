package co.com.bancolombia.certification.income.manualtest;

import org.junit.Assert;

import javax.swing.*;

public class ManualTest {

    private ManualTest() {
        throw new IllegalStateException("Utility class");
    }

    public static void validate(String step, String nameScenario) {
        int intYes = 1;
        String reason = "";
        String[] options = {"No", "Yes"};
        int optionSelected = JOptionPane.showOptionDialog(new JFrame(), "The step \"" + step + "\" was executed correctly?",
                nameScenario, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if(optionSelected == 0) {
            reason = JOptionPane.showInputDialog("Enter the reason why the test did not run correctly");
        }
        Assert.assertEquals(reason, intYes, optionSelected);
    }
}
