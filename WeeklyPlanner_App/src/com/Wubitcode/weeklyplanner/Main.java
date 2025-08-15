package com.Wubitcode.weeklyplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlannerFrame frame = new PlannerFrame();
            frame.setVisible(true);
        });
    }
}

class PlannerFrame extends JFrame {
    private final JTextField tfWeekLabel;
    private final JTextArea taTasks;
    private final JLabel statusLabel;
    private Path lastGenerated;

    PlannerFrame() {
        super("Weekly Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JPanel pLabel = new JPanel(new BorderLayout(8, 8));
        pLabel.add(new JLabel("Week label (e.g., Week of Aug 18, 2025):"), BorderLayout.NORTH);
        tfWeekLabel = new JTextField(
            "Week of " + LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy"))
        );
        pLabel.add(tfWeekLabel, BorderLayout.CENTER);
        root.add(pLabel);

        root.add(Box.createVerticalStrut(12));

        JPanel pTasks = new JPanel(new BorderLayout(8, 8));
        pTasks.add(new JLabel("Enter 3–7 tasks (one per line):"), BorderLayout.NORTH);
        taTasks = new JTextArea(10, 40);
        taTasks.setFont(new Font("Monospaced", Font.PLAIN, 14));
        taTasks.setLineWrap(true);
        taTasks.setWrapStyleWord(true);
        pTasks.add(new JScrollPane(taTasks), BorderLayout.CENTER);
        root.add(pTasks);

        root.add(Box.createVerticalStrut(12));

        JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGenerate = new JButton("Generate Markdown");
        JButton btnOpen = new JButton("Open Last File");
        btnOpen.setEnabled(false);
        pButtons.add(btnGenerate);
        pButtons.add(btnOpen);
        root.add(pButtons);

        statusLabel = new JLabel("Ready.");
        root.add(Box.createVerticalStrut(8));
        root.add(statusLabel);

        setContentPane(root);

        btnGenerate.addActionListener(e -> doGenerate(btnOpen));
        btnOpen.addActionListener(e -> openLastFile());
    }

    private void doGenerate(JButton btnOpen) {
        String label = tfWeekLabel.getText().trim();
        List<String> tasks = readTasks();

        if (tasks.size() < 3 || tasks.size() > 7) {
            JOptionPane.showMessageDialog(this,
                    "Please enter between 3 and 7 tasks (one per line).",
                    "Invalid number of tasks",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (label.isEmpty()) {
            label = "Week of " + LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
        }

        String md = MarkdownBuilder.build(label, tasks);

        try {
            Path docs = Paths.get(System.getProperty("user.home"), "Documents");
            Files.createDirectories(docs);

            String datePart = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            String safeLabel = label.replaceAll("[^A-Za-z0-9-_]+", "_");
            String fileName = "WeeklyPlan_" + safeLabel + "_" + datePart + ".md";

            Path out = docs.resolve(fileName);
            Files.write(out, md.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            lastGenerated = out;
            btnOpen.setEnabled(true);

            Toolkit.getDefaultToolkit().getSystemClipboard()
                  .setContents(new StringSelection(out.toString()), null);

            statusLabel.setText("Saved: " + out);
            int choice = JOptionPane.showConfirmDialog(this,
                    "Plan saved to:\n" + out + "\n\nOpen now?",
                    "Weekly Planner", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                openPath(out);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to save file:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<String> readTasks() {
        String raw = taTasks.getText();
        String[] lines = raw.split("\\R");
        List<String> tasks = new ArrayList<>();
        for (String line : lines) {
            String t = line.trim();
            if (!t.isEmpty()) tasks.add(t);
        }
        return tasks;
    }

    private void openLastFile() {
        if (lastGenerated != null) {
            openPath(lastGenerated);
        } else {
            JOptionPane.showMessageDialog(this, "No file generated yet.");
        }
    }

    private void openPath(Path p) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(p.toFile());
            } else {
                JOptionPane.showMessageDialog(this, "Desktop open not supported on this system.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Could not open file:\n" + ex.getMessage(),
                    "Open Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
