/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Sheena
 */
public class InventoryObject {
    
    public String name;
    public int quantity;
    public String image;
    
    public InventoryObject(String n, int q, String i) {
        
        name = n;
        quantity = q;
        image = i;
        
    }
    
    public void incrementQuantity(int i) {
        quantity += i;
    }
    
    public boolean decrementQuantity(int i) {
        
        if (quantity - i >= 0) {
            quantity -= i;
            return true;
        } return false;
        
    }
    
}
