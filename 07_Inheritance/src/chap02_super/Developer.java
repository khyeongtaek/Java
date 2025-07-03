package chap02_super;


public class Developer extends Person{
    private String[] skills;

    public Developer(String name, String[] skills) {
        super(name);
        this.skills = skills;
        
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("기술: "+ String.join(", ", skills));
    }
}
