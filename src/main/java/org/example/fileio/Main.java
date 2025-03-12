package org.example.fileio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame {
    private JTextArea logArea;
    private JButton executeButton;

    public Main() {
        setTitle("File Operations Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        executeButton = new JButton("Execute File Operations");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performFileOperations();
            }
        });

        // Layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(executeButton, BorderLayout.SOUTH);
    }

    private void log(String message) {
        logArea.append(message + "\n");
    }

    private void performFileOperations() {
        // Step 1: Create a folder
        File folder = new File("fileOperationsDemo");
        if (folder.mkdir()) {
            log("Folder created: " + folder.getAbsolutePath());
        } else {
            log("Folder already exists or couldn't be created.");
        }

        // Step 2: Create test.txt file
        File testFile = new File(folder, "test.txt");
        try {
            if (testFile.createNewFile()) {
                log("File created: " + testFile.getName());

                // Write some content to the file
                try (FileWriter writer = new FileWriter(testFile)) {
                    writer.write("This is a test file created by the File Operations Demo app.");
                }
                log("Content written to the file.");

                // Step 3: Display file properties
                log("File properties:");
                log("- Name: " + testFile.getName());
                log("- Size: " + testFile.length() + " bytes");
                log("- Path: " + testFile.getAbsolutePath());

                // Step 4: Rename to book.txt
                File bookFile = new File(folder, "book.txt");
                if (testFile.renameTo(bookFile)) {
                    log("File renamed to: " + bookFile.getName());

                    // Step 5: Delete the file
                    if (bookFile.delete()) {
                        log("File deleted successfully.");
                    } else {
                        log("Failed to delete the file.");
                    }
                } else {
                    log("Failed to rename the file.");
                }
            } else {
                log("Failed to create the file or it already exists.");
            }
        } catch (IOException e) {
            log("Error: " + e.getMessage());
            e.printStackTrace();
        }

        // Attempt to delete the folder (will only succeed if empty)
        if (folder.delete()) {
            log("Folder deleted successfully.");
        } else {
            log("Failed to delete folder (it may not be empty).");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}