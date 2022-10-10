/* This file contains a few exercises and TODOs for you to fill.
 * Make sure you do the TODOs in Bag.java, HandBag.java and CrossbodyBag.java
 * as the tasks in this file depends on the completion on those!
 *
 * You may find the readings in chapter 3. Relationships between Classes
 * helpful while working through this exercise.
 */
class BagMain {
    /**
     * TODO: Implement this method
     * Enhance each of the bags in bags. If double_enhance_handbags is
     * True, then enhance any HandBags a second time.
     *
     * This method should work for *all* Bags! We will test this method
     * on new Bag types (and HandBag subclasses)!
     */
    public static void enhanceBags(Bag[] bags, boolean double_enhance_handbags) {
        // TODO: Implement this.

        // Iterate through each bag
        for (Bag current_bag : bags) {

            // If double_enhance_handbags is true and current_bag is a HandBag, then double-enhance current_bag
            if (double_enhance_handbags && current_bag instanceof HandBag) {
                current_bag.enhance();
                current_bag.enhance();

            // Else, only do 1 enhance call
            } else {
                current_bag.enhance();
            }
        }
    }

    /**
     * TODO: Implement this method
     * Return the total number of straps in CrossbodyBags in bags.
     * Any bag that is not a CrossbodyBag should not be included
     * in the count!
     *
     * @param bags An array of Bags
     * @return The total number of straps of CrossbodyBags.
     */
    public static int countCrossbodyStraps(Bag[] bags) {
        // TODO: Implement this.

        // Define a variable to count total straps for CrossbodyBags
        int total_straps = 0;

        // Iterate through each bag
        for (Bag current_bag : bags) {

            // If the current bag is a CrossbodyBag, then add its number of straps to the count
            if (current_bag instanceof CrossbodyBag) {
                total_straps = total_straps + ((CrossbodyBag) current_bag).getNumberOfStraps();
            }
        }

        // Return the total number of straps of all CrossbodyBags in bags
        return total_straps;
    }
}