/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author abaaltamimi
 */
public interface Observable {
    void notify(Position position, Sign sign);
    void register(Observer observer);
}
