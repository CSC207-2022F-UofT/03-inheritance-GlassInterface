/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;


    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */
    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[capacity];
    }


    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */
    /**
     * Get color of the Bag.
     *
     * @return the Bag's color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Get number of contents of the Bag.
     *
     * @return the Bag's contents
     */
    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    /**
     * Get capacity of the Bag.
     *
     * @return the Bag's capacity
     */
    public int getCapacity() {
        return this.capacity;
    }


    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */

    /**
     * Set color of Bag to given color.
     */
    public void setColor(String given_color) {
        this.color = given_color;
    }


    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */
    public boolean addItem(String item) {
        /**
         * Try to add item into the Bag if the number of items
         * so far is less than the Bag's capacity. Return a
         * boolean representing the success of doing so.
         */
        if (this.numberOfContents < this.capacity) {
            this.contents[numberOfContents] = item;
            this.numberOfContents = this.numberOfContents + 1;
            return true;
        } else {
            return false;
        }
    }




    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * If there are no items in this Bag, return null.
     *
     * @return null if there are no items in the Bag, or the last item added to the Bag
     */
    public String popItem() {
        // If the number of contents is 0, do nothing and return null
        if (this.numberOfContents == 0) {
            return null;

        // Else, number of contents is > 0, so pop item
        } else {

            // Get the last non-null item and update number of contents
            String last_item = this.contents[this.numberOfContents - 1];
            this.numberOfContents = this.numberOfContents - 1;

            // Create a new array of the same capacity
            String[] new_array = new String[this.capacity];

            // Iterate through the array to copy everything except the last item
            for (int i = 0; i <= this.contents.length - 2; i = i + 1) {
                new_array[i] = this.contents[i];
            }

            // Re-assign the array associated with the contents, so the last item is "removed"
            this.contents = new_array;

            // Return the last item
            return last_item;
        }
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.

        // Create a new array of String objects to represent new contents, as an array has a fixed length
        String[] new_contents = new String[this.contents.length + n];

        // Loop to copy remaining items of this.contents into new_contents
        for (int i = 0; i <= this.contents.length - 1; i = i + 1) {
            new_contents[i] = this.contents[i];
        }

        // Make the contents attribute refer to new_contents
        this.contents = new_contents;

        // Update capacity
        this.capacity = new_contents.length;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}