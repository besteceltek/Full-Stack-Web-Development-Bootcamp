import java.lang.Math;

public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void fight() {
        if (checkWeight()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== NEW ROUND ========");
                if (checkFirst() == f1) {
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    printScore();
                } else {
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    printScore();
                }
            }
        } else {
            System.out.println("Boxers' weights are not acceptable.");
        }
    }

    public Fighter checkFirst() {
        double randomValue = Math.random() * 100;
        if (randomValue < 50) {
            return f1;
        } else {
            return f2;
        }
    }

    public boolean checkWeight() {
        return (f1.weight <= maxWeight && f1.weight >= minWeight) && (f2.weight <= maxWeight && f2.weight >= minWeight);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("The winner is: " + f2.name);
            return true;
        } else if (f2.health == 0) {
            System.out.println("The winner is: " + f1.name);
            return true;
        }
        return false;
    }

    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Remaining Health \t: " + f1.health);
        System.out.println(f2.name + " Remaining Health \t: " + f2.health);
    }

}
