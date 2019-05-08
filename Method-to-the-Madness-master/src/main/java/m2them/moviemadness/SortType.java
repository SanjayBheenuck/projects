package m2them.moviemadness;

public class SortType {

    //like ReviewSort, holds user's requested sort type
    private int sortType;

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public SortType(int sortType) {
        this.sortType = sortType;
    }

}
