package com.hocjavaweb.paging;

import com.hocjavaweb.sort.Sorter;

public interface Pageble {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSorter();

}
