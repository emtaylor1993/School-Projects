public class Student {
    /* Instance variables. */
    private String name;
    private int idNum;
    private int tokenLevel;

    /* Instance methods. */
    public void sayHello() {
        Student newStu = new Student();
        newStu.name = "Bob";
        newStu.setName("Bob");
        newStu.idNum = 91899109;
        newStu.tokenLevel = 3;
        System.out.print("Hi, my name is " + name);
        System.out.println(", and I have " + tokenLevel + " tokens.");
        System.out.println("I am friends with " + newStu.name);
    }

    public boolean equals(Student other) {
        if (other == null) {
            return false;
        } else if (other.name.equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    public void spendToken() {
        tokenLevel--;
    }

    public void acceptTokens(int numberOfTokensAccepted) {
        tokenLevel += numberOfTokensAccepted;
    }
    
    public void doProject(String project, int numPages) {
        int currPage = 1;

        while (currPage <= numPages) {
            System.out.println(name + " is working on page " + currPage);
            currPage++;
        }

        System.out.println(name + " is done with " + project);
    }

    public int getLastFourDigits() {
        int lastFour;
        lastFour = idNum % 10000;
        return lastFour;
    }

    public String eatLunch(String foodType, int amountOrdered) {
        String lunch = "";
        int numberEaten = 0;
        while (numberEaten < amountOrdered) {
            lunch += foodType + " ";
            numberEaten++;
        }

        return name + " has eaten " + lunch;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNumIn) {
        if (idNum >= 0) {
            idNum = idNumIn;
        } else {
            idNum = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public int getTokenLevel() {
        return tokenLevel;
    }

    public void setTokenLevel(int tokenLevelIn) {
        tokenLevel = tokenLevelIn;
    }
}
