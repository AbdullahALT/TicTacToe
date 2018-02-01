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
    private String name;
    private Type type;

    public Sign(String path, String name, Type type) {
	this.path = path;
	this.name = name;
	this.type = type;
    }

    public String getPath() {
	return path;
    }

    public String getName() {
	return name;
    }

    public Type getType() {
	return type;
    }
    
    
}
