package com.company;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.io.*;
import java.awt.*;

public class Catalog implements Serializable{

    private List<Document> docs;

    public Catalog() {
        this.docs = new ArrayList<>();
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void addDoc(Document doc) {
        if (!(docs.contains(doc))) {
            docs.add(doc);
        }
    }

    public void save() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("test.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(this);
        }
        catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        }
    }

    public static Catalog load() throws IOException {
        Catalog readCatalog = null;
        try {
            FileInputStream fis = new FileInputStream("test.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            readCatalog = (Catalog) objectInputStream.readObject();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readCatalog;
    }

    public static void view(Document doc) throws IOException {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(doc.getLink());
        }catch (IOException e) {
            System.out.println("Unexpected error viewing the file!");
            e.printStackTrace();
        }
    }
}