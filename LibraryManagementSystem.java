import java.util.ArrayList;
import javax.swing.*;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        // List to store books
        ArrayList<Book> books = new ArrayList<>();

        // Create main window
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Title
        JLabel title = new JLabel("Library Management System");
        title.setBounds(200, 20, 250, 30);
        frame.add(title);

        // Book Name
        JLabel nameLabel = new JLabel("Book Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 150, 25);
        frame.add(nameField);

        // Author
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 110, 100, 25);
        frame.add(authorLabel);

        JTextField authorField = new JTextField();
        authorField.setBounds(150, 110, 150, 25);
        frame.add(authorField);

        // Book ID
        JLabel idLabel = new JLabel("Book ID:");
        idLabel.setBounds(50, 150, 100, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 150, 150, 25);
        frame.add(idField);

        // Buttons
        JButton addButton = new JButton("Add Book");
        addButton.setBounds(50, 200, 100, 30);
        frame.add(addButton);

        JButton viewButton = new JButton("View Books");
        viewButton.setBounds(170, 200, 120, 30);
        frame.add(viewButton);

        JButton deleteButton = new JButton("Delete Book");
        deleteButton.setBounds(310, 200, 120, 30);
        frame.add(deleteButton);

        JButton searchButton = new JButton("Search Book");
        searchButton.setBounds(450, 200, 120, 30);
        frame.add(searchButton);

        // Add Book button action
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String author = authorField.getText();

            if(id.isEmpty() || name.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields");
            } else {
                books.add(new Book(id, name, author));
                JOptionPane.showMessageDialog(frame, "Book added successfully!");

                // Clear fields
                idField.setText("");
                nameField.setText("");
                authorField.setText("");
            }
        });

        // View Books button action
        viewButton.addActionListener(e -> {
            if(books.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No books available");
            } else {
                StringBuilder sb = new StringBuilder();
                for(Book b : books) {
                    sb.append(b.toString()).append("\n");
                }

                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(500, 200));

                JOptionPane.showMessageDialog(frame, scrollPane, "All Books", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Make window visible
        frame.setVisible(true);
    }
}

// Book class
class Book {
    String id;
    String name;
    String author;

    Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Author: " + author;
    }
}