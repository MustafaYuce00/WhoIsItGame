import javax.swing.SwingUtilities;

public class WhoItIsGame {
	  public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            MainForm mainForm = new MainForm();
	            mainForm.setVisible(true);
	        });
	    }
}
