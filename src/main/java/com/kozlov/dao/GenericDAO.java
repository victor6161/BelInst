package com.kozlov.dao;

import java.util.List;

public interface GenericDAO<T> {
    /**
     * Сохранение объекта.
     *
     * @param o
     */
    void save(final T o);

    /**
     * Получение списка.
     *
     * @param clazz
     * @return
     */
    List<T> getList(final Class clazz);

}
