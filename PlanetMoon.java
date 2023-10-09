/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

public class PlanetMoon {
    
    public String name;
    public int level;
    public String description;
    public String[][] surveyTasks;
    public String[][] habitableTasks;
    public int numSurveyCorrect = 0;
    public int numHabitableCorrect = 0;
    public InventoryObject[][] requiredMaterials;
    public String[] observations;
    
    public PlanetMoon(String n, int l, String d, String[][] st, String[][] ht, InventoryObject[][] r, String[] o) {
        
        name = n;
        level = l;
        description = d;
        surveyTasks = st;
        habitableTasks = ht;
        requiredMaterials = r;
        observations = o;
        
    }
    
    public boolean canProgress() {
        if (numSurveyCorrect + numHabitableCorrect >= surveyTasks.length + habitableTasks.length - 2) {
            numSurveyCorrect = 0;
            numHabitableCorrect = 0;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean removeMaterials(int choice) {
        
        int currentTask = 0;
        for (int i = 0; i < habitableTasks.length; i++) {
            if (habitableTasks[i][0].equalsIgnoreCase(Globals.task)) currentTask = i;
        }
        
        InventoryObject required = requiredMaterials[currentTask][choice];
        
        int inventorySlot = -1;
        for (int i = 0; i < Globals.inventory.size(); i++) {
            if (Globals.inventory.get(i).name.equalsIgnoreCase(required.name)) inventorySlot = i;
        }
        
        if (required.name.equalsIgnoreCase("Special")) {
            return true;
        } else if (required.name.length() == 0) {
            return true;
        } else if (inventorySlot == -1) {
            return false;
        } else {
            boolean hi = Globals.inventory.get(inventorySlot).decrementQuantity(required.quantity);
            int remove = 0;
            for (int i = 1; i < Globals.inventory.size(); i++) {
                if (Globals.inventory.get(i).quantity == 0) {
                    remove = i;
                }
            }
            if (remove > 0) {
                Globals.inventory.remove(remove);
            }
            return hi;
        }
        
    }
    
}
