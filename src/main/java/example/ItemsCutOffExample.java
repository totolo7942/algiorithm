package example;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemsCutOffExample {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            items.add(String.valueOf(i));
        }

        int MAX_IN_LIMIT  = 3;
        int tPage = items.size() % MAX_IN_LIMIT > 0 ? items.size() / MAX_IN_LIMIT + 1 : items.size() / MAX_IN_LIMIT;

        System.out.println(" Max page : " + tPage);

//        List<SellerUserGradleEntity> entities = cutoffIds(items);
        List<String> one = ListUtils.getPage(items, 1, 2);
        List<String> two = ListUtils.getPage(items, 2, 2);
        List<String> three = ListUtils.getPage(items, 3, 2);
        List<String> for1 = ListUtils.getPage(items, 4, 2);
        List<String> five = ListUtils.getPage(items, 5, 2);

        return;
    }

    static List<SellerUserGradleEntity> cutoffIds(List<String> items) {

        System.out.printf("## " + items.size() % 10000);

        return Collections.emptyList();
    }

    public static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
        if (c == null)
            return Collections.emptyList();

        List<T> list = new ArrayList<T>(c);
        if (pageSize == null || pageSize <= 0 || pageSize > list.size())
            pageSize = list.size();

        int numPages = (int) Math.ceil((double) list.size() / (double) pageSize);
        
        List<List<T>> pages = new ArrayList<>(numPages);
        for (int pageNum = 0; pageNum < numPages; )
            pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
        return pages;
    }

    static class ListUtils {
        public static <T> List<T> getPage(List<T> sourceList, int page, int pageSize) {

            if (pageSize <= 0 || page <= 0) {
                throw new IllegalArgumentException("invalid page size: " + pageSize);
            }

            int fromIndex = (page - 1) * pageSize;
            if (sourceList == null || sourceList.size() < fromIndex) {
                return Collections.emptyList();
            }

            // toIndex exclusive
            return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
        }

        public static <T> void doPaginated(Collection<T> fullList, Integer pageSize, Page<T> pageInterface) {

            final List<T> list = new ArrayList<T>(fullList);
            if (pageSize == null || pageSize <= 0 || pageSize > list.size()) {
                pageSize = list.size();
            }

            final int numPages = (int) Math.ceil((double) list.size() / (double) pageSize);
            for (int pageNum = 0; pageNum < numPages; ) {
                final List<T> page = list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size()));
                pageInterface.run(page);
            }
        }

        public interface Page<T> {
            void run(List<T> item);
        }
    }
}

@Data
class SellerUserGradleEntity {
    private String memNo;
    private String custGrdNm;
}

