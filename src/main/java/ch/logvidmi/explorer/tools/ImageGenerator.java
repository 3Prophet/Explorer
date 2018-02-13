package ch.logvidmi.explorer.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import javax.swing.Icon;
import javax.swing.JFileChooser;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 * Creates Java FX images from Icons
 * 
 * @author Dmitry Logvinovich
 *
 */
public class ImageGenerator {
	
	/**
	 * Creates Image for a file in a file system which is to be used by Java Fx TreeItem to display file icon
	 * 
	 * @param path Path to the file
	 * @return 
	 */
	public static Image generateImage(File path) {
		Image image = null;
		JFileChooser fc = new JFileChooser();
		Icon icon = fc.getUI().getFileView(fc).getIcon(path);
		BufferedImage bufferedImage = new BufferedImage(
		        icon.getIconWidth(), 
		        icon.getIconHeight(), 
		        BufferedImage.TYPE_INT_ARGB
		    );
		icon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
		image = SwingFXUtils.toFXImage(bufferedImage, null);
		return image;
	}
}
