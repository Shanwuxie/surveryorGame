/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.HashMap;

public class StaticMethods {
    
    public static boolean checkAnswer(String letter) {
        
        String[] arr = findArray();
        if (arr[9].equalsIgnoreCase(letter)) return true;
        return false;
        
    }
    
    // Returns array of the current task
    public static String[] findArray() {
        
        int currentPlanetMoon = 0;
        for (; currentPlanetMoon < Globals.planetsAndMoons.length && !Globals.planetsAndMoons[currentPlanetMoon].name.equalsIgnoreCase(Globals.currentPlanetMoon); currentPlanetMoon++);
        PlanetMoon current = Globals.planetsAndMoons[currentPlanetMoon];
        
        if (Globals.phase.equalsIgnoreCase("Survey")) {
            
            int currentSurvey = 0;
            for (; currentSurvey < current.surveyTasks.length; currentSurvey++) {
                if (Globals.task.equalsIgnoreCase(current.surveyTasks[currentSurvey][0])) return current.surveyTasks[currentSurvey];
            }
            
        } else if (Globals.phase.equalsIgnoreCase("Habitable")) {
            
            int currentSurvey = 0;
            for (; currentSurvey < current.habitableTasks.length; currentSurvey++) {
                if (Globals.task.equalsIgnoreCase(current.habitableTasks[currentSurvey][0])) return current.habitableTasks[currentSurvey];
            }
            
        }
        
        return new String[] {};
        
    }
    
    public static PlanetMoon findPlanetMoon() {
        
        int currentPlanetMoon = 0;
        for (; currentPlanetMoon < Globals.planetsAndMoons.length && !Globals.planetsAndMoons[currentPlanetMoon].name.equalsIgnoreCase(Globals.currentPlanetMoon); currentPlanetMoon++);
        PlanetMoon current = Globals.planetsAndMoons[currentPlanetMoon];
        return current;
        
    }
    
    public static void addInventory(String thing, int quantity) {
        
        int location = -1;
        for (int i = 0; i < Globals.inventory.size(); i++) {
            if (Globals.inventory.get(i).name.equalsIgnoreCase(thing)) location = i;
        }
        
        if (location > -1) {
            Globals.inventory.get(location).incrementQuantity(quantity);
        } else {
            Globals.inventory.add(new InventoryObject(thing, quantity, Globals.links.get(thing)));
        }
        
    }
    
}
