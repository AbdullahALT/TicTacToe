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
    private String path;
    private String name;

    public Sign(String path, String name) {
	this.path = path;
	this.name = name;
    }

    public String getPath() {
	return path;
    }

    public String getName() {
	return name;
    }
    
    
}
