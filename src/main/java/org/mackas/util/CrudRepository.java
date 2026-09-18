package org.mackas.util;

import java.util.List;

public interface CrudRepository <T,ID>{
    T save(T beans);
    boolean delete(ID id);
    List<T> findAll();
    T update(T beans);
}
