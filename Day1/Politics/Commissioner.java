class Commissioner extends Person{
    Commissioner(String name,int age){
        super(name,age);
    }
    public static void canArrest(MP person){
        if(person.exceedsSpendingLimit()){
            System.out.println(person.getName()+" Can be arrested.");
        }
        else if(PM.getInstance().getPermission(person.getName())){
            System.out.println(person.getName()+" Can be arrested with the permission of PM.");
        }
        else{
            System.out.println(person.getName()+" Cannot be arrested without any reason");
        }
    }
    public static void canArrest(Minister person){
        if(person.exceedsSpendingLimit() && PM.getInstance().getPermission(person.getName())){
            System.out.println(person.getName()+" Can be arrested with the permission of PM.");
        }else{
            System.out.println(person.getName()+" Cannot be arrested without the permission of PM.");
        }
    }
    public static void canArrest(PM person){
        System.out.println(person.getName()+" Cannot be arrested as he is the PM.");
    }
}
