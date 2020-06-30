package com.company.myTreeMap;

/**
 * Реализация словаря на базе простого (наивного) дерева поиска
 *
 * @param <K>
 * @param <V>
 */
public class MyTreeMap<K extends Comparable<K>, V> implements DefaultBSTreeMap<K, V> {

    private final DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> tree = new SimpleBSTree<>();

    @Override
    public DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
