abstract class Enemy {
    public abstract void attack();
}

class EasyEnemy extends Enemy {
    public void attack() {
        System.out.println("Easy enemy attacks!");
    }
}

class HardEnemy extends Enemy {
    public void attack() {
        System.out.println("Hard enemy attacks!");
    }
}

class EnemyFactory {
    public static Enemy createEnemy(String difficulty) {
        if (difficulty.equals("easy")) {
            return new EasyEnemy();
        } else {
            return new HardEnemy();
        }
    }
}

abstract class Weapon {
    public abstract void use();
}

class EasyWeapon extends Weapon {
    public void use() {
        System.out.println("Easy weapon used!");
    }
}

class HardWeapon extends Weapon {
    public void use() {
        System.out.println("Hard weapon used!");
    }
}

abstract class PowerUp {
    public abstract void activate();
}

class EasyPowerUp extends PowerUp {
    public void activate() {
        System.out.println("Easy power-up activated!");
    }
}

class HardPowerUp extends PowerUp {
    public void activate() {
        System.out.println("Hard power-up activated!");
    }
}

abstract class GameFactory {
    public abstract Weapon createWeapon();
    public abstract PowerUp createPowerUp();
}

class EasyGameFactory extends GameFactory {
    public Weapon createWeapon() {
        return new EasyWeapon();
    }
    public PowerUp createPowerUp() {
        return new EasyPowerUp();
    }
}

class HardGameFactory extends GameFactory {
    public Weapon createWeapon() {
        return new HardWeapon();
    }
    public PowerUp createPowerUp() {
        return new HardPowerUp();
    }
}

class GameState {
    private static GameState instance;
    private GameState() {}
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    public void play(String difficulty) {
        Enemy enemy = EnemyFactory.createEnemy(difficulty);
        GameFactory gameFactory = difficulty.equals("easy") ? new EasyGameFactory() : new HardGameFactory();
        Weapon weapon = gameFactory.createWeapon();
        PowerUp powerUp = gameFactory.createPowerUp();
        enemy.attack();
        weapon.use();
        powerUp.activate();
    }
}

public class Week_3_in_Lab {
    public static void main(String[] args) {
        GameState game = GameState.getInstance();
        game.play("easy");
        game.play("hard");
    }
}
