package co.edu.uptc.model;

import co.edu.uptc.structures.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Printer {
    private int pagesLow;
    private int pagesMedium;
    private int pagesHigh;

    private PriorityQueue<Document> queue;

    public Printer(int priorityLevels) {
        queue = new PriorityQueue<>(priorityLevels);
        loadConfiguration("src\\co\\edu\\uptc\\configuration\\Configuration.properties");
    }

    private void loadConfiguration(String configFile) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            properties.load(fis);
            pagesLow = Integer.parseInt(properties.getProperty("pagesLow"));
            pagesMedium = Integer.parseInt(properties.getProperty("pagesMedium"));
            pagesHigh = Integer.parseInt(properties.getProperty("pagesHigh"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDocument(Document document) {
        int priority = calculatePriority(document.getPages());
        queue.push(document, priority);
    }

    private int calculatePriority(int pages) {
        if (pages <= pagesLow) {
            return 0;
        }
        if (pages <= pagesMedium) {
            return 1;
        }
        if (pages <= pagesHigh) {
            return 2;
        }
        return 3;
    }

    public Document printDocument() {
        return queue.pull();
    }
    
    public int getPagesLow() {
        return pagesLow;
    }

    public void setPagesLow(int pagesLow) {
        this.pagesLow = pagesLow;
    }

    public int getPagesMedium() {
        return pagesMedium;
    }

    public void setPagesMedium(int pagesMedium) {
        this.pagesMedium = pagesMedium;
    }

    public int getPagesHigh() {
        return pagesHigh;
    }

    public void setPagesHigh(int pagesHigh) {
        this.pagesHigh = pagesHigh;
    }
}

