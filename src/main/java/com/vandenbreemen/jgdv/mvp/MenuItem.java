package com.vandenbreemen.jgdv.mvp;

/**
 * An action that the user can take
 */
public interface MenuItem {

    String getName();

    /**
     * Perform the action associated with this item
     */
    void doAction();

}
