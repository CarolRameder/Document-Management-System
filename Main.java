package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.Catalog.view;

public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Document d1 = new Document(10, "HISTORY OF PHILOSOPHY", "https://www.gutenberg.org/files/61651/61651-h/61651-h.htm");
        Document d2 = new Document(20, "daily situation", "https://experience.arcgis.com/experience/685d0ace521648f8a5beeeee1b9125cd");
        Document d3 = new Document(30, "PIKKUPAPPILASSA", "http://www.gutenberg.org/cache/epub/61648/pg61648-images.html");
        Document d4 = new Document(40, "Vincent van Gogh", "https://ro.wikipedia.org/wiki/Vincent_Van_Gogh");
        d3.addTag("author", "Agatha Cristie");
        d2.addTag("publishingDate", "20-03-2004");
        Catalog myCatalog = new Catalog();
        myCatalog.addDoc(d1);
        myCatalog.addDoc(d2);
        myCatalog.addDoc(d3);
        myCatalog.addDoc(d4);
        myCatalog.save();
        Catalog loadedCatalog = new Catalog();
        loadedCatalog = Catalog.load();

        for (Document doc : loadedCatalog.getDocs()) {
            view(doc);
        }
    }
}
