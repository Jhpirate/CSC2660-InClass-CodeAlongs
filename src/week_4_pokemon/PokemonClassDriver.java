package week_4_pokemon;

public class PokemonClassDriver {
    public static void main(String[] args) {
        BasePokemon bulbasaur = new GrassType("bulbasaur", "Grass", 75, 8);
        BasePokemon pikachu = new BasePokemon("pikachu", "Electric", 150, 15);
        BasePokemon charizard = new BasePokemon("charizard", "Fire", 500, 50);
        BasePokemon squirtle = new BasePokemon("Squirtle", "Water", 50, 5);

        System.out.println("charizard attacks pikachu:");
        pikachu.defend(charizard);
        System.out.println(pikachu);


        System.out.println("\n" + bulbasaur);
        System.out.println("bulb defends against squirtle:");
        bulbasaur.defend(squirtle);
        System.out.println(bulbasaur);
        "test %s".formatted(1);
    }
}

class BasePokemon {
    private final String name;
    protected String pokeType;
    protected int fullHPValue; //max life value
    protected int attackPoints;
    protected int currentHPValue; //current life value

    public BasePokemon(String name, String pokeType, int fullHPValue, int attackPoints) {
        this.name = name;
        this.pokeType = pokeType;
        this.fullHPValue = fullHPValue;
        this.attackPoints = attackPoints;
        this.currentHPValue = fullHPValue;
    }

    // Defend
    public void defend(BasePokemon attackingPokemon) {
        this.currentHPValue -= attackingPokemon.attackPoints;
    }

    //Attack
    public void attack(BasePokemon defendingPokemon) {
        defendingPokemon.currentHPValue -= this.attackPoints;
    }

    // check if the Pokémon is currently alive
    public boolean isAlive() {
        return this.currentHPValue > 0;
    }

    // Reset the Pokémon health to full
    public void revive() {
        this.currentHPValue = fullHPValue;
    }


    @Override
    public String toString() {
        return "Normal{" +
                "name='" + name + '\'' +
                ", pokeType='" + pokeType + '\'' +
                ", fullHPValue=" + fullHPValue +
                ", attackPoints=" + attackPoints +
                ", currentHP=" + currentHPValue +
                '}';
    }
}

class GrassType extends BasePokemon {

    public GrassType(String name, String pokeType, int fullHPValue, int attackPoints) {
        super(name, pokeType, fullHPValue, attackPoints);
    }

    @Override
    public void defend(BasePokemon attackingPokemon) {
        if (attackingPokemon.pokeType.equals("Fire")) {
            // if defending against fire, fire attack does extra damage to the defender
            this.currentHPValue -= attackingPokemon.attackPoints * 1.5;
        } else if (attackingPokemon.pokeType.equalsIgnoreCase("Water")) {
            // if defending agent water, either fully heal or take half damage

            if ((int) (Math.random() * (100 - 1) + 1) > 95) {
                // random chance of fully healing when attacked by water
                revive();
            } else {
                // otherwise, damage is halved
                this.currentHPValue -= attackingPokemon.attackPoints / 2;
            }
        } else {
            // other type, just deduct damage
            this.currentHPValue -= attackingPokemon.attackPoints;
        }
    }
}

class FireType extends BasePokemon {
    private int intensity;

    public FireType(String name, String pokeType, int fullHPValue, int attackPoints) {
        super(name, pokeType, fullHPValue, attackPoints);
    }

}

class ElectricType {

}

class WaterType {

}