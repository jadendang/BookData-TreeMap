import java.util.Arrays;

/**
 * Creates a TreeMap class storing key-value pairs using BST.
 *
 * @param <K> the keys stored in this map
 * @param <V> the values stored in this map
 */
public class TreeMap<K extends Comparable<K>, V> {

    /**
     * The root node of the binary search tree.
     */
    private TreeMapNode<K, V> overallRoot;
    /**
     * Number of elements stored in the tree.
     */
    private int size;

    /**
     * Creates an empty TreeMap.
     */
    public TreeMap() {
        overallRoot = null;
        size = 0;
    }

    /**
     * Returns the number of key-values in this TreeMap.
     *
     * @return the number of key-values in this TreeMap
     */
    public int size() {
        return size;
    }

    /**
     * Adds the specified value with the specified key into the TreeMap.
     *
     * @param key the key with the specified value associated
     * @param value the value with the specified key associated
     */
    public void put(K key, V value) {
        overallRoot = put(overallRoot, key, value);
    }

    /**
     * A Helper method to recursively put key-value into the TreeMap.
     *
     * @param root the root of the subtree
     * @param key the key to be added
     * @param value the value associated with the key
     * @return the root of the updated subtree
     */
    private TreeMapNode<K, V> put(TreeMapNode<K, V> root, K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (root == null) {
            size++;
            return new TreeMapNode<>(key, value);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key associated to the value to be found
     * @throws IllegalArgumentException throws if the key is not found
     * @return the value associated with the specified key
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return get(overallRoot, key);
    }

    /**
     * Returns the value associated with the specified key in the TreeMap.
     * @param root the root of the subtree to search
     * @param key the key associated to the value to be found
     * @return the value associated with the specified key
     * @throws IllegalArgumentException if the specified key is null
     */
    private V get(TreeMapNode<K, V> root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            return get(root.left, key);
        } else if (cmp > 0) {
            return get(root.right, key);
        } else {
            return root.value;
        }
    }

    /**
     * Checks if the TreeMap contains the specified key.
     * @param key the key to be checked in the TreeMap
     * @return true if the TreeMap contains the specified key, otherwise false
     * @throws IllegalArgumentException if the specified key is not found
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Removes all nodes of the TreeMap.
     */
    public void clear() {
        overallRoot = null;
        size = 0;
    }

    /**
     * Returns a sorted array of all the keys in the TreeMap
     * @param array the array where the keys are to sorted
     * @return an array containing sorted keys in the TreeMap
     */
    public K[] toKeyArray(K[] array) {
        if (array == null || array.length < size) {
            assert array != null;
            array = Arrays.copyOf(array, size);
        }
        fillKeyArray(overallRoot, array, 0);
        return array;
    }

    /**
     * Fills the array recursively with the keys of the TreeMap in ascending order.
     *
     * @param root the root of the subtree to fill the array from
     * @param array the array to be filled with keys
     * @param index the current index in the array
     * @return the index after filling the array
     */
    private int fillKeyArray(TreeMapNode<K, V> root, K[] array, int index) {
        if (root != null) {
            index = fillKeyArray(root.left, array, index);
            array[index++] = root.key;
            index = fillKeyArray(root.right, array, index);
        }
        return index;
    }

    /**
     * Represents a node in the TreeMap with key-values and their references to left and right child nodes.
     *
     * @param <K> the type of keys in the TreeMap
     * @param <V> the type of mapped values
     */
    private static class TreeMapNode<K, V> {
        /**
         * The key associated with the node in the binary search tree.
         */
        public K key;
        /**
         * The value associated with the node in the binary search tree.
         */
        public V value;
        /**
         * Reference to the left child node of this tree node.
         */
        public TreeMapNode<K, V> left;
        /**
         * Reference to the right child node of this tree node.
         */
        public TreeMapNode<K, V> right;

        /**
         * Creates new TreeMapNode with the specified key and value.
         *
         * @param key the key of the node
         * @param value the value of the node
         */
        public TreeMapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
