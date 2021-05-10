import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginationHelper<I> {

    private final List<I> collection;
    private final int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
            this.collection = collection;
            this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
            return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
            return (int) Math.ceil(this.collection.size() / (float) this.itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {

        if(pageIndex < 0 || pageIndex >= pageCount())
            return -1;

        else if(pageIndex < pageCount() - 1)
            return this.itemsPerPage;

        else
            return this.collection.size() % this.itemsPerPage;

    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex >= this.collection.size())
            return -1;
        return itemIndex/this.itemsPerPage;
    }
}
