package mca.client.book;

import java.util.LinkedList;
import java.util.List;
import mca.client.book.pages.Page;
import mca.client.book.pages.TextPage;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class Book {
    private final String bookName;
    private final List<Page> pages = new LinkedList<>();
    private Identifier background = new Identifier("textures/gui/book.png");
    private Formatting textFormatting = Formatting.BLACK;
    private boolean pageTurnSound = true;

    public Book(String name) {
        bookName = name;
    }

    public Book setBackground(Identifier background) {
        this.background = background;
        return this;
    }

    public Book setTextFormatting(Formatting textFormatting) {
        this.textFormatting = textFormatting;
        return this;
    }

    public Book setPageTurnSound(boolean pageTurnSound) {
        this.pageTurnSound = pageTurnSound;
        return this;
    }

    public Book addPage(Page page) {
        pages.add(page);
        return this;
    }

    private Book addPages(List<Page> pages) {
        for (Page p : pages) {
            addPage(p);
        }
        return this;
    }

    public Book addSimplePages(int n) {
        return addSimplePages(n, 0);
    }

    public Book addSimplePages(int n, int start) {
        for (int i = 0; i < n; i++) {
            addPage(new TextPage(getBookName(), start + i));
        }
        return this;
    }

    public int getPageCount() {
        return pages.size();
    }

    public String getBookName() {
        return bookName;
    }

    public List<Page> getPages() {
        return pages;
    }

    public Identifier getBackground() {
        return background;
    }

    public Formatting getTextFormatting() {
        return textFormatting;
    }

    public boolean hasPageTurnSound() {
        return pageTurnSound;
    }

    public Page getPage(int index) {
        return pages.get(index);
    }

    public void open() {

    }

    public void setPage(int i, boolean back) {
        getPage(i).open(back);
    }

    public Book copy() {
        return new Book(getBookName())
                .setBackground(getBackground())
                .setTextFormatting(getTextFormatting())
                .setPageTurnSound(hasPageTurnSound())
                .addPages(pages);
    }
}
