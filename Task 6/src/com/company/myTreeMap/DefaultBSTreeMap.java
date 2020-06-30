package com.company.myTreeMap;



import com.company.util.dummy.DefaultNotSupportedCollection;
import com.company.util.dummy.DefaultNotSupportedSet;
import com.company.util.dummy.DefaultNotSupportedSortedMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Интерфейс словаря на базе двоичного дерева поиска (BinarySearchTree) с
 * реализацией по умолчанию
 *
 * @param <K>
 * @param <V>
 */
public interface DefaultBSTreeMap<K extends Comparable<? super K>, V> extends DefaultNotSupportedSortedMap<K, V> {

    class MapTreeEntry<K extends Comparable<? super K>, V> implements Map.Entry<K, V>, Comparable<MapTreeEntry<K, V>> {

        public K key;
        public V value;

        public MapTreeEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(MapTreeEntry<K, V> o) {
            return this.key.compareTo(o.key);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    DefaultBSTree<MapTreeEntry<K, V>> getTree();

    @Override
    default int size() {
        return getTree().size();
    }

    @Override
    default boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    default boolean containsKey(Object key) {
        return getTree().contains(new MapTreeEntry((K) key, null));
    }



    @Override
    default V get(Object key) {
        MapTreeEntry<K, V> entry = getTree().get(new MapTreeEntry((K) key, null));
        return (entry == null) ? null : entry.value;
    }

    @Override
    default V put(K key, V value) {
        MapTreeEntry<K, V> entry = getTree().put(new MapTreeEntry(key, value));
        return entry == null ? null : entry.value;
    }

    @Override
    default V remove(Object key) {
        MapTreeEntry<K, V> entry = getTree().remove(new MapTreeEntry((K) key, null));
        return entry == null ? null : entry.value;
    }

    @Override
    default void putAll(Map<? extends K, ? extends V> m) {
        m.entrySet().forEach((entry) -> {
            getTree().put(new MapTreeEntry(entry.getKey(), entry.getValue()));
        });
    }

    @Override
    default void clear() {
        getTree().clear();
    }

    @Override
    default Set<K> keySet() {
        return new DefaultNotSupportedSet<K>() {
            Iterator<Map.Entry<K, V>> entryIterator = entrySet().iterator();

            @Override
            public int size() {
                return DefaultBSTreeMap.this.size();
            }

            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {
                    @Override
                    public boolean hasNext() {
                        return entryIterator.hasNext();
                    }

                    @Override
                    public K next() {
                        return entryIterator.next().getKey();
                    }

                };
            }

            // надо будет потом реализовать остальные методы
        };
    }

    @Override
    default Collection<V> values() {
        return new DefaultNotSupportedCollection<V>() {
            Iterator<Map.Entry<K, V>> entryIterator = entrySet().iterator();

            @Override
            public int size() {
                return DefaultBSTreeMap.this.size();
            }

            @Override
            public Iterator<V> iterator() {
                return new Iterator<V>() {
                    @Override
                    public boolean hasNext() {
                        return entryIterator.hasNext();
                    }

                    @Override
                    public V next() {
                        return entryIterator.next().getValue();
                    }

                };
            }

            // надо будет потом реализовать остальные методы
        };
    }

    @Override
    default Set<Entry<K, V>> entrySet() {
        return new DefaultNotSupportedSet<Entry<K, V>>() {
            @Override
            public int size() {
                return DefaultBSTreeMap.this.size();
            }



            // надо будет потом реализовать остальные методы
        };
    }
}
