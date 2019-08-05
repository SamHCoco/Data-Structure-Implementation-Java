package datastructures;

import java.util.ArrayList;

public class HashTable<T, E> {
    private String[] stringValuesArray;
    private Integer[] integerValuesArray;
    private String valueType;
    private ArrayList<T> keys;
    private ArrayList<E> values;
    private int size;

    public HashTable(){
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * Hash function for generating index to insert values into array.
     * @param key The 'key' of a key-value pair to be inserted into the HashTable
     * @return The integer index associated with a key, or null if hashing failed.
     */
    private Integer hashFunction(T key){
        if(key instanceof String){
            int asciiSum = 0;
            for(int i = 0; i < ((String) key).length(); i++){
                asciiSum += (int) ((String) key).charAt(i);
            }
            return asciiSum % size;
        }
        return null;
    }

    /**
     * Inserts new value into the HashTable.
     * @param key The key of the key-value pair
     * @param value The value of the key-value pair
     */
    public void put(T key, E value){
        // initialises array that stores values
        if(valueType == null){
            initializeValuesArray(value);
        }
        // adds new value to HashTable
        keys.add(key);
        values.add(value);
        if(valueType.equals("STRING")){
            stringValuesArray = new String[size + 1];
            size++;
            for(int i = 0; i < keys.size(); i++){
                stringValuesArray[hashFunction(keys.get(i))] = (String) values.get(i);
            }
        }
    }

    /**
     * Checks type of the value ('E') and initialises an array of that type
     * that will store the values of the Hash Table.
     */
    private void initializeValuesArray(E type){
        if(type instanceof  String){
            stringValuesArray = new String[0];
            valueType = "STRING";
        } else if(type instanceof Integer){
            integerValuesArray = new Integer[0];
            valueType = "INTEGER";
        }
    }
}
