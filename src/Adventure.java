import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Random rand = new Random();


        //Game Variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin", "Goblin", "Phantom", "Rat"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player Variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // 50 percent chance to drop a health potion

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME://label
        while(running) {
            System.out.println("---------------------------------------------------");

            int enemyHealth = rand.nextInt(health);//Maximum value that the integer can be

            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.printf("\t# You run into a %s%n", enemy);

            while(enemyHealth > 0){
                System.out.printf("\tYour HP: %d%n", health);
                System.out.printf("\t %s's HP is: %d%n", enemy, enemyHealth);
                System.out.printf("\t What would you like to do?%n\t1. Attack%n\t2. Use Potion%n\t3. Run Away%n");

                String usersInput = in.nextLine();


                if (usersInput.equals("1") || usersInput.equalsIgnoreCase("Attack")){
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(enemyAttackDamage);

                        enemyHealth -= damageDealt;
                        health -= damageTaken;

                    System.out.printf("\t Your strike the %s for %d damage!%n\t You receive %d damage in retaliation!", enemy, damageDealt, damageTaken);

                    if (health < 1){
                        System.out.println("\t You have taken too much damage!, You are too weak to go on");
                    }

                } else if (usersInput.equalsIgnoreCase("2") || usersInput.equalsIgnoreCase("Use Potion")){
                    if(numHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.printf("\t You drink a health potion, healing yourself for %d%n\t Your health is now: %d%n\t You now have %d health potions remaining%n", healthPotionHealAmount, health, numHealthPotions);
                    } else {
                        System.out.printf("\t You currently do not have any health potions, defeat enemies for a chance to get one");
                    }

                } else if (usersInput.equals("3") || usersInput.equalsIgnoreCase("Run Away")){

                } else {

                }


            }



        }

    }
}
