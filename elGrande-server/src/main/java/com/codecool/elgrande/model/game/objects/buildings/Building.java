package com.codecool.elgrande.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;
import com.codecool.elgrande.model.game.technologies.Technologies;


public abstract class Building {
    private Resources cost;
    private int energyUsage;
    private int level = 0;

    public abstract void levelUp();

    public Resources getCost(){
        return cost;
    }
    public void setCost(Resources cost){
        this.cost = cost;
    }
    public int getEnergyUsage(){
        return this.energyUsage;
    }
    public void setEnergyUsage(int energyUsage){
        this.energyUsage = energyUsage;
    }
    public void addLevel(){
        this.level += 1;
    }
    public int getLevel(){
        return this.level;
    }

}
