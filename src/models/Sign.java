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
public class Sign {
    public enum Type {
	X, O
    }
    
    private String path;
    private Type type;

    public Sign(String path, Type type) {
	this.path = path;
	this.type = type;
    }

    public String getPath() {
	return path;
    }

    public Type getType() {
	return type;
    }
    
    
}
