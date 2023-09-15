package com.example.virtualpetapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VirtualPet {
  protected static final int MAX_NEED_LEVEL = 100;
  protected static final int DEFAULT_HEALTH_LEVEL = 100;
  protected static final int DEFAULT_ENERGY_LEVEL = 10;
  protected static final int DEFAULT_HUNGER_LEVEL = 10;
  protected static final int DEFAULT_THIRST_LEVEL = 10;
  protected static final int DEFAULT_WASTE_LEVEL = 1;
  protected static final int DEFAULT_FUN_LEVEL = 10;

  protected static final int HEALTH_GAIN = 5;
  protected static final int HUNGER_GAIN = 5;
  protected static final int HUNGER_WASTE_GAIN = 5;
  protected static final int THIRST_GAIN = 4;
  protected static final int THIRST_WASTE_GAIN = 2;
  protected static final int FUN_GAIN = 5;

  protected static final int HEALTH_COST = 5;
  protected static final int ENERGY_COST = 1;
  protected static final int THIRST_COST = 2;
  protected static final int NEED_COST = 1;

  @Id
  @GeneratedValue
  private Long id;

  private int healthLevel = DEFAULT_HEALTH_LEVEL;
  private int energyLevel = DEFAULT_ENERGY_LEVEL;
  private int hungerLevel = DEFAULT_HUNGER_LEVEL;
  private int thirstLevel = DEFAULT_THIRST_LEVEL;
  private int wasteLevel = DEFAULT_WASTE_LEVEL;
  private int funLevel = DEFAULT_FUN_LEVEL;

  private boolean isSleep;
  private String name = "";
  private String description = "";

  public VirtualPet() {

  }

  public VirtualPet(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public VirtualPet(int healthLevel, int energyLevel, int hungerLevel,
      int thirstLevel, int wasteLevel, int funLevel,
      boolean isSleep, String name, String description) {

    this.healthLevel = healthLevel;
    this.energyLevel = energyLevel;
    this.hungerLevel = hungerLevel;
    this.thirstLevel = thirstLevel;
    this.wasteLevel = wasteLevel;
    this.funLevel = funLevel;
    this.isSleep = isSleep;
    this.name = name;
    this.description = description;
  }

  public int getHealthLevel() {
    return healthLevel;
  }

  public int getEnergyLevel() {
    return energyLevel;
  }

  public int getHungerLevel() {
    return hungerLevel;
  }

  public int getThirstLevel() {
    return thirstLevel;
  }

  public int getWasteLevel() {
    return wasteLevel;
  }

  public int getFunLevel() {
    return funLevel;
  }

  public boolean isSleep() {
    if (energyLevel == 0) {
      return isSleep = true;
    }
    return isSleep;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  

  // public void feed() {
  //   if (energyLevel >= ENERGY_COST) {
  //     if (hungerLevel < MAX_NEED_LEVEL) {
  //       hungerLevel += HUNGER_GAIN;
  //     }
  //     if (wasteLevel < MAX_NEED_LEVEL) {
  //       wasteLevel += HUNGER_WASTE_GAIN;
  //     }
  //     if (healthLevel < MAX_NEED_LEVEL) {
  //       healthLevel += HEALTH_GAIN;
  //     }
  //     thirstLevel -= THIRST_COST;

  //     hungerLevel = Math.max(0, hungerLevel);
  //     wasteLevel = Math.max(0, wasteLevel);
  //     thirstLevel = Math.max(0, thirstLevel);
  //   }
  // }

  // public void hydrate() {
  //   if (energyLevel >= ENERGY_COST) {
  //     if (thirstLevel < MAX_NEED_LEVEL) {
  //       thirstLevel += THIRST_GAIN;
  //     }
  //     if (wasteLevel < MAX_NEED_LEVEL) {
  //       wasteLevel += THIRST_WASTE_GAIN;
  //     }
  //     if (hungerLevel < MAX_NEED_LEVEL) {
  //       hungerLevel += NEED_COST;
  //     }

  //     thirstLevel = Math.max(0, thirstLevel);
  //     wasteLevel = Math.max(0, wasteLevel);
  //     hungerLevel = Math.max(0, hungerLevel);
  //   }
  // }

  // public void useToilet() {
  //   if (energyLevel >= ENERGY_COST) {
  //     wasteLevel = Math.max(0, DEFAULT_WASTE_LEVEL - NEED_COST);
  //     hungerLevel -= NEED_COST;
  //     thirstLevel -= NEED_COST;

  //     hungerLevel = Math.max(0, hungerLevel);
  //     thirstLevel = Math.max(0, thirstLevel);
  //   }
  // }

  // public void play() {
  //   if (energyLevel >= ENERGY_COST) {
  //     if (funLevel < MAX_NEED_LEVEL) {
  //       funLevel += FUN_GAIN;
  //     }
  //     hungerLevel -= HUNGER_GAIN;
  //     thirstLevel -= THIRST_GAIN;
  //     energyLevel -= FUN_GAIN;

  //     funLevel = Math.max(0, funLevel);
  //     hungerLevel = Math.max(0, hungerLevel);
  //     thirstLevel = Math.max(0, thirstLevel);
  //     energyLevel = Math.max(0, energyLevel);
  //   }
  // }

  // public void sleep() {
  //   energyLevel = MAX_NEED_LEVEL;
  //   hungerLevel -= HUNGER_GAIN;
  //   thirstLevel -= HUNGER_GAIN;
  //   if (wasteLevel < MAX_NEED_LEVEL) {
  //     wasteLevel += HUNGER_GAIN;
  //   }

  //   hungerLevel = Math.max(0, hungerLevel);
  //   thirstLevel = Math.max(0, thirstLevel);
  //   wasteLevel = Math.max(0, wasteLevel);
  // }

  // public void tick() {
  //   energyLevel -= NEED_COST;
  //   hungerLevel -= NEED_COST;
  //   thirstLevel -= NEED_COST;
  //   if (wasteLevel < MAX_NEED_LEVEL) {
  //     wasteLevel += NEED_COST;
  //   }
  //   funLevel -= NEED_COST;
  //   energyLevel = Math.max(0, energyLevel);
  //   hungerLevel = Math.max(0, hungerLevel);
  //   thirstLevel = Math.max(0, thirstLevel);
  //   wasteLevel = Math.max(0, wasteLevel);
  //   funLevel = Math.max(0, funLevel);
  //   if (energyLevel == 0) {
  //     healthLevel -= HEALTH_COST;
  //   }
  //   if (hungerLevel == 0) {
  //     healthLevel -= HEALTH_COST;
  //   }
  //   if (thirstLevel == 0) {
  //     healthLevel -= HEALTH_COST;
  //   }
  //   if (wasteLevel > 10) {
  //     healthLevel -= HEALTH_COST;
  //   }
  //   if (funLevel == 0) {
  //     healthLevel -= HEALTH_COST;
  //   }
  // }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "name=" + name + "[healthLevel=" + healthLevel + ", energyLevel=" + energyLevel + ", hungerLevel=" + hungerLevel
        + ", thirstLevel=" + thirstLevel + ", wasteLevel=" + wasteLevel + ", funLevel=" + funLevel + ", isSleep="
        + isSleep + ", description=" + description + "]";
  }

  
}
