package ch.logvidmi.explorer.model;

import java.io.File;
import java.nio.file.Path;
import javax.swing.filechooser.FileSystemView;

import ch.logvidmi.explorer.tools.ImageGenerator;
import javafx.event.EventType;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;

/**
 * A model for a TreeView node that corresponds to File or a Folder in a file system.
 * 
 * @author Dmitry Logvinovich
 *
 */
public class FileTreeNode extends TreeItem<String> {
	
	/**
	 * File to which the node corresponds.
	 */
	private File file;
	
	/**
	 * File System View is used to interact with file system and get
	 */
	private static final FileSystemView fileSystemView = FileSystemView.getFileSystemView();
	
	/**
	 * Creates TreeItem with name corresponding to {@link java.io.File#toString()} and 
	 * an file/folder icon.
	 * 
	 * @param file
	 */
	public FileTreeNode(File file) {
		super(fileSystemView.getSystemDisplayName(file));
		this.file = file;
		setGraphic(new ImageView(ImageGenerator.generateImage(file)));
	}
	
	/**
	 * Creates root node without a name.
	 */
	public FileTreeNode() {
		super();
	}
	
	/**
	 * Creates FileTreeNode, which children are roots of the file system.
	 * 
	 * @return 
	 */
	public static FileTreeNode createFileTree() {
		FileTreeNode rootNode = new FileTreeNode();
		File[] roots = fileSystemView.getRoots();
		
		for (File topDir: roots) {
			FileTreeNode topNode = new FileTreeNode(topDir);
			rootNode.getChildren().add(topNode);
			for (File child : fileSystemView.getFiles(topDir, true)) {
				if (child.isDirectory()) {
					FileTreeNode childNode = new FileTreeNode(child);
					topNode.getChildren().add(childNode);
				}
			} 
		}
		rootNode.isExpanded();
		return rootNode;
	}

	public void lazyLoad() {
		for (File child: fileSystemView.getFiles(file, true)) {
			if (child.isDirectory()) {
				FileTreeNode childNode = new FileTreeNode(child);
				this.getChildren().add(childNode);
			}
		}
		
	}

}
